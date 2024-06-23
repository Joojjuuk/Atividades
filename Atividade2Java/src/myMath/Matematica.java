package myMath;

import myMathExceptions.FatorialNegativeNumberException;
import myMathExceptions.PotenciaNegativeExponentException;


public class Matematica {

    public static double potencia(float x, int n) {

            if (n < 0)
                throw new PotenciaNegativeExponentException("Expoente negativo não é permitido.");
            else if (n == 0)
                return 1.0;
            else
                return x * potencia(x, n - 1);
    }

    public static double potencia(double x, int n) {

            if (n < 0)
                throw new PotenciaNegativeExponentException("Expoente negativo não é permitido.");
            else if (n == 0)
                return 1.0;
            else
                return x * potencia(x, n - 1);
        }

    public static long fatorial(int n) {

            if (n < 0)
                throw new FatorialNegativeNumberException("Não é possível calcular o fatorial de um número negativo.");
            else if (n == 0)
                return 1;
            else
                return n * fatorial(n - 1);
        } 

    public static long fibonacci(int n) {
        long numFib;
        if (n == 2)
            return 1;
        else {
            numFib = (long) (1 / Math.sqrt(5) * potencia((1 + Math.sqrt(5)) / 2, n)
                    - 1 / Math.sqrt(5) * potencia((1 - Math.sqrt(5)) / 2, n));
            return numFib;
        }
    }

    public static boolean isPerfectQuad(int numero) {
        int quadrado = (int) Math.sqrt(numero);
        return (quadrado * quadrado == numero);
    }

    public static boolean isFiboNumber(int num) {
        return isPerfectQuad(5 * (num * num) + 4) || isPerfectQuad(5 * (num * num) - 4);
    }
}
