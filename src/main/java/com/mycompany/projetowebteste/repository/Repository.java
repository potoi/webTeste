/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetowebteste.repository;

import com.mycompany.projetowebteste.model.Tarefa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Victor
 */
public class Repository implements Serializable {

    @Inject
    private EntityManager entityManager;

    private Class<Tarefa> entityClass = Tarefa.class;

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

    public void concluir(int id) {
        entityManager.getTransaction().begin();
        Tarefa entidade = entityManager.find(entityClass, id);
        Query query = entityManager.createQuery("update Tarefa t set t.concluido = true where t.id = :id", Tarefa.class);
        query.setParameter("id", entidade.getId());
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }

    public List<Tarefa> buscar() {
        try {
            List<Tarefa> entidades = entityManager.createQuery("select t from Tarefa t order by t.concluido,t.dataEntrega", Tarefa.class).getResultList();
            return entidades;
        } catch (Exception e) {

        }
        return null;
    }

    public String getEntityClassName() {
        return this.entityClass.getCanonicalName();
    }

    public Tarefa findById(int id) {
        Tarefa entidade = entityManager.find(entityClass, id);
        return entidade;
    }

}
