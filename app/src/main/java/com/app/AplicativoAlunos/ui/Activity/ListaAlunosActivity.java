package com.app.AplicativoAlunos.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.app.listadealunos.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        // Alterando titulo do app
        setTitle("Lista de alunos");

        // Criando lista de alunos
        List<String> alunos = new ArrayList<>
                (Arrays.asList("Alex", "Fran", "José", "Maria", "Ana"));

        // Componente ListView (capacidade de compor outras views)
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);

        // Usando o adapter (vínculo dos dados com base em uma view), (adapter views)
        listaDeAlunos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alunos));
    }
}