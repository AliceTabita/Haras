/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.controller.service;

import br.com.haras.model.MensagemModel;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 *
 * @author alice
 */

public class EmailService {
    private String sender;
    private String password;
    private String codeEmail;
    public EmailService(){
        this.getSender();
    }
    
    public MensagemModel htmlEmailCodeSender(String toEmail, String nome, String code){
         // Create the email message
        MensagemModel msg = new MensagemModel(false,"");
        HtmlEmail email = new HtmlEmail();
        email.setHostName("mail.myserver.com");
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthentication(this.sender, this.password);
        email.setSSLOnConnect(true);
        try{
            email.setFrom(sender, "Haras");
            email.setSubject("Código de Verificação");
            email.addTo(toEmail, nome);

            String html = this.prepareHtmlCode(nome, code);
            email.setHtmlMsg(html);

            email.setTextMsg("Your email client does not support HTML messages");

            email.send();
            
            msg.setSucesso(true);
        }catch(EmailException e){
             if (e.getMessage().equals("Invalid Addresses")) {
                msg.setMensagem("Invalid email");
            } else {
                msg.setMensagem("Erro");
            }
        }
        return msg;
    }
    private void getSender(){
       Properties properties = new Properties();
       try{
           URL resource = getClass().getResource("/email.properties");
           FileInputStream fis = new FileInputStream(resource.getPath());
           properties.load(fis);
       }catch(IOException e){
           e.printStackTrace();
       }
       this.sender = properties.getProperty("email.sender");
       this.password = properties.getProperty("email.password");
       
   }
    private String readHtmlCodeEmail(){
        try (InputStream is = getClass().getResourceAsStream("/emails/codeEmail.txt");
             InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {

            StringBuilder conteudo = new StringBuilder();
            String linha;

            while ((linha = br.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }

            return conteudo.toString();

        } catch (IOException e) {
            e.printStackTrace(); 
            return null;
        }
    }
    
    private String prepareHtmlCode(String nome, String codigo){
        String html = this.readHtmlCodeEmail();
        html = html.replace("{{NOME}}", nome);
        html = html.replace("{{CODIGO}}", codigo);

        return html;
    }
   
}
