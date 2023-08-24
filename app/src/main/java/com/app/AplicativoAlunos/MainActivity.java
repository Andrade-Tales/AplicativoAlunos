package com.app.AplicativoAlunos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.app.listadealunos.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Criando lista de alunos
        List<String> alunos = new ArrayList<>
                (Arrays.asList("Alex", "Fran", "José", "Maria", "Ana"));

        // Componente ListView (capacidade de compor outras views)
        ListView listaDeAlunos = findViewById(R.id.activity_main_lista_de_alunos);

        // Usando o adapter (vínculo dos dados com base em uma view), (adapter views)
        listaDeAlunos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alunos));


    }
}