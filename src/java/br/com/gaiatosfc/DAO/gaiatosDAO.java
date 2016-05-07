/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gaiatosfc.DAO;

import java.io.Serializable;
import java.util.List;



/**
 *
 * @author SUPORTE03
 */
public interface gaiatosDAO<T> {
   void salvar(T objeto);
   void atualizar(T objeto);
   void deletar(T objeto);
   T getObjetoId(Serializable id);
   List<T> getObjetos();
}
