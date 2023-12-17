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
public class Tratamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTratamento;
    @ManyToOne
    @JoinColumn(name = "tpTratamento_id", referencedColumnName = "idTipoTratamento")
    private TipoTratamento tpTratamento;
    @ManyToMany
    @JoinTable(name = "Tratamento_Doenca",
            joinColumns = @JoinColumn(name = "tratamento_id", referencedColumnName = "idTratamento"),
            inverseJoinColumns = @JoinColumn(name = "doenca_id", referencedColumnName = "idDoenca")
    )
    private List<Doenca> lsDoenca;
    private String txLaudoMedico;
    private LocalDate dtTratamento;
    private BigDecimal vlCustoTratamento;
    private BigDecimal vlFinalTratamento;
    private String posologia;
    private String nmMedicacao;
    private BigDecimal vlMedicacao;
    @ManyToOne()
    @JoinColumn(name = "equino_id", referencedColumnName = "idEquino")
    private Equino equino;
}
