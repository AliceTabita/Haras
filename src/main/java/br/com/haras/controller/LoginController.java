/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.controller;

import br.com.haras.model.dao.UsuarioDao;
import br.com.haras.model.Usuario;
import br.com.haras.model.valid.Encrypt;
import java.util.Arrays;
/**
 *
 * @author alice
 */
public class LoginController {
    UsuarioDao usuarioDao;

    public LoginController() {
        usuarioDao= new UsuarioDao();
    }
    public boolean validaLogin(String email, String senha){
        Usuario usuario = usuarioDao.findByEmail(email);
        if(usuario != null){
           return this.validaSenha(usuario.getSenha(),usuario.getSalt(),senha);
        }
        return false;   
    } 
    public boolean validaSenha(byte[] hash, byte[] salt, String senha){
        Encrypt encrypt = new Encrypt();
        byte[] senhaInserida = encrypt.Encrypt(senha, salt);
        return Arrays.equals(hash, senhaInserida);
    }
    
}
