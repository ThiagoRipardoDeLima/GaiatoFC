/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gaiatosfc.model;

import br.com.gaiatosfc.util.HibernateUtil;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author FERNANDO
 */
public class Teste {
    public static void main(String[] args){
        Jogadores j = new Jogadores();
        j.setNomeJd("Thiago");
        
        
        try{
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.save(j);
        t.commit();
            JOptionPane.showMessageDialog(null, "Inserido!!!");
        }catch(Exception e){
            System.out.println("Nao Incluiu: " + e.getMessage());
        }
    }
}
