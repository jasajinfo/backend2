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
 * Entidade que representa a tabela endereco.
 */
@Entity
@Table(name = "endereco")
@Data
public class Enderecoentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_endereco;

    @Column(length = 100, nullable = false)
    private String rua;

    @Column(length = 10, nullable = false)
    private String numero;
    
    @Column(length = 50, nullable = false)
    private String bairro;

    @Column(length = 50, nullable = false)
    private String cidade;
    
    @Column(length = 10, nullable = false)
    private String cep;

    @Column(length = 100, nullable = false)
    private String ponto_referencia;
    
    
    
    
    
    
    
}
