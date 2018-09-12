package br.ufjf.dcc196.exercicionota01;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_PROF = 1;
    private static final int REQUEST_ALUNO = 2;
    private static final int REQUEST_EXT = 3;
    public static final String PESSOA_NOME = "Vazio";
    private Button btnProfessor;
    private Button btnAluno;
    private Button btnExterno;
    private TextView txtProfessor;
    private TextView txtAluno;
    private TextView txtExterno;
    private TextView txtNomePessoa;
    private TextView txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnProfessor = findViewById(R.id.btnProfessor);
        btnAluno = findViewById(R.id.btnAluno);
        btnExterno = findViewById(R.id.btnExterno);
        btnProfessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Professor.class);
                startActivityForResult(intent, MainActivity.REQUEST_PROF);
            }
        });
        btnAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Aluno.class);
                startActivityForResult(intent, MainActivity.REQUEST_ALUNO);
            }
        });
        btnExterno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Externo.class);
                startActivityForResult(intent, MainActivity.REQUEST_EXT);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        txtProfessor = (TextView) findViewById(R.id.txtNumProfessores);
        txtAluno = (TextView) findViewById(R.id.txtNumAlunos);
        txtExterno = (TextView) findViewById(R.id.txtNumExternos);
        txtNomePessoa = (TextView) findViewById(R.id.txtPessoaCadastrada);
        txtTotal = (TextView) findViewById(R.id.txtNumTotal);
        if (requestCode == MainActivity.REQUEST_PROF && resultCode == Activity.RESULT_OK) {
            Bundle bundleResultado = data.getExtras();
            String nomeCadastrado = bundleResultado.getString(MainActivity.PESSOA_NOME);
            txtNomePessoa.setText("Cadastrado: " + nomeCadastrado);
            Integer soma = Integer.parseInt(txtProfessor.getText().toString());
            soma++;
            String totalProfessor = String.valueOf(soma);
            txtProfessor.setText(totalProfessor);
            Integer somaTotal = Integer.parseInt(txtTotal.getText().toString());
            somaTotal++;
            String totalCadastrados = String.valueOf(somaTotal);
            txtTotal.setText(totalCadastrados);
        }
        if (requestCode == MainActivity.REQUEST_ALUNO && resultCode == Activity.RESULT_OK)
        {
            Bundle bundleResultado = data.getExtras();
            String nomeCadastrado = bundleResultado.getString(MainActivity.PESSOA_NOME);
            txtNomePessoa.setText("Cadastrado: " + nomeCadastrado);
            Integer soma = Integer.parseInt(txtAluno.getText().toString());
            soma++;
            String totalAluno = String.valueOf(soma);
            txtAluno.setText(totalAluno);
            Integer somaTotal = Integer.parseInt(txtTotal.getText().toString());
            somaTotal++;
            String totalCadastrados = String.valueOf(somaTotal);
            txtTotal.setText(totalCadastrados);
        }
        if (requestCode == MainActivity.REQUEST_EXT && resultCode == Activity.RESULT_OK)
        {
            Bundle bundleResultado = data.getExtras();
            String nomeCadastrado = bundleResultado.getString(MainActivity.PESSOA_NOME);
            txtNomePessoa.setText("Cadastrado: " + nomeCadastrado);
            Integer soma = Integer.parseInt(txtExterno.getText().toString());
            soma++;
            String totalExterno = String.valueOf(soma);
            txtExterno.setText(totalExterno);
            Integer somaTotal = Integer.parseInt(txtTotal.getText().toString());
            somaTotal++;
            String totalCadastrados = String.valueOf(somaTotal);
            txtTotal.setText(totalCadastrados);
        }
    }
}
