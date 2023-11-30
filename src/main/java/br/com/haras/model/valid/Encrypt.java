/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.model.valid;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author alice
 */
public class Encrypt {
    private byte[] salt;
    
    public byte[] Encrypt(String password){
        try{
            this.generateSalt();
            KeySpec spec =new PBEKeySpec(password.toCharArray(),this.salt,65536,128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded(); 
            return hash;
        }catch(GeneralSecurityException e){
            System.out.println("Não foi possível gerar hash");   
        }
        return null;
    }
    public byte[] Encrypt(String password,byte[] salt){
        try{
            this.generateSalt();
            KeySpec spec =new PBEKeySpec(password.toCharArray(),salt,65536,128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded(); 
            return hash;
        }catch(GeneralSecurityException e){
            System.out.println("Não foi possível gerar hash");   
        }
        return null;
    }
    private void generateSalt(){
        SecureRandom random = new SecureRandom();
        salt = new byte[32]; 
        random.nextBytes(salt);
    }
    public byte[] getSalt(){
        return this.salt;
    }
}
