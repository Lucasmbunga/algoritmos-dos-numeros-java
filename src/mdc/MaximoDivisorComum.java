package mdc;

public class MaximoDivisorComum {
    public static int calcularMaximoDivisorComum(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
