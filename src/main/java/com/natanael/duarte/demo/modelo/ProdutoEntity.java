package com.natanael.duarte.demo.modelo;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString

@Entity
@Table(name= "funcionario")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "salario")
    private double preco;

}
