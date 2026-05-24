package euler;

public class TotienteEuler {
    public static long phi(long n) {
        long resultado = n;

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                resultado -= resultado / i;
            }
        }
        if (n > 1) {
            resultado -= resultado / n;
        }
        return resultado;
    }
}
