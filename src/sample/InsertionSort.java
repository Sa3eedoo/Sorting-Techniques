package sample;

public class InsertionSort {
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int start, int end) {
        if (start >= end)
            return;



        int Index;
        int Counter;
        int temp;
        for(Counter =0; Counter <=end; Counter++)
        {
            temp= array[Counter];
            Index = Counter;
            while(Index >0 && array[Index -1]>temp)
            {
                array[Index]= array[Index -1];
                Index--;
            }
            array[Index]=temp;
        }


    }

}
