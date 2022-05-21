package sample;

public class CopyArray {

    public int[] copy(int[] array) {
        return copy(array, 0, array.length - 1);
    }

    private int[] copy(int[] array, int i, int i1) {
        int[] arrcpy = new int[array.length];
        for(i=0;i<=i1;i++){
            arrcpy[i]=array[i];
        }
        return arrcpy;
    }


}
