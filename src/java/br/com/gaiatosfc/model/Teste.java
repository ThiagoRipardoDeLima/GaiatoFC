/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gaiatosfc.model;

import br.com.gaiatosfc.DAO.JogadoresDAOImp;
import br.com.gaiatosfc.commons.DAOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.swing.JOptionPane;

/**
 *
 * @author FERNANDO
 */
public class Teste {
    public static void main(String[] args) throws DAOException{
        
        JogadoresDAOImp j = new JogadoresDAOImp();/*
        List<Integer> jogador = j.findAllNumeroCamisa();
        List<SelectItem> listaSelectItems = new ArrayList<>();
        
        for (Integer c : jogador) {
            SelectItem item = new SelectItem(c.toString());
            JOptionPane.showMessageDialog(null,"Numero: " + c);
            listaSelectItems.add(item);
        }
        
        
        List<Jogadores> jogador1 = j.findAllJogadores();
        List<SelectItem> listaSelectItems1 = new ArrayList<>();
        
        for (Jogadores c : jogador1) {
            SelectItem item = new SelectItem(c.getNumeroCamisa());
            JOptionPane.showMessageDialog(null, " Nome: " + c.getNomeJd()                   + 
                                                " Numero Camisa: " + c.getNumeroCamisa()    +
                                                " Data Nascimento: " + c.getDataNasc()      +
                                                " Posicao: " + c.getPosicao()               +
                                                " Jogos Disputados: " + c.getJogosDisputados() +
                                                " Gols: " + c.getGols());
            listaSelectItems1.add(item);
        }
        */
        
        Jogadores jo = new Jogadores();
        jo.setNomeJd("Teste1");
        
        j.salvar(jo);
        
        
        
    }
}
