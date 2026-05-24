package primos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestePrimalidade {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int numero;
        while (true){
            System.out.println("Insira um número inteiro:");
             numero=scan.nextInt();
            if (numero>2)  break;
        }

        String resultado=divisaoSucessiva(numero);
        System.out.println(resultado);
    }

    public static String divisaoSucessiva(int n){
        if(n%2==0){
            return n+" é composto";
        }
        int d=3;
        while (d<(int)Math.sqrt(n)+1){
            if(n%d==0){
                return n+" é composto";
            }
            d+=2;

        }
        return n+" é Primo";

    }

    public static void testeDePrimalidadeFermat(int n,int t){
        if(t>n-3){
            t=n-3;
        }
        List<Integer> bases=new ArrayList<>();
        while (bases.size()<=t){

        }
    }
}
