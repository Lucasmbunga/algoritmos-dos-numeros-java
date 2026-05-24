package modular;

public class Congruencia {
    // Algoritmo de Euclides Estendido
    // Retorna um array onde [0] = MDC, [1] = x, [2] = y tais que a*x + m*y = MDC
    public static long[] euclidesEstendido(long a, long m) {
        if (m == 0) {
            return new long[]{a, 1, 0};
        }
        long[] valores = euclidesEstendido(m, a % m);
        long mdc = valores[0];
        long x1 = valores[1];
        long y1 = valores[2];

        long x = y1;
        long y = x1 - (a / m) * y1;

        return new long[]{mdc, x, y};
    }
    // Resolve: a * x === 1 (mod m)
    public static long inversoModular(long a, long m) {
        long[] resultado = euclidesEstendido(a, m);
        long mdc = resultado[0];

        if (mdc != 1) {
            throw new ArithmeticException("O inverso modular não existe pois os números não são coprimos.");
        }

        long x = resultado[1];
        // Garante que o resultado seja positivo no espaço modular
        return (x % m + m) % m;
    }
    // Resolve uma equação geral: a * x === b (mod m)
    public static long resolverCongruenciaLinear(long a, long b, long m) {
        a = a % m;
        b = b % m;
        long inv = inversoModular(a, m);
        return (inv * b) % m;
    }
}
