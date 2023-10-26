/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

/**
 *
 * @author alice
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String sexo;
    private String cpf;

    public Cliente(String nome, String email, String telefone, String sexo, String cpf) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
        this.cpf = cpf;
    }
    public void copy(Cliente clienteP){
        this.nome= clienteP.getNome();
        this.email = clienteP.getEmail();
        this.telefone = clienteP.getTelefone();
        this.sexo = clienteP.getSexo();
    }
}
