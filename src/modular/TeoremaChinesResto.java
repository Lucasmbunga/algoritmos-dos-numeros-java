package modular;

import static modular.Congruencia.euclidesEstendido;

public class TeoremaChinesResto {
    // Encontra o inverso modular usando o Euclides Estendido: (a * x) % m == 1
    public static long inversoModular(long a, long m) {
        long[] resultado = euclidesEstendido(a, m);
        long x = resultado[1];
        return (x % m + m) % m;
    }

    public static long teoremaChinesResto(long[] a, long[] m) {
        long produtoM = 1;
        for (long modulo : m) {
            produtoM *= modulo;
        }

        long x = 0;
        for (int i = 0; i < a.length; i++) {
            long M_i = produtoM / m[i];
            long inverso = inversoModular(M_i, m[i]);
            x += a[i] * M_i * inverso;
        }

        return x % produtoM;
    }
}
