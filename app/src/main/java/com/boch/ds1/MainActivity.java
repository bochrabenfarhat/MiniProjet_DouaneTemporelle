package com.boch.ds1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText nom,naissance,destination;
    RadioGroup motif ;
    Button inspect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nom=findViewById(R.id.et_nom_bbf);// norbtou variable nom b editText mta3 esm el voyageur elli mawjoud fil interface XML(bel id mate7a)
        naissance=findViewById(R.id.et_naissance_bbf);
        destination=findViewById((R.id.et_destination_bbf));
        motif=findViewById(R.id.rg_motif_bbf);
        inspect=findViewById(R.id.btn_inspecter_bbf);
        // na3mlou event ki l'utilisateur yenzel 3al bouton inspecter
        inspect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* getText() traja3 el contenu elli ktebou l'utilisateur fil edittext ama el contenu yarja3  moch string
                donc nesta3mlou toString() bech n7awlouh l string w najmou nesta3mlouh fil programme */

                String n = nom.getText().toString();
                String nc = naissance.getText().toString();
                String des = destination.getText().toString();
                // na3rfou anahi RadioButton t5taret
                int choix = motif.getCheckedRadioButtonId();
                /*  getCheckedRadioButtonId() tjib id mta3 radiobutton  elli khtarou l'utilisateur Android yjib el resultat  int donc
                 lezem tet5azen fi  variable de meme type   */
                if(n.isEmpty() || nc.isEmpty() || des.isEmpty() || choix == -1) // net2akdou elli les champs kol ma3mrin w elli fama motif mte3 voyage
                {// ken fama champ feragh nwarriw message erreur
                    Toast.makeText(MainActivity.this, "Remplir tous les champs", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton rb = findViewById(choix);// // njibou id mta3 el radiobutton elli i5tarha l'utilisateur
                    String motif = rb.getText().toString(); // ne5dhou esm el motif mel RadioButton
                  //nsan3ou Intent explicite  el Intent hiya wasila testa3melha Android bech tetna9el men Activity l Activity okhrahouni bech nemchiw men MainActivity lel VerificationActivity
                    Intent intent = new Intent(
                            //el Activity elli a7na fiha tawa
                            MainActivity.this,VerificationActivity.class // el Activity elli bech temchilha
                    );
                    intent.putExtra("NOM", n);
                    /* putExtra testa3mel bech neb3thou ma3loumet m3a el Intent el key hiya esm el donnée  el value hiya el ma3louma nafsha
                    ba3d fil Activity okhra nesta3mlou getExtra bech nraj3ouha  kater howa yab3ath les donnee ama ma yothehrouj ken ki ta3mel get extra  */
                    intent.putExtra("NAISSANCE", nc);
                    intent.putExtra("DESTINATION", des);
                    intent.putExtra("MOTIF", motif);
                    startActivity(intent);  //n7elou VerificationActivity w nab3thou m3aha les données elli 7attinehom fil Intent
                }
            }
        });

    }
}