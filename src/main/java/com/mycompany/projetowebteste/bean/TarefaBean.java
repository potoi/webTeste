package com.mycompany.projetowebteste.bean;

import com.mycompany.projetowebteste.model.Tarefa;
import com.mycompany.projetowebteste.repository.Repository;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.persistence.sessions.factories.SessionFactory;
import org.hibernate.Session;

@Named
@SessionScoped
public class TarefaBean implements Serializable {

    @Getter
    @Setter
    private List<Tarefa> entidades;

    @Getter
    @Setter
    private Tarefa entidade = new Tarefa();

    @Inject
    private Repository repositorio;

    @PostConstruct
    public void init() {
        buscar();
    }

    public void salvar() {
        if (entidade != null) {
            repositorio.salvar(entidade);
            buscar();
        }

    }

    public void buscar() {
        try {
            this.entidades = repositorio.buscar();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void remover(int id) {
        try {
            repositorio.remover(id);
            buscar();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void concluir(Tarefa entidade) {
        try {
            repositorio.concluir(entidade);
            entidade.setConcluido(true);
            buscar();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
