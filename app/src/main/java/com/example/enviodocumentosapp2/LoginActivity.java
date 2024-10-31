package com.example.enviodocumentosapp2;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

// Classe responsável pelo login do usuário
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializa os campos de texto para usuário e senha
        EditText etUsername = findViewById(R.id.et_username);
        EditText etPassword = findViewById(R.id.et_password);

        // Botão de login
        Button btnLogin = findViewById(R.id.btn_login);

        // Ação para o botão de login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Captura o conteúdo dos campos de usuário e senha
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                // Verifica se o usuário e a senha correspondem aos valores definidos
                if (username.equals("admin") && password.equals("1234")) {
                    // Redireciona para a tela de envio de documentos caso as credenciais estejam corretas
                    Intent intent = new Intent(LoginActivity.this, EnvioDocumentoActivity.class);
                    startActivity(intent);
                    finish(); // Encerra a LoginActivity para que o usuário não volte para ela
                } else {
                    // Exibe uma mensagem de erro se o login falhar
                    Toast.makeText(LoginActivity.this, "Usuário ou senha inválidos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


