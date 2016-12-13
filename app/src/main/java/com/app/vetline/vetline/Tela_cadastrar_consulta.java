package com.app.vetline.vetline;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;

import java.util.Date;

import controller.CCadastrarConsulta;
import model.Consulta;

/**
 * Created by ProBook on 06/12/2016.
 */

public class Tela_cadastrar_consulta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastrar_consulta);
        getSupportActionBar().hide();
        Button btn_proximo = (Button) findViewById(R.id.btn_proximo);
        final Intent tela_mapa = new Intent(this, Tela_mapa.class);


        btn_proximo.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                EditText sintomas = (EditText) findViewById(R.id.campo_sintomas);
                TimePicker hora = (TimePicker) findViewById(R.id.campo_hora);
                DatePicker data = (DatePicker) findViewById(R.id.campo_data);
                RadioButton debito = (RadioButton) findViewById(R.id.op_cartao_debito);
                RadioButton boleto = (RadioButton) findViewById(R.id.op_boleto);

                String sintomasStr = sintomas.getText().toString();
                String horaStr = String.valueOf(hora.getHour() + ":" + hora.getMinute());
                Date datas = new Date();

                CCadastrarConsulta cCadastrarConsulta = new CCadastrarConsulta();
                Consulta consul = new Consulta();

                if (debito.isChecked()){
                    consul.setDataconsulta(datas);
                    consul.setDescricao(sintomasStr);
                    consul.setTipoPagamento("debito");

                    cCadastrarConsulta.CadastrarConsulta(consul);

                    startActivity(tela_mapa);
                }
                else if(boleto.isChecked()){
                    consul.setDataconsulta(datas);
                    consul.setDescricao(sintomasStr);
                    consul.setTipoPagamento("boleto");

                    cCadastrarConsulta.CadastrarConsulta(consul);

                    startActivity(tela_mapa);
                }


            }
        });
    }
}
