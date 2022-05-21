package sample;

public class BubbleSort {
    int flag;
    int i;
    int j;
    int k;
    int temp;
    public void sort(int[]unSortedArray,int n){
        for (i=1;i<=n-1;i++){
            flag=0;
            for (j=0;j<=n-i-1;j++){
                if (unSortedArray[j]>unSortedArray[j+1]){
                    temp=unSortedArray[j];
                    unSortedArray[j]=unSortedArray[j+1];
                    unSortedArray[j+1]=temp;
                    flag=1;
                }

            }
            if (flag==0){
                break;
            }
        }

    }
}
