/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.controller;

import br.com.haras.model.Cliente;
import br.com.haras.model.dao.EquinoDao;
import java.util.HashMap;
import br.com.haras.model.Equino;
import br.com.haras.model.Raca;
import br.com.haras.model.dao.RacaDao;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alice
 */
public class EquinoController {
    private EquinoDao equinoRepository;
    private RacaDao racaDao;
    private ClienteController cliController;
    private final String formatoData = "dd/MM/yyyy";
    
    public EquinoController(){
        equinoRepository = new EquinoDao();
        racaDao = new RacaDao();
        cliController = new ClienteController();
    }
    public String save(HashMap<String,String> equinoInfo, Cliente cliente){
        //verficar se existe o idEquino no hashmap

        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern(formatoData);
        try{
            int idRaca =Integer.parseInt(equinoInfo.get("idRaca"));
            
            Raca raca = racaDao.find(idRaca);
            if(raca == null){
                return "Erro ao recuperar as informações de Raça, tente novamente.";
            }
            LocalDate dataNascimento = LocalDate.parse(equinoInfo.get("dtNascimento"),formato);
            if(dataNascimento.isAfter(LocalDate.now())){
                return "Data de nascimento não pode ser maior que a data de hoje.";
            }
            if (cliente == null) {
                return "É necessário selecionar um proprietário";
            }
            
            if(equinoInfo.get("vlCustoMensal") == null || equinoInfo.get("vlCustoMensal").isEmpty()){
                return "É necessário realizar o calculo antes de prosseguir";
            }
            
            if(equinoInfo.get("idEquino")== null){
                Equino novoEquino =new Equino();
                Cliente clienteFind = cliController.buscaClientePorId(cliente.getIdCliente());
                if(clienteFind == null){
                    return "Erro ao recuperar informações do cliente, tente novamente";
                }
                this.mapEquino(equinoInfo, dataNascimento,novoEquino);
                novoEquino.setProprietario(clienteFind);
                novoEquino.setRaca(raca);
                equinoRepository.save(novoEquino);
            }else{
                int idEq = Integer.valueOf( equinoInfo.get("idEquino"));
                System.out.println(idEq);
                Equino equinoUpdate = equinoRepository.find(idEq);
                if(equinoUpdate == null){
                    return "Não foi possível localizar este equino. Tente novamente.";
                }
                
                this.mapEquino(equinoInfo, dataNascimento, equinoUpdate);
                
               
                equinoUpdate.setRaca(raca);
                
                equinoRepository.update(equinoUpdate);
            }
            
        }catch(DateTimeException ex){
            return "Data Inválida";
        }catch(NumberFormatException nf){
            return "Peso inválido. Inserir apenas o valor em Kg.";
            
        }
        return null;
    }
    
    private void mapEquino(HashMap<String, String> equinoInfo, LocalDate dataNascimento, Equino eq){
        float f = Float.parseFloat(equinoInfo.get("vlPeso").trim());
        eq.setVlPeso(f);
        eq.setDtNascimento(dataNascimento);
        eq.setNome(equinoInfo.get("nome"));
        eq.setVlCustoMensal(new BigDecimal(equinoInfo.get("vlCustoMensal")));
    }
    public List<String> atualizaRacas(){
        List<Raca> lsRaca =racaDao.findAll();
        List<String> lsRacaConcatenado = new ArrayList<>();
        for(Raca raca : lsRaca){
            lsRacaConcatenado.add((String.valueOf(raca.getNome())+"."+ String.valueOf(raca.getIdRaca())));
        }
        System.out.println(lsRacaConcatenado.get(0));
        return lsRacaConcatenado;
    }
    public BigDecimal calcular(HashMap<String, String> equinoInfo){
        return new BigDecimal(100.22);
    }
}
