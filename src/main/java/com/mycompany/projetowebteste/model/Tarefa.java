package com.mycompany.projetowebteste.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tarefa")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tarefa implements Serializable {

    public Tarefa() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    private String descricao;
    private boolean concluido;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEntrega;

}
