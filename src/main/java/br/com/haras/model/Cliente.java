/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    private int idCliente;
    private String nome;
    private String email;
    private String telefone;
    private String sexo;
    private String cpf;
    @OneToMany(mappedBy = "proprietario",fetch = FetchType.EAGER)
    private List<Equino> lsEquino;
    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;
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
