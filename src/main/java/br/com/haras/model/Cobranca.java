package br.com.haras.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cobranca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCobranca;
    @ManyToOne
    @JoinColumn(name="cliente_id", referencedColumnName = "idCliente")
    private Cliente proprietario;
    private LocalDate dtRecebimento;
    private BigDecimal vlCustoTotal;
    private BigDecimal vlCobranca;
    private String cdBoleto;
    private Boolean inAtraso;
    private LocalDate dtNotificacao;
    private LocalDate dtVencimento;
}
