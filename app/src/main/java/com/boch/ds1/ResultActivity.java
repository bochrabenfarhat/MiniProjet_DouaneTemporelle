package com.boch.ds1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
    LinearLayout layoutResult;
    TextView verdict;
    Button nouveauVoyageur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        // norbtou les composants mta3 interface
        layoutResult = findViewById(R.id.layout_result_bbf);
        verdict = findViewById(R.id.tv_verdict_bbf);
        nouveauVoyageur = findViewById(R.id.btn_nouveau_voyageur_bbf);

        // narj3ou les données elli taba3thou men VerificationActivity
        Intent i = getIntent();
        String nom = i.getStringExtra("NOM");
        boolean accepte = i.getBooleanExtra("VERDICT", false);

        // ken el voyage ma9boul
        if(accepte) {
            verdict.setText("Bon voyage " + nom);
            layoutResult.setBackgroundColor(Color.parseColor("#C8E6C9"));
        }
        else {
            verdict.setText(nom + " est en etat d'arrestation temporelle");
            layoutResult.setBackgroundColor(Color.parseColor("#FFCDD2"));
        }
        // bouton retour lel MainActivity
        nouveauVoyageur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(i2);
                finish();
            }
        });

    }
}