package com.app.vetline.vetline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import controller.CDadosAnimal;
import model.Animal;

/**
 * Created by ProBook on 06/12/2016.
 */

public class Tela_mostrar_vacinas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_mostrar_vacinas);
        getSupportActionBar().hide();
/*
        Animal animal = new Animal(); // recebe o animal da tela anterior
        Animal animalTela = new Animal(); // recebe o animal da tela anterior
        CDadosAnimal cDadosAnimal = new CDadosAnimal();
        animalTela = cDadosAnimal.carregaDados(animal);

        TextView nomeAnimal = (TextView) findViewById(R.id.view_nomeVacina);
        TextView racaAnimal = (TextView) findViewById(R.id.view_RacaVacina);

        nomeAnimal.setText("NOME:" + animalTela.getNome());
        racaAnimal.setText("RAÇA:" + animalTela.getRaca());
        */

        /*
        *
        * Carregar uma ListView com as Vacinas daquele Animal
        *
         */

        Button btn_adicionar1 = (Button) findViewById(R.id.btn_adicionarVacina);
        btn_adicionar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Vai para a tela de adicionar uma nova Vacina
            }
        });
    }
}
