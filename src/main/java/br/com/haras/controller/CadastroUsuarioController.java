/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.controller;

import br.com.haras.controller.service.EmailService;
import br.com.haras.model.dao.ClienteDao;
import br.com.haras.model.dao.UsuarioDao;
import br.com.haras.model.valid.CPFValidator;
import br.com.haras.model.valid.exceptions.InvalidCpfException;
import br.com.haras.model.valid.exceptions.ObjectNotFoundException;
import br.com.haras.model.Cliente;
import br.com.haras.model.MensagemModel;
import br.com.haras.model.Usuario;
import br.com.haras.model.enums.Status;
import br.com.haras.model.valid.Encrypt;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Properties;
import java.util.Random;
/**
 *
 * @author alice
 */
public class CadastroUsuarioController {

    ClienteDao clienteDao;
    UsuarioDao usuarioDao;
    public CadastroUsuarioController() {
       clienteDao = new ClienteDao();
       usuarioDao = new UsuarioDao();
    }
    
    public String cadastrar(String cpf, String senha){
        try{
            CPFValidator.isValidCPF(cpf);
            if(this.usuarioDuplicado(cpf)){
                return "Usuário já cadastrado";
            }
            Usuario usuario = usuarioDao.findByCpfStatus(cpf, Status.PENDENTE);
            String code = this.generateVerifyCode();
            if(usuario == null){
                usuario = new Usuario();
                Cliente cliente = clienteDao.findByCpf(cpf);
                usuario = mapClienteUsuario(cliente,code);
                Encrypt encrypt = new Encrypt();
                usuario.setSenha(encrypt.Encrypt(senha));
                usuario.setSalt(encrypt.getSalt());
                cliente.setUsuario(usuario);
                
                
                clienteDao.update(cliente);
            }else{
                usuario.setCdVerificacao(code);
                Encrypt encrypt = new Encrypt();
                usuario.setSenha(encrypt.Encrypt(senha));
                usuario.setSalt(encrypt.getSalt());
                
                usuarioDao.update(usuario);
            }
           
        }catch(InvalidCpfException e){
            return e.getMessage();
        }catch(ObjectNotFoundException e){
            return e.getMessage() + " Caso já seja cliente, entre em contato com nossos atendentes.";
        }catch(Exception e){
            return "Erro ao cadastrar usuário";
        }
        return null;
    }
    private Usuario mapClienteUsuario(Cliente cliente, String cdVerificacao){
        Usuario usuario = new Usuario();
        usuario.setNmUsuario(cliente.getNome());
        usuario.setCdCpfCnpj(cliente.getCpf());
        usuario.setEmail(cliente.getEmail());
        usuario.setCdVerificacao(cdVerificacao);
        usuario.setStatus(Status.PENDENTE);
        usuario.setEmail(cliente.getEmail());
        //usuario.setTpUsuario(tpUsuario);
        return usuario;
    }
    private String generateVerifyCode(){
        DecimalFormat df =new DecimalFormat("000000");
        Random ran = new Random();
        String code = df.format(ran.nextInt());
        return code;
    }
   private boolean usuarioDuplicado(String cpf){
       Usuario usuario = usuarioDao.findByCpfStatus(cpf, Status.ATIVO);
       return usuario !=null;
   }
   public MensagemModel sendEmail(String cpf){
       Usuario usuario = usuarioDao.findByCpfStatus(cpf, Status.PENDENTE);
       
       EmailService emailService = new EmailService();
       
       return emailService.htmlEmailCodeSender(usuario.getEmail(), usuario.getNmUsuario(), usuario.getCdVerificacao());
   }
   public boolean validaCodigo(String cdDigitado, String cpf){
       Usuario usuario = usuarioDao.findByCpfStatus(cpf, Status.PENDENTE);
       if(usuario.getCdVerificacao().equals(cdDigitado)){
           usuario.setStatus(Status.ATIVO);
           usuarioDao.update(usuario);
           return true;
       }else{
           return false;
       }
   }
   
}
