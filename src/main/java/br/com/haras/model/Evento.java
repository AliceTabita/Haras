/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.model;

import br.com.haras.model.enums.StatusEvento;


/**
 *
 * @author alice
 */

public class Evento {
    private int id;
    private String nome;
    private String data;
    private String hora;
    private String situacao; 

    public Evento(){
        
    }
    public Evento(int id,String nome, String data, String hora, int situacao) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.situacao = StatusEvento.toEnum(situacao).getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", nome=" + nome + ", data=" + data + ", hora=" + hora + ", situacao=" + situacao + '}';
    }

}
