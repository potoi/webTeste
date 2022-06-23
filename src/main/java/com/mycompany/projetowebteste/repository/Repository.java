/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetowebteste.repository;

import com.mycompany.projetowebteste.model.Tarefa;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Victor
 */
public class Repository implements Serializable {

    @Inject
    private EntityManager entityManager;

    private Class<Tarefa> entityClass;

    public Tarefa salvar(Tarefa entidade) {
        entityManager.getTransaction().begin();
        entidade = entityManager.merge(entidade);
        entityManager.getTransaction().commit();
        return entidade;
    }

    public void remover(int id) {
        entityManager.getTransaction().begin();
        Tarefa entidade = entityManager.find(entityClass, id);
        entityManager.remove(entidade);
        entityManager.getTransaction().commit();
    }

}
