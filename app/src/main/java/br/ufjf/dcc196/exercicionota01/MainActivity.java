package br.ufjf.dcc196.exercicionota01;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_PROF = 1;
    private static final int REQUEST_ALUNO = 2;
    private static final int REQUEST_EXT = 3;
    private Button btnProfessor;
    private Button btnAluno;
    private Button btnExterno;
    private TextView txtProfessor;
    private TextView txtAluno;
    private TextView txtExterno;
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
        txtProfessor = (TextView) findViewById(R.id.txtProfessores);
        txtAluno = (TextView) findViewById(R.id.txtAlunos);
        txtExterno = (TextView) findViewById(R.id.txtExternos);
        if (requestCode == MainActivity.REQUEST_PROF && resultCode == Activity.RESULT_OK)
        {
            Integer soma = Integer.parseInt(txtProfessor.getText().toString());
            soma++;
            String totalProfessor = String.valueOf(soma);
            txtProfessor.setText(totalProfessor);
        }
        if (requestCode == MainActivity.REQUEST_ALUNO && resultCode == Activity.RESULT_OK)
        {
            Integer soma = Integer.parseInt(txtAluno.getText().toString());
            soma++;
            String totalAluno = String.valueOf(soma);
            txtAluno.setText(totalAluno);
        }
        if (requestCode == MainActivity.REQUEST_EXT && resultCode == Activity.RESULT_OK)
        {
            Integer soma = Integer.parseInt(txtExterno.getText().toString());
            soma++;
            String totalExterno = String.valueOf(soma);
            txtExterno.setText(totalExterno);
        }
    }
}
