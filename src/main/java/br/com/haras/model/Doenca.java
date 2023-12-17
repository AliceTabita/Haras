package br.com.haras.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doenca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDoenca;
    private String nmDoenca;
    private String DescricaoDoenca;
    @ManyToMany(mappedBy = "lsDoenca")
    private List<Tratamento> lsTratamento;
      @Override
    public String toString(){
        return this.nmDoenca;
    }
}
