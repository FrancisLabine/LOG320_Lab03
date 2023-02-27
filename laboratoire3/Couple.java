package laboratoire3;

public class Couple {
  int a;
  int b;

  public Couple() {
    a = 0;
    b = 0;
  }

  public Couple(int pA, int pB) {
    a = pA;
    b = pB;
  }

  public int getA() {
    return a;
  }

  public int getB() {
    return b;
  }

  public void setA(int pA) {
    a = pA;
  }

  public void setB(int pB) {
    b = pB;
  }

  public int getProduit(){
      return a*b;
  }
}
