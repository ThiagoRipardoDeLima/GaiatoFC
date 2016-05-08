/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gaiatosfc.DAO;

import br.com.gaiatosfc.commons.DAOException;
import br.com.gaiatosfc.model.Adversarios;
import br.com.gaiatosfc.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author FERNANDO
 */
public class AdversariosDAOImp implements AdversariosDAO {

    @Override
    public void salvar(Adversarios jogador) throws DAOException {
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
    public void atualizar(Adversarios jogador) throws DAOException {
       Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            session.update(jogador);
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
    public void deletar(Adversarios jogador) throws DAOException {
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
    public List<Adversarios> findAllJogadorID(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Adversarios> findAllJogadores() throws DAOException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            List allAdversarios = session
                    .createQuery("from Adversarios A order by A.nome asc")
                    .list();
            t.commit();
            return allAdversarios;
        }catch(Exception e){
            throw new DAOException("Nenhum Jogador localizado: " + e);
        }finally{
            if(session!=null){
                session.close();
            }
        }
    }
    
}
