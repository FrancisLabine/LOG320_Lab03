package laboratoire3;

import java.io.FileInputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DocDist {
    // --pour test seulement, a retirer--
    int nombreMotA = 0;
    int nombreMotB = 0;
    // ----------------------------------

    // Ne pas changer cette fonction, elle sera utilisée pour tester votre programme
    public double docDistance(String nomFichier1, String nomFichier2) {
        Map<String, Couple> maMap = getFreqMot(nomFichier1, nomFichier2);
        if (maMap != null) {
            return trouverAngle(maMap);
        }
        return -1;
    }

    public double trouverAngle(Map<String, Couple> pMap) {
        int produiScalaire = 0;
        double normeA = 0;
        double normeB = 0;
        //calculer le produit scalaire + les norme A et B (avant la racine)
        for (String key : pMap.keySet()) {
            Couple c = pMap.get(key);
            produiScalaire += c.getProduit();
            normeA += Math.pow(c.getA(), 2);
            normeB += Math.pow(c.getB(), 2);
        }
        //racine des normes trouvés
        normeA = Math.sqrt(normeA);
        normeB = Math.sqrt(normeB);
        return Math.acos(produiScalaire / (normeA * normeB));
    }

    public Map<String, Couple> getFreqMot(String nomFichierA, String nomFichierB) {
        String split = "[-_' .,\r\n]";
        String regx = "[(){}\"\r\n!?&*:%$#@;,\\«\\»\\<\\>\\[\\]]";
        Map<String, Integer> tabFreqA = new HashMap<>();
        Map<String, Couple> tabFreqA_B = new HashMap<>();

        try {
            //Table de frequence des mots pour le fichier A
            FileInputStream fis = new FileInputStream(nomFichierA);
            Scanner sc = new Scanner(fis, "UTF-8");
            while (sc.hasNextLine()) {
                for (String mot : sc.nextLine().split(split)) {
                    String curMot = mot.replaceAll(regx, "").toLowerCase();
                    if (tabFreqA.containsKey(curMot)) {
                        tabFreqA.put(curMot, tabFreqA.get(curMot) + 1);
                    } else {
                        tabFreqA.get(curMot);
                        tabFreqA.put(curMot, 1);
                        nombreMotA += 1;
                    }
                }
            }
            sc.close();

            //Table de frequence des mots qui se trouve dans le fichier A et B
            fis = new FileInputStream(nomFichierB);
            sc = new Scanner(fis, "UTF-8");
            while (sc.hasNextLine()) {
                //Pour chaque mot dans le fichier B
                for (String mot : sc.nextLine().split(split)) {
                    String curMot = mot.replaceAll(regx, "").toLowerCase();
                    //Si le mot se trouve aussi dans le fichier A
                    if (tabFreqA.containsKey(curMot)) {
                        //Incrementer la frequence pour fichier B, sinon ajouter
                        if (tabFreqA_B.containsKey(curMot)) {
                            Couple temp = tabFreqA_B.get(curMot);
                            temp.setB(temp.getB() + 1);
                            tabFreqA_B.put(curMot, temp);
                        } else {
                            Couple temp = new Couple(tabFreqA.get(curMot), 1);
                            tabFreqA_B.get(curMot);
                            tabFreqA_B.put(curMot, temp);
                            // nombreMotB +=1;
                        }
                    }
                }
            }
            sc.close();
        } catch (Exception e) {
            return null;
        }
        return tabFreqA_B;
    }
}