/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gaiatosfc.DAO;

import br.com.gaiatosfc.commons.DAOException;
import br.com.gaiatosfc.model.Adversarios;
import br.com.gaiatosfc.model.Jogadores;
import java.util.List;

/**
 *
 * @author FERNANDO
 */
public interface AdversariosDAO {
   void salvar(Adversarios jogador) throws DAOException;
   void atualizar(Adversarios jogador) throws DAOException;
   void deletar(Adversarios jogador) throws DAOException;
   List<Adversarios> findAllJogadorID(Integer id) throws DAOException;
   List<Adversarios> findAllJogadores() throws DAOException;
}
