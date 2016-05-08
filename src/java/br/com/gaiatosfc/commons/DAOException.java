/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gaiatosfc.commons;

/**
 *
 * @author FERNANDO
 */
public class DAOException extends Exception {
    
    /*
    *Construtor default
    */
    public DAOException(){
    }
    /*
    *Construtor
    *@paran message
    */
    public DAOException(String message){
        super(message);
    }
    /*
    *Construtor
    *@param cause
    */
    public DAOException(Throwable cause){
        super(cause);
    }
    /*
    *Construtor
    *@param message
    *@param cause
    */
    public DAOException(String message, Throwable cause){
        super(message, cause);
    }
    
}
