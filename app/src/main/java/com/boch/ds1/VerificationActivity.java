package com.boch.ds1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class VerificationActivity extends AppCompatActivity {
    TextView nom, age, motif;
    Button approuver, refuser;
    // méthode  bech net2akdou elli nombre premier wala le
    public boolean estPremier(int n) {
        if(n < 2) {
            return false;
        }
        for(int i = 2; i < n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_verification);
        nom = findViewById(R.id.tv_nom_bbf);
        age = findViewById(R.id.tv_age_bbf);
        motif = findViewById(R.id.tv_motif_bbf);
        approuver = findViewById(R.id.btn_approuver_bbf);
        refuser = findViewById(R.id.btn_refuser_bbf);

        Intent i = getIntent();
        /* getIntent() traja3 l Intent elli jena biha men MainActivity menha
        najmou narj3ou les données elli taba3thou b putExtra*/

        /* Avant le cle unique
        String n = i.getStringExtra("NOM");// getStringExtra() testa3mel bech narj3ou les données elli taba3thou men MainActivity b putExtra
        String nc = i.getStringExtra("NAISSANCE");
        String des = i.getStringExtra("DESTINATION");
        String m = i.getStringExtra("MOTIF"); */

        String mat = "0911";

        String n = i.getStringExtra(Utils.buildKey(mat, "NOM"));
        String nc = i.getStringExtra(Utils.buildKey(mat, "NAISSANCE"));
        String des = i.getStringExtra(Utils.buildKey(mat, "DESTINATION"));
        String m = i.getStringExtra(Utils.buildKey(mat, "MOTIF"));

        int ageTemporel = Integer.parseInt(des) - Integer.parseInt(nc);// Integer.parseInt() ta7awel String lel int bech najmou na7sbou l'âge temporel
        // net2akdou ken el motif "Modification du passé" w el différence bin destination w naissance nombre premiernsakkrou bouton approuver
        if(m.equals("Modification du passé") && estPremier(ageTemporel)) {
            approuver.setEnabled(false);
            Toast.makeText(VerificationActivity.this,"Risque de paradoxe",Toast.LENGTH_SHORT).show();
        }
        nom.setText("Voyageur : " + n);
        age.setText("Age temporel : " + ageTemporel);
        motif.setText("Motif : " + m);


        /* avant le cle unique
        // ki l'utilisateur yenzel 3al bouton Refuser
        refuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VerificationActivity.this, ResultActivity.class);
                intent.putExtra("NOM", n);
                intent.putExtra("VERDICT", false);
                startActivity(intent);
            }
        });

        // ki l'utilisateur yenzel 3al bouton Approuver
        approuver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VerificationActivity.this,ResultActivity.class);
                intent.putExtra("NOM", n);
                intent.putExtra("VERDICT", true);
                startActivity(intent);
            }
        });*/

        refuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VerificationActivity.this, ResultActivity.class);
                i.putExtra(Utils.buildKey(mat, "NOM"), n);
                i.putExtra(Utils.buildKey(mat, "V"), false);
                startActivity(i);
            }
        });

        approuver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(VerificationActivity.this,ResultActivity.class);
                i.putExtra(Utils.buildKey(mat, "NOM"), n);
                i.putExtra(Utils.buildKey(mat, "V"), true);
                startActivity(i);
            }
        });








    }
}

