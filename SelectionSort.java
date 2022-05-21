package sample;

public class SelectionSort {
    int iMin;
    int i;
    int j;
    int k;
    int temp;
    public void sort(int[]unSortedArray,int n){
        for (i=0 ;i<=n-2;i++){
            iMin=i;
            for (j=i+1 ;j<=n-1;j++){
                if (unSortedArray[j]<unSortedArray[iMin]){
                    iMin=j;
                }
            }
            if (i !=iMin){
                temp =unSortedArray[i];
                unSortedArray[i]=unSortedArray[iMin];
                unSortedArray[iMin]=temp;
            }
        }

    }
}
