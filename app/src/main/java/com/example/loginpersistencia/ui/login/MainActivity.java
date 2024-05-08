package com.example.loginpersistencia.ui.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.loginpersistencia.R;
import com.example.loginpersistencia.ui.registro.RegistroActivity;

public class MainActivity extends AppCompatActivity {

    Button btLogin;
    Button btRegistro;
    EditText etUser;
    EditText etPass;
    private ViewModelMain vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
    }

    public  void inicializar()
    {
        btLogin=findViewById(R.id.btLogin);
        btRegistro=findViewById(R.id.btRegistro);
        etUser=findViewById(R.id.etUser);
        etPass=findViewById(R.id.etPass);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModelMain.class);

        btRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), RegistroActivity.class);
                i.putExtra("login",false);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(i);
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.logueo(etUser.getText().toString(),etPass.getText().toString());


            }
        });

    }
}