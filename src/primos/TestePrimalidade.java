package primos;

public class TestePrimalidade {

    // Teste de primalidade "divisão por tentativa"
    // Retorna true se n é primo.
    // Caso contrário, retorna false.
    public  String testarPrimalidade(int n) {
        // Casos triviais
        if (n <= 1) {
            return "O número "+n+" é COMPOSTO";
        }
        if (n == 2) {
            return "O número "+n+" é PRIMO";
        }

        // Verifica se é múltiplo de 2
        if (n % 2 == 0) {
            return "O número "+n+" é COMPOSTO"; // n é composto
        }

        // Verifica os demais fatores possíveis
        for (int d = 3; d * d <= n; d += 2) {
            if (n % d == 0) {
                return "O número "+n+" é COMPOSTO"; // n é composto
            }
        }
        return "O número "+n+" é PRIMO"; // n é primo
    }
}


