package br.com.haras.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Raca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRaca;
    private String nome;
    private String descricao;
    private BigDecimal vlBaseRaca;
  
}
