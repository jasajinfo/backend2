package br.senac.rj.backend.entity;
AvaliacaoDao.javamodeloDao1.javapackage br.senac.rj.backend.entity;

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
 * Entidade que representa a tabela pagamento.
 */
@Entity
@Table(name = "avaliacao")
@Data
public class Avaliacaoentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_avaliacao;

    @Column(length = 200, nullable = false)
    private String experiencia;

    @Column(length = 200, nullable = false)
    private String comentarios;
    

    @Column(length = 10, nullable = false)
    private Integer nota_eficiencia;

    @Column(length = 10, nullable = false)
    private Integer nota_solucao;
    
              
}
