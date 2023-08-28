package com.app.aplicativoalunos.dao;

import com.app.aplicativoalunos.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDao {

    // Lista de alunos
    private final static List<Aluno> alunos = new ArrayList<>();

    // Adiciona aluno na lista de alunos
    public void salva(Aluno aluno) {
        alunos.add(aluno);
    }

    // Cópia de lista estática de alunos
    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }
}
