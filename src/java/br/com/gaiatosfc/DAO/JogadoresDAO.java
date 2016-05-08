/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gaiatosfc.DAO;

import br.com.gaiatosfc.model.Jogadores;
import br.com.gaiatosfc.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author FERNANDO
 */
public class JogadoresDAO{
    
    
    public void salvar(Jogadores jogador) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(jogador);
        t.commit();        
    }
}
