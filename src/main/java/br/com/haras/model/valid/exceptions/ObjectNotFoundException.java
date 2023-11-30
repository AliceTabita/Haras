/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.model.valid.exceptions;

/**
 *
 * @author alice
 */
public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String msg, Throwable cause){
        super(msg,cause);
    }
    public ObjectNotFoundException(String msg){
        super(msg);
    }

}
