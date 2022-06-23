package com.mycompany.projetowebteste.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @Getter
    @Setter
    private String descricao;
    private boolean concluido;
    private Date dataEntrega;

}
