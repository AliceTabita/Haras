/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.controller;

import br.com.haras.model.Evento;
import br.com.haras.model.tables.TMEventos;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author alice
 */
public class EventoController {

    private List<Evento> consultaEventos(){
        Evento evento = new Evento (1,"a","12/12/12","15:20",1);
        List<Evento> lsEvento = new ArrayList();
        lsEvento.add(evento);
        evento = new Evento (2,"b","11/11/11","15:20",2);
        lsEvento.add(evento);
        return lsEvento;
    }
    public Evento buscaEvento(int id){
        return new Evento (1,"a","12/12/12","15:20",1);
    }
    
    public  TMEventos atualizarTabela(){
        List<Evento> lsEvento = this.consultaEventos();
        TMEventos  tmEvento = new TMEventos(lsEvento);
        return tmEvento;
    }
    public static void atualizarEvento(Evento evento){
        System.out.println("Atualizando " + evento.toString());
    }
    public static void inserirEvento(Evento evento){
        System.out.println("Inserindo " + evento.toString());
    }
    public static void excluirEvento(int idEvento){
        System.out.println("Excluido");
    }
    
}
