/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gaiatosfc.DAO;

import br.com.gaiatosfc.model.Jogadores;
import java.util.List;

/**
 *
 * @author SUPORTE03
 */
public interface JogadoresDAO {
   void salvar(Jogadores jogador) throws DAOException;
   void atualizar(Jogadores jogador) throws DAOException;
   void deletar(Jogadores jogador) throws DAOException;
   List<Jogadores> findAllJogadorID(Integer id) throws DAOException;
   List<Jogadores> findAllJogadores() throws DAOException;
}
