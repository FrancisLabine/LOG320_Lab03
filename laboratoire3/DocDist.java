package laboratoire3;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class DocDist {
    // Ne pas changer cette fonction, elle sera utilisée pour tester votre programme
    public double docDistance(String nomFichier1, String nomFichier2) {
        HashMap<String, Couple> maMap = getFreqMot(nomFichier1, nomFichier2);
        if (maMap != null) {
            return trouverAngle(maMap);
        }
        return -1;
    }

    public double trouverAngle(HashMap<String, Couple> pMap) {
        int produitScalaire = 0;
        double normeA = 0;
        double normeB = 0;
        //calculer le produit scalaire + les norme A et B (avant la racine)
        for (String key : pMap.keySet()) {
            Couple c = pMap.get(key);
            produitScalaire += c.getProduit();
            normeA += Math.pow(c.getA(), 2);
            normeB += Math.pow(c.getB(), 2);
        }
        //racine des normes trouvés
        normeA = Math.sqrt(normeA);
        normeB = Math.sqrt(normeB);
        return Math.acos(produitScalaire/(normeA * normeB) );
    }

    public HashMap<String, Couple> getFreqMot(String nomFichierA, String nomFichierB) {
        String split = "[\\-\\_\\'\\ \\.\\;\\\\/:\\,\t\r\n]";
        String regx = "[(){}\\ \"\t\r\n!\\?\\&\\*\\:\\%\\$\\#\\;\\,\\`\\«\\»\\<\\>\\[\\]]";
        HashMap<String, Integer> tabFreqA = new HashMap<>();
        HashMap<String, Couple> tabFreqA_B = new HashMap<>();

        try {
            //Table de frequence des mots pour le fichier A
            FileInputStream fis = new FileInputStream(nomFichierA);
            Scanner sc = new Scanner(fis, "UTF-8");
            while (sc.hasNextLine()) {
                for (String mot : sc.nextLine().split(split)) {
                    String curMot = mot.replaceAll(regx, "").toLowerCase();
                    if(curMot.length() > 0){
                        if (tabFreqA.containsKey(curMot)) {
                            tabFreqA.put(curMot, tabFreqA.get(curMot) + 1);
                        } else {
                            tabFreqA.get(curMot);
                            tabFreqA.put(curMot, 1);
                        }
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