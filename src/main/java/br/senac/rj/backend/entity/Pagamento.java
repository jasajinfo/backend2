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
 * Entidade que representa a tabela pagamento.
 */
@Entity
@Table(name = "pagamento")
@Data
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pagamento;

    @Column(length = 50, nullable = false)
    private String forma_pagamento;

    @Column(length = 50, nullable = false)
    private String detalhe_pagamento;
}
