package br.com.haras.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEquino;
    private LocalDate dtNascimento;
    @ManyToOne
    @JoinColumn(name = "raca_id", referencedColumnName = "idRaca")
    private Raca raca;
    private String nome;
    private BigDecimal vlCustoMensal;

    @OneToMany(mappedBy = "equino")
    private List<Tratamento> lsTratamento;
    @ManyToOne
    @JoinColumn(name="cliente_id", referencedColumnName = "idCliente")
    private Cliente proprietario;
    @ManyToOne
    @JoinColumn(name="funcao_id")
    private Funcao funcao;
}
