/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gaiatosfc.beans;

import br.com.gaiatosfc.DAO.JogadoresDAO;
import br.com.gaiatosfc.model.Jogadores;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;

@ManagedBean(name = "jogadorBean")
@RequestScoped
public class JogadoresBean {
    
    private Jogadores jogador;
    
    public JogadoresBean(){
        jogador = new Jogadores();
    }
    
    public void cadastrarNovoJogador() {
        
    
        FacesMessage fm = new FacesMessage();
        
        try {
            
            if (jogador==null) {
                throw new Exception("O objeto n?o foi criado");
            }
            
            JogadoresDAO jogadorDao = new JogadoresDAO();
            jogadorDao.salvar(jogador);
            System.out.println("Cadastro Efetuado!!");
            
            /*
            this.getListaAlunos();
            novoAluno=new Aluno();
            */
            String successMsg="Novo usu?rio cadastrado com sucesso!";
            
            fm = new FacesMessage(
                FacesMessage.SEVERITY_INFO,successMsg,null);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao Cadastrou!!");
            fm = new FacesMessage(
                FacesMessage.SEVERITY_WARN,e.getMessage(),null);            
        }
        
        FacesContext.getCurrentInstance().addMessage(null, fm);
        
    }
    
    public Jogadores getJogador(){
        return jogador;
    }
    
    public void setJogador(Jogadores jogador){
        this.jogador = jogador;
    }
    
}
