/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gaiatosfc.DAO;

import br.com.gaiatosfc.commons.DAOException;
import br.com.gaiatosfc.model.Campeonatos;
import br.com.gaiatosfc.model.Jogadores;
import br.com.gaiatosfc.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author FERNANDO
 */
public class CampeonatosDAOImp implements CampeonatosDAO{
    
    
    @Override
    public void salvar(Campeonatos campeonato) throws DAOException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            session.save(campeonato);
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
    public void atualizar(Campeonatos campeonato) throws DAOException {
         Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            session.update(campeonato);
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
    public void deletar(Campeonatos campeonato) throws DAOException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            session.delete(campeonato);
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
    public List<Jogadores> findAllCampeonatosID(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
    public List<Jogadores> findAllCampeonatos() throws DAOException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            List allCampeonatos = session
                    .createQuery("from campeonatos C order by C.nome_camp asc")
                    .list();
            t.commit();
            return allCampeonatos;
        }catch(Exception e){
            throw new DAOException("Nenhum Campeonato Cadastrao " + e);
        }finally{
            if(session != null){
                session.close();
            }
        }
    }


}
