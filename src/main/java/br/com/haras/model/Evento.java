/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.model;

import br.com.haras.model.enums.StatusEvento;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;


/**
 *
 * @author alice
 */
@Entity
@NoArgsConstructor
@Data
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String data;
    private String hora;
    private String situacao; 

    public Evento(int id,String nome, String data, String hora, int situacao) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.situacao = StatusEvento.toEnum(situacao).getDescricao();
    }
}
