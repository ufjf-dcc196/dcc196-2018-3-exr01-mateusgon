package br.ufjf.dcc196.exercicionota01;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Professor extends AppCompatActivity {

    private EditText edtProfNome;
    private EditText edtProfSiape;
    private Button btnProfConfirma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);
        btnProfConfirma = findViewById(R.id.btnConfirmaProfessor);
        edtProfNome = (EditText) findViewById(R.id.txtProfessorNome);
        edtProfSiape = (EditText) findViewById(R.id.txtProfessorSiape);
        btnProfConfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultado = new Intent();
                setResult(Activity.RESULT_OK, resultado);
                finish();
            }
        });
    }
}
