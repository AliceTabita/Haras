/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.controller;

import br.com.haras.model.Evento;
import br.com.haras.model.dao.EventoDao;
import br.com.haras.model.tables.TMEventos;
import java.util.List;

/**
 *
 * @author alice
 */
public class EventoController {
    private EventoDao eventoRepository;

    public EventoController() {
        this.eventoRepository = new EventoDao();
    }

    private List<Evento> consultaEventos(){

        return eventoRepository.findAll();
    }
    public Evento buscaEvento(int id){
        return eventoRepository.find(id);
    }
    
    public  TMEventos atualizarTabela(){
        List<Evento> lsEvento = eventoRepository.findAll();
        return new TMEventos(lsEvento);
    }
    public void atualizarEvento(Evento evento){
        eventoRepository.update(evento);
    }
    public void inserirEvento(Evento evento)
    {
        eventoRepository.save(evento);
    }
    public  void excluirEvento(int idEvento){
        Evento evento = eventoRepository.find(idEvento);
        eventoRepository.delete(evento);
    }
    
}
