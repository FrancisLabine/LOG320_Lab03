package laboratoire3;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class DocDist {
    String split = "[\\-\\_\\'\\ \\.\\;\\\\/:\\,\t\r\n]";
    String regx = "[(){}\\ \"\t\r\n!\\?\\&\\*\\:\\%\\$\\#\\;\\,\\`\\«\\»\\<\\>\\[\\]]";

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
        // calculer le produit scalaire + les norme A et B (avant la racine)
        for (String key : pMap.keySet()) {
            Couple c = pMap.get(key);
            produitScalaire += c.getProduit();
            normeA += Math.pow(c.getA(), 2);
            normeB += Math.pow(c.getB(), 2);
        }
        // racine des normes trouvés
        normeA = Math.sqrt(normeA);
        normeB = Math.sqrt(normeB);
        return Math.acos(produitScalaire / (normeA * normeB));
    }

    public HashMap<String, Couple> getFreqMot(String pNomFichierA, String pNomFichierB) {
        HashMap<String, Integer> tabFreqA = new HashMap<>();
        HashMap<String, Couple> tabFreqA_B = new HashMap<>();

        try {
            // Table de frequence des mots pour le fichier A
            tabFreqA = getFreqMotA(pNomFichierA);
            // Table de frequence des mots qui se trouve dans le fichier A et B
            tabFreqA_B = getFreqMotBsurA(tabFreqA, pNomFichierB);
            return tabFreqA_B;
        } catch (Exception e) {
            return null;
        }
    }

    private HashMap<String, Integer> getFreqMotA(String pNomFichierA) {
        HashMap<String, Integer> tabFreqA = new HashMap<>();
        try {
            // Table de frequence des mots pour le fichier A
            FileInputStream fis = new FileInputStream(pNomFichierA);
            Scanner sc = new Scanner(fis, "UTF-8");
            String newLine;
            while (sc.hasNextLine()) {
                newLine = sc.nextLine();
                if (!newLine.isBlank()) {
                    for (String mot : newLine.split(split)) {
                        String curMot = mot.replaceAll(regx, "").toLowerCase();
                        if (curMot.length() > 0) {
                            if (tabFreqA.containsKey(curMot)) {
                                tabFreqA.merge(curMot, 1, Integer::sum);
                            } else {
                                tabFreqA.put(curMot, 1);
                            }
                        }
                    }
                }
            }
            sc.close();
            return tabFreqA;
        } catch (Exception e) {
            return null;
        }
    }

    private HashMap<String, Couple> getFreqMotBsurA(HashMap<String, Integer> pTableA, String pNomFichierB) {
        HashMap<String, Couple> tabFreqA_B = new HashMap<>();
        try {
            FileInputStream fis = new FileInputStream(pNomFichierB);
            Scanner sc = new Scanner(fis, "UTF-8");
            String newLine;
            while (sc.hasNextLine()) {
                newLine = sc.nextLine();
                if (!newLine.isBlank()) {
                    // Pour chaque mot dans le fichier B
                    for (String mot : newLine.split(split)) {
                        String curMot = mot.replaceAll(regx, "").toLowerCase();
                        // Si le mot se trouve aussi dans le fichier A
                        if (pTableA.containsKey(curMot)) {
                            // Incrementer la frequence pour fichier B, sinon ajouter
                            if (tabFreqA_B.containsKey(curMot)) {
                                tabFreqA_B.get(curMot).incrementeB();
                            } else {
                                tabFreqA_B.put(curMot, new Couple(pTableA.get(curMot), 1));
                            }
                        }
                    }
                }
            }
            sc.close();
            return tabFreqA_B;
        } catch (Exception e) {
            return null;
        }
    }
}