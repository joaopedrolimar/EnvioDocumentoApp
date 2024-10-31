package com.example.enviodocumentosapp2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

// Classe responsável pelo envio de documentos
public class EnvioDocumentoActivity extends AppCompatActivity {

    // Código de requisição para o seletor de arquivos
    private static final int PICK_FILE_REQUEST = 1;
    private Uri selectedFileUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envio_documento);

        // Botão para selecionar o arquivo
        Button btnSelectFile = findViewById(R.id.btn_select_file);

        // Botão para enviar o arquivo
        Button btnSendFile = findViewById(R.id.btn_send_file);

        // Ação para selecionar o arquivo
        btnSelectFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abre o seletor de arquivos
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                startActivityForResult(intent, PICK_FILE_REQUEST);
            }
        });

        // Ação para enviar o arquivo selecionado
        btnSendFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica se o arquivo foi selecionado antes de enviar
                if (selectedFileUri != null) {
                    // Aqui, a lógica para envio do arquivo será implementada
                    Toast.makeText(EnvioDocumentoActivity.this, "Arquivo enviado com sucesso!", Toast.LENGTH_SHORT).show();
                } else {
                    // Exibe mensagem se nenhum arquivo for selecionado
                    Toast.makeText(EnvioDocumentoActivity.this, "Selecione um arquivo primeiro.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Método para processar o arquivo selecionado
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Verifica se o código e o resultado estão corretos
        if (requestCode == PICK_FILE_REQUEST && resultCode == RESULT_OK && data != null) {
            selectedFileUri = data.getData();
            Toast.makeText(this, "Arquivo selecionado: " + selectedFileUri.getPath(), Toast.LENGTH_SHORT).show();
        }
    }
}


