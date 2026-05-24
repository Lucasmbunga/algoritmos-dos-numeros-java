package primos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FactorizacaoInteiros {
    public static void main(String[] args) {
        System.out.println("Fatores de 10 = " + factorar(10));
        System.out.println("Fatores de 50 = " + factorar(50));
        System.out.println("Fatores de 24 = " + factorar(24));
        System.out.println("Fatores de 350 = " + factorar(350));
        System.out.println("Fatores de 107 = " + factorar(107));
        System.out.println("Fatores de 1025 = " + factorar(1025));
        System.out.println("Fatores de 3 * 5 * 7 * 11 * 13 * 17 = " +
                factorar(14));
    }
    public static List<Integer> factorar(int n){
        // O fatores são armazenados numa lista ligada
        // Entretanto você pode usar a estrutura que quiser
        // Exemplos: Array, ArrayList, Stack (pilha)
        List<Integer> factors = new ArrayList<>();

        // Verifica se 2 é fator
        while(n % 2 == 0){
            factors.add(2);
            n = n / 2;
        }

        // Agora verifica os possíveis fatores ímpares
        // Só ímpares são possíveis
        int d = 3; // Possíveis fatores
        int d2 = 9; // d2 = d * d
        while(d2 <= n){
            // Se d é fator, faz a divisão e armazena o fator
            if(n % d == 0){
                factors.add(d);
                n = n / d;
            }else{
                // Se d não é fator, verifica o próximo
                d = d + 2;
                d2 = d * d;
            }
        }
        if(n > 1){
            factors.add(n);
        }
        return factors;
    }
}
