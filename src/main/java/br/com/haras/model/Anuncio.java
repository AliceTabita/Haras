package br.com.haras.model;

import br.com.haras.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Anuncio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAnuncio;
    private BigDecimal vlAnuncio;
    private LocalDate dtInicio;
    private LocalDate dtFim;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente anunciante;
    @ManyToOne
    @JoinColumn(name = "equino_id")
    private Equino equino;

    public Anuncio(int idAnuncio,BigDecimal vlAnuncio, LocalDate dtInicio, LocalDate dtFim,  int codStatus, Cliente anunciante, Equino equino) {
        this.idAnuncio= idAnuncio;
        this.vlAnuncio = vlAnuncio;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.status = Status.toEnum(codStatus);
        this.anunciante = anunciante;
        this.equino = equino;
    }
}
