
public class Main {
 
    static int power(int root, int power) {
        int result = 1;
        int pow = root;
        int n = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & power) == n) {
                result *= pow;
            }
            pow *= pow;
            n <<= 1;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        power(3,19);
    }

}