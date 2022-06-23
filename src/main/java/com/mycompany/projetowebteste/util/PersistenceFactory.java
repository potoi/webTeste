package com.mycompany.projetowebteste.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class PersistenceFactory implements Serializable {

     private EntityManager em;
    
    List<EntityManager> m = new ArrayList<>();
    private EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("web_tarefaPU");

    @Produces
    public EntityManager getEntityManager() {
        if(em == null || !em.isOpen()){
            em = emf.createEntityManager();
        }
        return em;
    }
}
