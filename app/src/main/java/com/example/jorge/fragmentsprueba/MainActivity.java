package com.example.jorge.fragmentsprueba;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etWeb;
    Button btnBuscar;

    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWeb = (EditText)findViewById(R.id.etWeb);
        btnBuscar = (Button)findViewById(R.id.btnBuscar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getURL();
            }
        });

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        FragmentWeb fragmentInicial= new FragmentWeb();

        transaction.add(R.id.fragment, fragmentInicial);
        transaction.commit();

    }

    public void getURL() {

        url = etWeb.getText().toString();
        if (url.equals("")) {
            Toast.makeText(getApplicationContext(), "Introduce una URL", Toast.LENGTH_LONG).show();
        }
        else {
            Fragment miFragmento = FragmentWeb.newInstance(url);
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment, miFragmento);
            transaction.addToBackStack(null);
            transaction.commit();
        }

    }
}
