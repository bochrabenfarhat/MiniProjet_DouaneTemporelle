package com.boch.ds1;

public class Utils {
    /*  hedhi méthode statique nesta3mlouha bech nasen3ou les clés mta3 Intent el clé tetkawwen men 4 e5er ar9am mel carte d'etudiant
        m3a esm el donnée elli bech netb3athha */
    public static String buildKey(String matricule, String nomCle) {
        return matricule + "_" + nomCle;
    }
}
