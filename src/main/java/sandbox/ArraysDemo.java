package sandbox;

import java.util.Arrays;

public class ArraysDemo {
    public static void main(String... args){  //strange but good enough
        int[] array = new int[fSize()];
        System.out.println(array[3]);
        System.out.println(array.length);
        try {
            System.out.println(array[10]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("oops");
        }

        int[][] matrix = new int[2][0];
        matrix[0] = new int[3];
        matrix[1] = new int[3];

        int[][][] cubex = new int[2][0][];
        cubex[0] = new int[3][];
        cubex[1] = new int[3][];

        //region literal
        int[] literal = {1,2,3};
        int[][] literal2dim = {{},{1},{2,3}};
        //endregion
        doSmthwithArray(new int[] {1,2});

        for (int current :array) {
            System.out.println(current);
        }

        doSmthwithArgs( );
        doSmthwithArgs(1 );
        doSmthwithArgs(1,2 );
        doSmthwithArgs(1,2,3 );
    }

    private static void doSmthwithArgs(int... args) {
        for (int current :args) {
            System.out.println(current);
        }

    }

    private static void doSmthwithArray( int[] param) {

    }

    private static int fSize() {
        return 10;
    }
}
