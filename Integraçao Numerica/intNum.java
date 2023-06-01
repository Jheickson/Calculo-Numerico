public class intNum {
    public static void main(String args[]) {
      
      int n = 2;
      
      double x1 = 1;
      double x2 = 7;
      
      double[] f;
      
      for (int i = 1 ; i <= n ; i++ ){

      int h = Math.abs( (int)x1 - (int)x2);
      
      f[i] = (double) (1 / (Math.pow(x1, 2)));
      f[i+1] = (double) (1 / (Math.pow(x2, 2)));

      double A = (h/n) * (f[1] + f[2]);

      System.out.println(A);
      System.out.println(A - 3.0612);
      }

      System.out.println("Teste")

    }
}