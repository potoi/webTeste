package com.mycompany.projetowebteste.bean;

import com.mycompany.projetowebteste.model.Tarefa;
import com.mycompany.projetowebteste.repository.Repository;
import javax.inject.Named;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class TarefaBean implements Serializable {

    @Getter
    @Setter
    private Tarefa entidade = new Tarefa();

    @Inject
    private Repository repositorio;

    @Getter
    @Setter
    private String hello = "Olá mundo";

    public void salvar() {
        if (entidade != null) {

            repositorio.salvar(entidade);
        }

    }

}
