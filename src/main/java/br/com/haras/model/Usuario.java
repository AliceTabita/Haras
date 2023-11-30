package br.com.haras.model;


import br.com.haras.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdUsuario;
    private String nmUsuario;
    private String cdCpfCnpj;
    private String email;
    @Lob
    private byte[] senha;
    @Lob
    private byte[] salt;
    private LocalDate dtUltimoLogin;
    @ManyToOne
    @JoinColumn(name = "tipo_usuario_id", referencedColumnName = "idTpUsuario")
    private TipoUsuario tpUsuario;
    private String cdVerificacao;
    @Enumerated(EnumType.STRING)
    private Status status;
}
