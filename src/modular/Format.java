package modular;

public class Format {
    public static int exponenciacaoModular(int base, int expoente, int mod) {
        int resultado = 1;
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
}
