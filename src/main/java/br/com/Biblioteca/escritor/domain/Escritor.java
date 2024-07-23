package br.com.Biblioteca.escritor.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "Escritor")
public class Escritor {
    @Id
    @GeneratedValue
    @Column(name = "ID_ESCRITOR")
    private Integer id;

    @Column(name = "NOME_ESCRITOR")
    private String NomeEscritor;

    @Column(name = "DATA_NASCI")
    private String DataNasci;

    @Column(name = "NAC_ESC")
    private String NacionalidadeEsc;

    @Column(name = "GEN_LIT")
    private String GeneroLiterario;

    @Column(name = "LIVRO_PUBLI")
    private String LivrosPubli;

   // @ManyToOne(fetch = FetchType.EAGER)
   // @JoinColumn(name = "ID_LIVRO")

    //FALTA ADICIONAR AS COISAS ACIMA
}
