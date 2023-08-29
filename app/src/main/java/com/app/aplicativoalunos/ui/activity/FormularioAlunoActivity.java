package com.app.aplicativoalunos.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.app.aplicativoalunos.dao.AlunoDao;
import com.app.aplicativoalunos.model.Aluno;
import com.app.listadealunos.R;

public class FormularioAlunoActivity extends AppCompatActivity {
    public static final String TITULO_APPBAR = "Novo aluno"; // Definindo o título como constante
    private static EditText campoNome;
    private static EditText campoTelefone;
    private static EditText campoEmail;
    private final AlunoDao dao = new AlunoDao();

    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Pegando as views de maneira estática
        setContentView(R.layout.activity_formulario_aluno);
        setTitle(TITULO_APPBAR);
        inicializacaoDosCampos();
        configuraBotaoSalvar();
        Intent dados = getIntent();
        aluno = (Aluno) dados.getSerializableExtra("aluno");
        campoNome.setText(aluno.getNome());
        campoTelefone.setText(aluno.getTelefone());
        campoEmail.setText(aluno.getEmail());
    }

    private void configuraBotaoSalvar() {
        // Criando ação de botão via setOnClickListener e usando o layout estático pelo findViewById
        Button botaoSalvar = findViewById(R.id.activity_formulario_aluno_botao_salvar);
        // Definindo comportamentos via evento do botão
        botaoSalvar.setOnClickListener(new View.OnClickListener() { // Exibindo Toast (mensagem)
            // classe anônima (método onClick)
            @Override
            public void onClick(View v) {
//                Aluno alunoCriado = criaAluno();
//                salva(alunoCriado);
                preencheAluno();
                dao.edita(aluno);
                finish();

            }
        });
    }

    private void inicializacaoDosCampos() {
        // Referências
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
    }

    // Método salva aluno
    private void salva(Aluno aluno) {
        dao.salva(aluno);
        // Finalizando a pilha da activity
        finish();
    }

    // Método cria aluno
    private void preencheAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        aluno.setNome(nome);
        aluno.setTelefone(telefone);
        aluno.setEmail(email);
    }
}