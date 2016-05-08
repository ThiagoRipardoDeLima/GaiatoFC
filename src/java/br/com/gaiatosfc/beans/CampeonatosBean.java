/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gaiatosfc.beans;

import br.com.gaiatosfc.DAO.CampeonatosDAO;
import br.com.gaiatosfc.model.Campeonatos;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;

@ManagedBean(name = "campeonatoBean")
@RequestScoped
public class CampeonatosBean {
    
    private Campeonatos campeonato;
    
    public CampeonatosBean(){
        campeonato = new Campeonatos();
    }
    
    public void cadastrarNovoCampeonato() {
        
    
        FacesMessage fm = new FacesMessage();
        
        try {
            
            if (campeonato==null) {
                throw new Exception("O objeto nao foi criado");
            }
            
            CampeonatosDAO campeonatoDao = new CampeonatosDAO();
            campeonatoDao.salvar(campeonato);
            System.out.println("Cadastro Efetuado!!");
            
            /*
            this.getListaAlunos();
            novoAluno=new Aluno();
            */
            String successMsg="Novo usuario cadastrado com sucesso!";
            
            fm = new FacesMessage(
                FacesMessage.SEVERITY_INFO,successMsg,null);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao Cadastrou!!");
            fm = new FacesMessage(
                FacesMessage.SEVERITY_WARN,e.getMessage(),null);            
        }
        
        FacesContext.getCurrentInstance().addMessage(null, fm);
        
    }
    
    public Campeonatos getCampeonato(){
        return campeonato;
    }
    
    public void setCampeonato(Campeonatos campeonato){
        this.campeonato = campeonato;
    }
    
}
