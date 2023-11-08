/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haras.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author alice
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Funcao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idFuncao;
    private String nome;
    private String descricao;
}
