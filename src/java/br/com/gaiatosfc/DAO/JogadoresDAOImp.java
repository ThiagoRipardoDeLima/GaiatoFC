/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gaiatosfc.DAO;

import br.com.gaiatosfc.commons.DAOException;
import br.com.gaiatosfc.model.Jogadores;
import br.com.gaiatosfc.util.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author FERNANDO
 */
public class JogadoresDAOImp implements JogadoresDAO{
    
    
    @Override
    public void salvar(Jogadores jogador) throws DAOException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            session.save(jogador);
            t.commit();
            
        }catch(Exception e){
            session.getTransaction().rollback();
            throw new DAOException(e);
        }finally{
            if(session!=null){
                session.close();
            }
        }
            
        
        
    }

    @Override
    public void atualizar(Jogadores jogador) throws DAOException {
         Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            
            session.merge(jogador);
            t.commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            throw new DAOException(e);
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public void deletar(Jogadores jogador) throws DAOException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            session.delete(jogador);
            t.commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            throw new DAOException(e);
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public List<Jogadores> findAllJogadorID(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Jogadores> findAllJogadores() throws DAOException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            List allJogadores = session
                    .createQuery("FROM Jogadores J order by J.nomeJd asc")
                    .list();
            t.commit();
            return allJogadores;
        }catch(Exception e){
            throw new DAOException("Nenhum Jogador Cadastrado: " + e);
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }
    
    public List<String> findAllNumeroCamisa() throws DAOException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            List allnumeroCamisa = session
                    .createQuery("SELECT J.numeroCamisa FROM Jogadores J ORDER BY J.numeroCamisa asc")
                    .list();
            t.commit();
            return allnumeroCamisa;
        }catch(Exception e){
            throw new DAOException("Nenhum Jogador Cadastrado: " + e);
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }
}
