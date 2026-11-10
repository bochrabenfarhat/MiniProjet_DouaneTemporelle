package com.boch.ds1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;


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

                // na3rfou anahi RadioButton 5tarha l utilisateur
                int choix = motif.getCheckedRadioButtonId();
                /*  getCheckedRadioButtonId() tjib id mta3 radiobutton  elli khtarou l'utilisateur Android yjib el resultat  int donc
                 lezem tet5azen fi  variable de meme type   */

                if(n.isEmpty() || nc.isEmpty() || des.isEmpty() || choix == -1) // net2akdou elli les champs kol ma3mrin w elli fama motif mte3 voyage
                {// ken fama champ feragh nwarriw message erreur
                    Toast.makeText(MainActivity.this, "Remplir tous les champs", Toast.LENGTH_SHORT).show();
                }
                else
                {   int destinationInt = Integer.parseInt(des);
                    int anneeActuelle = Calendar.getInstance().get(Calendar.YEAR);
                    int naissanceInt = Integer.parseInt(nc);
                    int ageDestination = destinationInt - naissanceInt;
                    // net2akdou elli utilisatuer mawloud
                    if(naissanceInt > anneeActuelle)
                    { Toast.makeText(MainActivity.this, "Annee de naissance invalide", Toast.LENGTH_SHORT).show();
                        return;}
                    // n7eb l'annee de destination tkoun fel futur

                    // net2akdou elli l annee de destination fil mosta9bel
                    if(destinationInt <= anneeActuelle)
                    {Toast.makeText(MainActivity.this,"Choisir une annee future",Toast.LENGTH_SHORT).show();
                        // ma nkamlouch l traitement ken l annee ghalta
                        return;}
                    // net2akdou elli 3omrou 18 ou plus wa9t ki iji ysafer
                    if(ageDestination < 18)
                    { Toast.makeText(MainActivity.this, "Le voyageur doit avoir au moins 18 ans a la destination", Toast.LENGTH_SHORT).show();
                        return;}
                    RadioButton rb = findViewById(choix);// // njibou el radiobutton elli i5tarha l'utilisateur (l id mte7a)
                    String motif = rb.getText().toString(); // ne5dhou esm el motif mel RadioButton
                  //nsan3ou Intent explicite  el Intent hiya wasila testa3melha Android bech tetna9el men Activity l Activity okhrahouni bech nemchiw men MainActivity lel VerificationActivity
                    Intent intent = new Intent(
                            //el Activity elli a7na fiha tawa
                            MainActivity.this,VerificationActivity.class // el Activity elli bech temchilha
                    );
                    /* nesta3mlou buildKey() bech nsan3ou clé dynamique el clé tetkawwen men 4 a5er chiffres mel matricule
                     w esm el donnée elli bech tetb3ath
                     */
                    String m = "0911";
                    String keyNom = Utils.buildKey(m, "NOM");
                    String keyNaissance = Utils.buildKey(m, "NAISSANCE");
                    String keyDestination = Utils.buildKey(m, "DESTINATION");
                    String keyMotif = Utils.buildKey(m, "MOTIF");

                    intent.putExtra(keyNom, n);
                    intent.putExtra(keyNaissance, nc);
                    intent.putExtra(keyDestination, des);
                    intent.putExtra(keyMotif, motif);
                    startActivity(intent);


                    /* avant le cle unique
                    intent.putExtra("NOM", n);
                     putExtra testa3mel bech neb3thou ma3loumet m3a el Intent el key hiya esm el donnée  el value hiya el ma3louma nafsha
                    ba3d fil Activity okhra nesta3mlou getExtra bech nraj3ouha  kater howa yab3ath les donnee ama ma yothehrouj ken ki ta3mel get extra
                    intent.putExtra("NAISSANCE", nc);
                    intent.putExtra("DESTINATION", des);
                    intent.putExtra("MOTIF", motif);
                    startActivity(intent);  //n7elou VerificationActivity w nab3thou m3aha les données elli 7attinehom fil Intent */
                }
            }
        });

    }
}