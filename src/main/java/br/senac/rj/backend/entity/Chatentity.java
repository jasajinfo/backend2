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
 * Entidade que representa a tabela chat.
 */
@Entity
@Table(name = "chat")
@Data
public class Chatentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_chat;

    @Column(length = 100, nullable = false)
    private String remetente;

    @Column(length = 50, nullable = false)
    private String mensagem;
    
    
    @Column(length = 100, nullable = false)
    private String data_envio;

   
    
    
}
