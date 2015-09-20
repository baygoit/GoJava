package ua.goit.alg;

public class PowInMax32Iterations {

  public static void main(String[] args) {
    System.out.println((pow(2,10) == Math.pow(2,10)));
  }

  private static int pow(int number, int pow) {
    
    if (number == 0) {return 0;}
    
    int result = 1;
    int base = number;
    int mask = 1;
    for (int i = 1; i < Integer.SIZE; i++) {
      if ((mask & pow) == mask) {
        result *= base;
      }
      base *= base;
      mask <<= 1;
    }
    return result;
  }

}
