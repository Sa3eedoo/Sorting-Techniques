package sample;

public class MergeSort {
    // Breaks down the array to single or null elements in array.
    public int[] sort(int[] array) {

        // Recursive control 'if' statement.
        if(array.length <= 1) {
            return array;
        }

        int midpoint = array.length / 2;

        // Declare and initialize left and right arrays.
        int[] left = new int[midpoint];
        int[] right;

        if(array.length % 2 == 0) { // if array.length is an even number.
            right = new int[midpoint];
        } else {
            right = new int[midpoint + 1];
        }
        // Populate the left and right arrays.
        for(int i=0; i < midpoint; i++) {
            left[i] = array[i];
        }

        for(int j=0; j < right.length; j++) {
            right[j] = array[midpoint+j];
        }

        // Recursive call for left and right arrays.
        left = sort(left);
        right = sort(right);

        // Get the merged left and right arrays.
        array = merge(left, right);

        // Return the sorted merged array.
        return array;

    }

    // Merges the left and right array in ascending order.
    private static int[] merge(int[] left, int[] right) {

        // Merged result array.
        int[] result = new int[left.length + right.length];

        // Declare and initialize pointers for all arrays.
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        // While there are items in either array...
        while(leftPointer < left.length || rightPointer < right.length) {

            // If there are items in BOTH arrays...
            if(leftPointer < left.length && rightPointer < right.length) {

                // If left item is less than right item...
                if(left[leftPointer] < right[rightPointer]) {

                    result[resultPointer] = left[leftPointer];
                    resultPointer=resultPointer+1;
                    leftPointer=leftPointer+1;

                } else {

                    result[resultPointer] = right[rightPointer];
                    resultPointer=resultPointer+1;
                    rightPointer=rightPointer+1;

                }

            }

            // If there are only items in the left array...
            else if(leftPointer < left.length) {

                result[resultPointer] = left[leftPointer];
                resultPointer=resultPointer+1;
                leftPointer=leftPointer+1;

            }

            // If there are only items in the right array...
            else if(rightPointer < right.length) {

                result[resultPointer] = right[rightPointer];
                resultPointer=resultPointer+1;
                rightPointer=rightPointer+1;
            }

        }

        return result;

    }
}
