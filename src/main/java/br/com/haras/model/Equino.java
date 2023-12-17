package br.com.haras.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "raca_id", referencedColumnName = "idRaca")
    private Raca raca;
    private String nome;
    private BigDecimal vlCustoMensal;
    private float vlPeso;
    @OneToMany(mappedBy = "equino")
    private List<Tratamento> lsTratamento;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cliente_id", referencedColumnName = "idCliente")
    private Cliente proprietario;
    @ManyToOne
    @JoinColumn(name="funcao_id")
    private Funcao funcao;
    private byte[] imagem;
    
    public HashMap<String,String> toHashmap(){
        HashMap<String, String> eqHash = new HashMap<>();
        eqHash.put("nome", this.nome);
        eqHash.put("proprietario", this.proprietario.getNome());
        eqHash.put("raca", this.raca.getNome());
        eqHash.put("idRaca", String.valueOf(this.raca.getIdRaca()));
        eqHash.put("idEquino",String.valueOf(this.idEquino));
        eqHash.put("dtNascimento",String.valueOf(this.dtNascimento));
        eqHash.put("vlPeso",String.valueOf(this.vlPeso));
        eqHash.put("vlCustoMensal",String.valueOf(this.vlCustoMensal));
        return eqHash;
    }
}
