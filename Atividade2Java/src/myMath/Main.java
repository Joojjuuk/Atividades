package myMath;

import myMathExceptions.MatrixNullException;
import myMathExceptions.NonSquareMatrixException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Selecione a operação:");
            System.out.println("1. Verificar se a matriz é nula");
            System.out.println("2. Verificar se a matriz é quadrada");
            System.out.println("3. Verificar se a matriz é diagonal");

            int opcao = scanner.nextInt();

            System.out.println("Digite o número de linhas da matriz:");
            int linhas = scanner.nextInt();
            System.out.println("Digite o número de colunas da matriz:");
            int colunas = scanner.nextInt();

            int[][] matriz = new int[linhas][colunas];

            System.out.println("Digite os elementos da matriz:");
            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                    matriz[i][j] = scanner.nextInt();
                }
            }

            switch (opcao) {
                case 1:
                    boolean isNull = MatrixUtils.isArrayNull(matriz);
                    if (isNull) {
                        System.out.println("A matriz é nula.");
                    } else {
                        System.out.println("A matriz não é nula.");
                    }
                    break;
                case 2:
                    boolean isQuadrada = MatrixUtils.isMatizQuadrada(matriz);
                    if (isQuadrada) {
                        System.out.println("A matriz é quadrada.");
                    } else {
                        System.out.println("A matriz não é quadrada.");
                    }
                    break;
                case 3:
                    boolean isDiagonal = MatrixUtils.isMatizDiagonal(matriz);
                    if (isDiagonal) {
                        System.out.println("A matriz é diagonal.");
                    } else {
                        System.out.println("A matriz não é diagonal.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } catch (MatrixNullException | NonSquareMatrixException e) {
            System.err.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

