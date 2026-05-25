package rsa;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class RSA {
    private long n; // Módulo (p * q)
    private long e; // Chave Pública (Expoente de cifragem)
    private long d; // Chave Privada (Expoente de decifragem)

    // Geração de chaves baseada em dois números primos
    public void gerarChaves(long p, long q) {
        this.n = p * q;
        long phiN = (p - 1) * (q - 1);

        // 65537 é um valor padrão na criptografia devido às suas propriedades binárias
        this.e = 65537;
        while (mdcEuclides(this.e, phiN) != 1) {
            this.e++;
        }

        // d é o inverso modular de e (mod phiN)
        this.d = inversoModular(this.e, phiN);
    }

    /**
     * Alvo da modificação: Transforma o texto em bytes e cifra cada byte individualmente.
     * Retorna um array de longs (os criptogramas de cada caractere/byte).
     */
    public long[] cifrarTexto(String mensagem) {
        // Converte a string para um array de bytes usando UTF-8
        byte[] bytes = mensagem.getBytes(StandardCharsets.UTF_8);
        long[] resultadoCifrado = new long[bytes.length];

        for (int i = 0; i < bytes.length; i++) {
            // Em Java, bytes são assinados (-128 a 127). Fazemos '& 0xFF' para obter o valor positivo (0 a 255)
            long valorByte = bytes[i] & 0xFF;

            // Aplica a fórmula matemática: C = M^e mod n
            resultadoCifrado[i] = exponenciacaoModular(valorByte, this.e, this.n);
        }

        return resultadoCifrado;
    }

    /**
     * Recebe o array de números cifrados, decifra cada um de volta para byte
     * e reconstrói a String de texto original.
     */
    public String decifrarTexto(long[] criptograma) {
        byte[] bytesDecifrados = new byte[criptograma.length];

        for (int i = 0; i < criptograma.length; i++) {
            // Aplica a fórmula matemática: M = C^d mod n
            long valorByte = exponenciacaoModular(criptograma[i], this.d, this.n);

            // Converte o valor de volta para o tipo primitivo byte
            bytesDecifrados[i] = (byte) valorByte;
        }

        // Reconstrói a string a partir dos bytes decifrados em UTF-8
        return new String(bytesDecifrados, StandardCharsets.UTF_8);
    }

    // --- FUNÇÕES MATEMÁTICAS AUXILIARES ---

    private static long mdcEuclides(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    private static long inversoModular(long a, long m) {
        long m0 = m, y = 0, x = 1;
        if (m == 1) return 0;
        while (a > 1) {
            long q = a / m;
            long t = m;
            m = a % m; a = t; t = y;
            y = x - q * y; x = t;
        }
        if (x < 0) x += m0;
        return x;
    }

    private static long exponenciacaoModular(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            exp >>= 1;
            base = (base * base) % mod;
        }
        return res;
    }

    // --- DEMONSTRAÇÃO ---
    public static void main(String[] args) {
        RSA rsa = new RSA();

        // Escolha de primos ligeiramente maiores para suportar a tabela ASCII/UTF-8 expandida (valores até 255)
        // O valor de (p * q) deve ser obrigatoriamente maior que 255.
        long p = 61;
        long q = 53; // n = 61 * 53 = 3233 (3233 > 255, cumpre o requisito)

        rsa.gerarChaves(p, q);

        System.out.println("--- Chaves Geradas ---");
        System.out.println("Módulo N: " + rsa.n);
        System.out.println("Chave Pública (e): " + rsa.e);
        System.out.println("Chave Privada (d): " + rsa.d);

        // Mensagem de texto complexa com acentuação e caracteres especiais
        String textoOriginal = "Olá Mundo! RSA funcionando";
        System.out.println("\nTexto Original: " + textoOriginal);

        // 1. Cifragem
        long[] resultadoCifrado = rsa.cifrarTexto(textoOriginal);
        System.out.println("Texto Cifrado (Representação Numérica): " + Arrays.toString(resultadoCifrado));

        // 2. Decifragem
        String textoDecifrado = rsa.decifrarTexto(resultadoCifrado);
        System.out.println("Texto Decifrado: " + textoDecifrado);
    }
}
