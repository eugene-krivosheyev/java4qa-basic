package com.acme.dbo.txlog.message.utils;

public class DecoratingUtils {
    private DecoratingUtils() {

    }

    public static String arrayToString(final int[] arr) {
        return arrayToString(arr, false);
    }

    private static String arrayToString(final int[] arr, final boolean isNewLineForBraces) {
        StringBuilder sb = new StringBuilder("{").append(isNewLineForBraces ? System.lineSeparator() : "");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(isNewLineForBraces ? System.lineSeparator() : "").append("}");
        return sb.toString();
    }

    public static String matrixToString(final int[][] matrix) {
        return matrixToString(matrix, false);
    }

    private static String matrixToString(final int[][] matrix, boolean isNewLineForInnerBraces) {
        StringBuilder sb = new StringBuilder("{" + System.lineSeparator());
        for (int[] ints : matrix) {
            sb.append(arrayToString(ints, isNewLineForInnerBraces)).append(System.lineSeparator());
        }
        sb.append("}");
        return sb.toString();
    }

    public static String multiMatrixToString(final int[][][][] matrix) {
        StringBuilder sb = new StringBuilder("{" + System.lineSeparator());
        for (int[][][] array3d : matrix) {
            sb.append("{").append(System.lineSeparator());
            for (int[][] array2d : array3d) {
                sb.append(matrixToString(array2d, true)).append(System.lineSeparator());
            }
            sb.append("}").append(System.lineSeparator());
        }
        sb.append("}");

        return sb.toString();
    }
}
