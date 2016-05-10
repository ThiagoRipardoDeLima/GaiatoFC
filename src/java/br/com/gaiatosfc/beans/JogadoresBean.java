/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gaiatosfc.beans;

import br.com.gaiatosfc.DAO.JogadoresDAOImp;
import br.com.gaiatosfc.commons.DAOException;
import br.com.gaiatosfc.model.Jogadores;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean(name = "jogadorBean")
@SessionScoped
public class JogadoresBean {
    
    
    private Jogadores jogador;
    private List<String> numeroDaCamisa;
    private List<Jogadores> allJogadores;
    private DataModel listaJogadores;

    
    
    @PostConstruct
    public void init(){
        try {
            this.numeroDaCamisa = new JogadoresDAOImp().findAllNumeroCamisa();
            this.allJogadores = new JogadoresDAOImp().findAllJogadores();
        } catch (DAOException ex) {
            Logger.getLogger(JogadoresBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public JogadoresBean() throws DAOException{
        jogador = new Jogadores();  
    }
    
    public DataModel getListaJogadores() throws DAOException {
        List<Jogadores> lista = new JogadoresDAOImp().findAllJogadores();
        listaJogadores = new ListDataModel(lista);
        return listaJogadores;
    }
    
    public void prepararAlterarJogador(ActionEvent actionEvent){
        jogador = (Jogadores)(listaJogadores.getRowData());
    }

    public List<String> getNumeroDaCamisa() {
        return numeroDaCamisa;
    }

    public void setNumeroDaCamisa(List<String> numeroDaCamisa) {
        this.numeroDaCamisa = numeroDaCamisa;
    }

    public List<String> numeroCamisa() throws DAOException{
        List<String> listaSelectItems = new ArrayList<>();
        for(int i = 1; i < 21; i++){
            listaSelectItems.add(String.valueOf(i));
        }
        Iterator<String> it = listaSelectItems.iterator();
        while(it.hasNext()){
            if(numeroDaCamisa.contains(it.next())){
                it.remove();
            }
        }
        return listaSelectItems;
    }
    
    public Jogadores getJogador(){
        return jogador;
    }
    
    public void setJogador(Jogadores jogador){
        this.jogador = jogador;
    }
    
    public void setAllJogadores(List<Jogadores> allJogadores) {
        this.allJogadores = allJogadores;
    }
    
    public List<Jogadores> getAllJogadores() {
        return allJogadores;
    }
    
    public void cadastrarNovoJogador() {
        FacesMessage fm = new FacesMessage();
        try {
            if (jogador==null) {
                throw new Exception("O objeto não foi criado");
            }
            JogadoresDAOImp jogadorDao = new JogadoresDAOImp();
            jogadorDao.salvar(jogador);
            String successMsg="Jogador Cadastrado";
            fm = new FacesMessage(
                FacesMessage.SEVERITY_INFO,successMsg,null);
            jogador = new Jogadores();
            init();
        } catch (Exception e) {
            
            fm = new FacesMessage(
                FacesMessage.SEVERITY_WARN,e.getMessage(),null);            
        }
        
        FacesContext.getCurrentInstance().addMessage(null, fm);
        
    }
    
    public String removerJogador(ActionEvent actionEvent) throws DAOException{
        Jogadores jogadorTemp = (Jogadores)(listaJogadores.getRowData());
        JogadoresDAOImp jogadorDao = new JogadoresDAOImp();
        jogadorDao.deletar(jogadorTemp);
        return "cadastrarJogador";
    }
    
    public void excluir(ActionEvent actionEvent) throws DAOException{
                FacesMessage fm = new FacesMessage();
		new JogadoresDAOImp().deletar(jogador);
                String successMsg="Jogador Deletado";
                fm = new FacesMessage(
                FacesMessage.SEVERITY_INFO,successMsg,null);
		
		jogador = new Jogadores();
                init();
	}
    
    public void atualizarJogador(ActionEvent event) throws DAOException{
        JogadoresDAOImp jogadorDao = new JogadoresDAOImp();
        jogadorDao.atualizar(jogador);
        init();
    }
    
}
