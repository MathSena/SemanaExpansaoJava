package com.expansao.java.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name="loja_id", referencedColumnName = "id")
    private Loja loja;
    private String marca;
    private String modelo;
    private String descricao;

}
