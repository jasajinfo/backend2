package br.senac.rj.backend.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 
 * @author reinaldo.jose
 * Entidade que representa a tabela produto.
 */
@Entity
@Table(name = "produto")
@Data
public class Produtoentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_produto;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private String tipo;
}
