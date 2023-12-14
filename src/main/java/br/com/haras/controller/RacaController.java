/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.controller;

import br.com.haras.model.Raca;
import br.com.haras.model.dao.RacaDao;
import br.com.haras.model.tables.TMRaca;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author alice
 */
public class RacaController {
    RacaDao racaDao;
    public RacaController(){
        racaDao = new RacaDao();
    }
    public  TMRaca atualizarTabela(){
        List<Raca> lsRaca = racaDao.findAll();
        return new TMRaca(lsRaca);
    }
    public String save(String id, String nome, String descricao, String vlBaseRaca){
       try{
           System.out.println(vlBaseRaca);
            String vlBaseReplace = vlBaseRaca.replaceAll("[^\\d.,]", "").replace(",", ".");
            BigDecimal vlBase = new BigDecimal(vlBaseReplace);
            int idRaca = Integer.valueOf(id);
            if(idRaca != 0){
                Raca raca = racaDao.find(idRaca);
                raca.setDescricao(descricao);
                raca.setNome(nome);
                raca.setVlBaseRaca(vlBase);
                racaDao.update(raca);
            }else{
                Raca raca = new Raca();
                raca.setDescricao(descricao);
                raca.setNome(nome);
                raca.setVlBaseRaca(vlBase);
                racaDao.save(raca);
            }
       }catch(Exception e){
           e.printStackTrace();
           return "Erro ao salvar raça, tente novamente.";
       }
        
        return null;
    }
   
}
