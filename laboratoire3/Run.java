package laboratoire3;

import java.util.HashMap;
import java.util.Map;

public class Run {

  static String mysteriousAffair = "C:\\Users\\PC\\workspace\\LOG320\\LOG320_Lab02\\LOG320_Lab03\\laboratoire3\\Test\\mysterious_affair_at_Styles-Christie.txt";
  static String monteCristo1 = "C:\\Users\\PC\\workspace\\LOG320\\LOG320_Lab02\\LOG320_Lab03\\laboratoire3\\Test\\monte_cristo_1-Dumas.txt";
  static String monteCristo2 = "C:\\Users\\PC\\workspace\\LOG320\\LOG320_Lab02\\LOG320_Lab03\\laboratoire3\\Test\\monte_cristo_2-Dumas.txt";
  static String fableFontaine = "C:\\Users\\PC\\workspace\\LOG320\\LOG320_Lab02\\LOG320_Lab03\\laboratoire3\\Test\\fables_Lafontaine.txt";
  static String l_avare = "C:\\Users\\PC\\workspace\\LOG320\\LOG320_Lab02\\LOG320_Lab03\\laboratoire3\\Test\\l_avare-Moliere.txt";
  static String adventureSherlock = "C:\\Users\\PC\\workspace\\LOG320\\LOG320_Lab02\\LOG320_Lab03\\laboratoire3\\Test\\adventures_of_Sherlock_Holmes-Doyle.txt";
static String tresGros = "C:\\Users\\PC\\workspace\\LOG320\\LOG320_Lab02\\LOG320_Lab03\\laboratoire3\\Test\\Tres_gros.txt";

  public static void main(String args[]) {
    DocDist docDist = new DocDist();
    long start;
    float tempsLineaire;
    double radian;

    start = System.nanoTime();
    docDist.docDistance(tresGros, fableFontaine);
    tempsLineaire = (float) (System.nanoTime() - start) / 1000000;
    System.out.println("Temps d'execution : " + tempsLineaire + " ms");

    // // test 1
    // System.out.println("Tres_gros et fable fontaine");
    // start = System.nanoTime();
    // radian = docDist.docDistance(tresGros, fableFontaine);
    // tempsLineaire = (float) (System.nanoTime() - start) / 1000000;
    // System.out.println("Distance : " + String.format("%.3g", radian));
    // System.out.println("Temps d'execution : " + tempsLineaire + " ms\n");

    // // test 2
    // System.out.println("monte cristo 2 et fable fontaine");
    // radian = docDist.docDistance(monteCristo2, fableFontaine);
    // tempsLineaire = (float) (System.nanoTime() - start) / 1000000;
    // System.out.println("Distance : " + String.format("%.3g", radian));
    // System.out.println("Temps d'execution : " + tempsLineaire + " ms\n");

    // // test 3
    // System.out.println("mysterious affair et monte cristo 1");
    // radian = docDist.docDistance(monteCristo2, mysteriousAffair);
    // tempsLineaire = (float) (System.nanoTime() - start) / 1000000;
    // System.out.println("Distance : " + String.format("%.3g", radian));
    // System.out.println("Temps d'execution : " + tempsLineaire + " ms\n");

  }

  private static void Test2(){
    DocDist docDist = new DocDist();
    long start;
    float tempsLineaire;

    //1
    start = System.nanoTime();
    docDist.docDistance(l_avare, fableFontaine);
    tempsLineaire = (float) (System.nanoTime() - start) / 1000000;
    System.out.println("Temps d'execution : " + tempsLineaire + " ms");

    //2
    start = System.nanoTime();
    docDist.docDistance(monteCristo2, fableFontaine);
    tempsLineaire = (float) (System.nanoTime() - start) / 1000000;
    System.out.println("Temps d'execution : " + tempsLineaire + " ms");

    //3
    start = System.nanoTime();
    docDist.docDistance(mysteriousAffair, monteCristo1);
    tempsLineaire = (float) (System.nanoTime() - start) / 1000000;
    System.out.println("Temps d'execution : " + tempsLineaire + " ms");

    //4
    start = System.nanoTime();
    docDist.docDistance(adventureSherlock, monteCristo2);
    tempsLineaire = (float) (System.nanoTime() - start) / 1000000;
    System.out.println("Temps d'execution : " + tempsLineaire + " ms");
  }

  private static void test1(){
    test test = new test();
    long start;
    float tempsLineaire;

    //1
    start = System.nanoTime();
    test.docDistance(l_avare, fableFontaine);
    tempsLineaire = (float) (System.nanoTime() - start) / 1000000;
    System.out.println("Temps d'execution : " + tempsLineaire + " ms");

    //2
    start = System.nanoTime();
    test.docDistance(monteCristo2, fableFontaine);
    tempsLineaire = (float) (System.nanoTime() - start) / 1000000;
    System.out.println("Temps d'execution : " + tempsLineaire + " ms");

    //3
    start = System.nanoTime();
    test.docDistance(mysteriousAffair, monteCristo1);
    tempsLineaire = (float) (System.nanoTime() - start) / 1000000;
    System.out.println("Temps d'execution : " + tempsLineaire + " ms");

    //4
    start = System.nanoTime();
    test.docDistance(adventureSherlock, monteCristo2);
    tempsLineaire = (float) (System.nanoTime() - start) / 1000000;
    System.out.println("Temps d'execution : " + tempsLineaire + " ms");
  }

}
