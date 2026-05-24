package rsa;

public class RSA {
    private long n; // Módulo
    private long e; // Chave Pública
    private long d; // Chave Privada

    // Geração de chaves a partir de dois primos puramente didáticos
    public void gerarChaves(long p, long q) {
        this.n = p * q;
        long phiN = (p - 1) * (q - 1);

        // Escolha comum para 'e' (coprimo com phiN)
        this.e = 65537;
        while (mdcEuclides(this.e, phiN) != 1) {
            this.e++;
        }

        // d é o inverso modular de e (mod phiN)
        this.d = inversoModular(this.e, phiN);
    }

    public long cifrar(long mensagem) {
        // C = M^e mod n
        return exponenciacaoModular(mensagem, this.e, this.n);
    }

    public long decifrar(long criptograma) {
        // M = C^d mod n
        return exponenciacaoModular(criptograma, this.d, this.n);
    }

    // Auxiliares estáticos replicados aqui para o funcionamento autônomo da classe
    private static long mdcEuclides(long a, long b) {
        while (b != 0) { long r = a % b; a = b; b = r; }
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
        long res = 1; base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            exp >>= 1; base = (base * base) % mod;
        }
        return res;
    }

    // Método principal para testar o fluxo completo
    public static void main(String[] args) {
        RSA rsa = new RSA();

        // Escolha de dois primos pequenos para demonstração
        long p = 61;
        long q = 53;
        rsa.gerarChaves(p, q);

        System.out.println("--- RSA CONFIG ---");
        System.out.println("N (Módulo): " + rsa.n);
        System.out.println("e (Chave Pública): " + rsa.e);
        System.out.println("d (Chave Privada): " + rsa.d);

        // Caractere simulado como inteiro
        long mensagemOriginal = 42;
        System.out.println("\nMensagem Original: " + mensagemOriginal);

        long criptograma = rsa.cifrar(mensagemOriginal);
        System.out.println("Mensagem Cifrada: " + criptograma);

        long mensagemDecifrada = rsa.decifrar(criptograma);
        System.out.println("Mensagem Decifrada: " + mensagemDecifrada);
    }
}
