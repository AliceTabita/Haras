/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.model.valid.exceptions;

/**
 *
 * @author alice
 */
public class InvalidCpfException extends RuntimeException {
    public InvalidCpfException(String msg, Throwable cause){
        super(msg,cause);
    }
    public InvalidCpfException(String msg){
        super(msg);
    }

}
