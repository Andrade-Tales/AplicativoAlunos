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
        aluno.setId(contadorDeIds);
        contadorDeIds++;
    }

    //Comportamento de edição
    public void edita(Aluno aluno) {
        Aluno alunoEncontrado = null;
        for (Aluno a : alunos) {
            if (a.getId() == aluno.getId()) {

            }
        }
        if (alunoEncontrado != null) {
            int posicaoDoAluno = alunos.indexOf(alunoEncontrado);
            alunos.set(posicaoDoAluno, aluno);
        }

    }

    // Cópia de lista estática de alunos
    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }

    // Adicionando novos id's (adicionando novo aluno)
    private static int contadorDeIds = 1;
}
