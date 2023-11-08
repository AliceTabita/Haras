package br.com.haras.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenda;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente comprador;
    @OneToOne
    @JoinColumn(name = "anuncio_id")
    private Anuncio anuncio;
    private BigDecimal vlVenda;
    private LocalDate dtVenda;
    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name="venda_id")
    private List<Parcela> lsParcelas;
}
