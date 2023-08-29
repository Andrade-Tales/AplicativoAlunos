package com.app.aplicativoalunos.ui.activity;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.aplicativoalunos.dao.AlunoDao;
import com.app.aplicativoalunos.model.Aluno;
import com.app.listadealunos.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de alunos";
    private final AlunoDao dao = new AlunoDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        // Alterando titulo do app bar
        setTitle(TITULO_APPBAR);
        // Botão adicionar aluno
        configuraFabNovoAluno();
        // Setando dois alunos para (visualização)
        dao.salva(new Aluno("Alex", "999999999", "alex@gmail.com"));
        dao.salva(new Aluno("Fran", "999999999", "fran@gmail.com"));

    }

    private void configuraFabNovoAluno() {
        // Botão novo aluno (navega para formulário de alunos)
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreFormularioAlunoActivity();
            }
        });
    }

    private void abreFormularioAlunoActivity() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));

    }

    @Override
    protected void onResume() { //Quando a atividade insere o estado "Retomado", ela vem para o
        // primeiro plano e o sistema invoca o callback
        super.onResume();

        configuraLista();
    }

    private void configuraLista() {
        // Componente ListView (capacidade de compor outras views)
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);

        // Usando o adapter (vínculo dos dados com base em uma view), (adapter views)
        listaDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.todos()));

        // Adicionando Listener
        // Exibição de mensagem com Log
        listaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posicao, long id) {
                Log.i("Posição do aluno", "" + posicao);
            }
        });
    }

}
