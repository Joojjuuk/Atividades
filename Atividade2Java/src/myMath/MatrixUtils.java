package myMath;

import myMathExceptions.MatrixNullException;
import myMathExceptions.NonSquareMatrixException;

public class MatrixUtils {

    public static boolean isArrayNull(int[][] array) {
            if (array == null)
                throw new MatrixNullException("Matriz não inicializada.");
            for (int[] row : array) {
                for (int element : row) {
                    if (element != 0) {
                     return false;
                    }
                }
            }
            return true;
        }

    public static boolean isMatizQuadrada(int[][] array) {

            if (array == null)
                throw new MatrixNullException("Matriz não inicializada.");
            int linhas = array.length;
            for (int[] row : array) {
                if (row.length != linhas) {
                    return false;
                }
            }
            return true;
        } 
    public static boolean isMatizDiagonal(int[][] array) {

            if (array == null)
                throw new MatrixNullException("Matriz não inicializada.");
            if (!isMatizQuadrada(array))
                throw new NonSquareMatrixException("Matriz não é quadrada.");
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (i != j && array[i][j] != 0) {
                        return false;
                    }
                }
            }
            return true;
        } 
    }

