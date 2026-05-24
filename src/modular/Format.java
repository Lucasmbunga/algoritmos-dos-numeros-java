package modular;

public class Format {
    public static long exponenciacaoModular(long base, long expoente, long mod) {
        long resultado = 1;
        base = base % mod;

        while (expoente > 0) {
            // Se o expoente for ímpar, multiplica com o resultado
            if ((expoente & 1) == 1) {
                resultado = (resultado * base) % mod;
            }
            // Expoente deve ser par agora
            expoente = expoente >> 1; // divide por 2
            base = (base * base) % mod;
        }
        return resultado;
    }

    // Encontra o inverso modular usando o Teorema de Fermat (Apenas se 'p' for PRIMO)
    public static long inversoFermat(long a, long p) {
        if (a % p == 0) {
            throw new ArithmeticException("O inverso não existe pois 'a' é múltiplo de 'p'.");
        }
        return exponenciacaoModular(a, p - 2, p);
    }
}
