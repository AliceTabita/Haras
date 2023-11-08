package br.com.haras.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TipoTratamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoTratamento;
    private String descricao;
    private String nome;
    private BigDecimal vlTratamento;
    @OneToMany(mappedBy = "tpTratamento")
    private List<Tratamento> lsTratamento;
}
