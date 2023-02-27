package laboratoire3;

import java.util.HashMap;
import java.util.Map;

public class Run {

  static String mysteriousAffair = "C:\\Users\\PC\\workspace\\LOG320\\LOG320_Lab02\\LOG320_Lab03\\laboratoire3\\Test\\mysterious_affair_at_Styles-Christie.txt";
  static String monteCristo1 = "C:\\Users\\PC\\workspace\\LOG320\\LOG320_Lab02\\LOG320_Lab03\\laboratoire3\\Test\\monte_cristo_1-Dumas.txt";
  static String monteCristo2 = "C:\\Users\\PC\\workspace\\LOG320\\LOG320_Lab02\\LOG320_Lab03\\laboratoire3\\Test\\monte_cristo_2-Dumas.txt";
  static String fableFontaine = "C:\\Users\\PC\\workspace\\LOG320\\LOG320_Lab02\\LOG320_Lab03\\laboratoire3\\Test\\fables_Lafontaine.txt";
  static String l_avare = "C:\\Users\\PC\\workspace\\LOG320\\LOG320_Lab02\\LOG320_Lab03\\laboratoire3\\Test\\l_avare-Moliere.txt";

  public static void main(String args[]) {
    long start = System.nanoTime();

    DocDist docDist = new DocDist();

    float tempsLineaire = (float) (System.nanoTime() - start) / 1000000;

    System.out.println("La distance cosinus entre les deux documents est de : " +
        docDist.docDistance(l_avare, fableFontaine) + " radians\n");

    System.out.println("Temps d'execution : " + tempsLineaire + " ms\n");

    // System.out.println("Nombre de mot distinct A : " + docDist.nombreMotA +
    //  "\n");

    // for (String s : test.keySet()) {
    // //System.out.println(s + " " + test.get(s).getA() + " " +
    // test.get(s).getB());
    // }
  }

  // Map<String, Couple> test = getFreqMotTest("(String) \"pour\" pour [tester]
  // aujourd'hui", "String pour");
  public static Map<String, Couple> getFreqMotTest(String contenu1, String contenu2) {
    Map<String, Integer> tabFreq = new HashMap<>();
    Map<String, Couple> tabFreq2 = new HashMap<>();
    try {

      for (String mot : contenu1.split("[' ]")) {
        String curMot = mot.replaceAll("[(){}\"!?&*\\[\\]]", "");
        if (tabFreq.containsKey(curMot)) {
          tabFreq.put(curMot, tabFreq.get(curMot) + 1);
        } else {
          tabFreq.get(curMot);
          tabFreq.put(curMot, 1);
        }
      }

      for (String mot : contenu2.split("[' ]")) {
        String curMot = mot.replaceAll("[(){}\"!;?&*\\[\\]]", "");
        if (tabFreq.containsKey(curMot)) {
          if (tabFreq2.containsKey(curMot)) {
            Couple temp = tabFreq2.get(curMot);
            temp.setB(temp.getB() + 1);
            tabFreq2.put(curMot, temp);
          } else {
            Couple temp = new Couple(tabFreq.get(curMot), 1);
            tabFreq2.get(curMot);
            tabFreq2.put(curMot, temp);
          }
        }
      }

    } catch (Exception e) {
      // TODO: handle exception
    }

    return tabFreq2;
  }

}
