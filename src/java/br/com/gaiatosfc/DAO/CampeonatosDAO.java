/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gaiatosfc.DAO;

import br.com.gaiatosfc.commons.DAOException;
import br.com.gaiatosfc.model.Campeonatos;
import br.com.gaiatosfc.model.Jogadores;
import java.util.List;

/**
 *
 * @author FERNANDO
 */
public interface CampeonatosDAO{
    
   void salvar(Campeonatos campeonato) throws DAOException;
   void atualizar(Campeonatos campeonato) throws DAOException;
   void deletar(Campeonatos campeonato) throws DAOException;
   List<Jogadores> findAllCampeonatosID(Integer id) throws DAOException;
   List<Jogadores> findAllCampeonatos() throws DAOException;
   
}
