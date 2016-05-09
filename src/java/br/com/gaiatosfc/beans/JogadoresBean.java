/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gaiatosfc.beans;

import br.com.gaiatosfc.DAO.JogadoresDAOImp;
import br.com.gaiatosfc.commons.DAOException;
import br.com.gaiatosfc.model.Jogadores;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "jogadorBean")
@RequestScoped
public class JogadoresBean {
    
    private Jogadores jogador;
    private List<String> numeroDaCamisa;
    
    @PostConstruct
    public void init() throws DAOException{
        
    }
    
    public JogadoresBean() throws DAOException{
        jogador = new Jogadores();
        this.numeroDaCamisa = new JogadoresDAOImp().findAllNumeroCamisa();
    }
    
    
    public List<String> getNumeroDaCamisa() {
        return numeroDaCamisa;
    }

    public void setNumeroDaCamisa(List<String> numeroDaCamisa) {
        this.numeroDaCamisa = numeroDaCamisa;
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
            
        } catch (Exception e) {
            
            fm = new FacesMessage(
                FacesMessage.SEVERITY_WARN,e.getMessage(),null);            
        }
        
        FacesContext.getCurrentInstance().addMessage(null, fm);
        
    }
    
    public Set<String> numeroCamisa() throws DAOException{
      
        
        List<String> listaSelectItems = new ArrayList<>();

        for(int i = 1; i < 21; i++){
            for (String c : numeroDaCamisa) {
                int j = Integer.parseInt(c);
                if(j != i){
                    String item = String.valueOf(i);
                    listaSelectItems.add(item);
                }
            }
        }
        Set<String> lista = new HashSet<>();
        lista.addAll(listaSelectItems);
        return lista;
    }
    
    public Jogadores getJogador(){
        return jogador;
    }
    
    public void setJogador(Jogadores jogador){
        this.jogador = jogador;
    }
    
}
