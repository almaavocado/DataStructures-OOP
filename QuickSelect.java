package Lab3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSelect {
    public static int rand(int min, int max) {
        //generating random array from -100 to 100
        return new Random().nextInt(max - min + 1) + min;
    }

    public static void swap(int[] arr, int i, int j) {

        int temp = 0;
        //performing the swap
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static int partition(int arr[], int left, int right){

        int pivot = arr[right];
        int len = arr.length;

        int i = 0;
        int j = right - 1;

        for(int k = 0; k < len - 1; k ++ ){
            if(arr[i] < pivot){
                i++;
            }

            else{
                while(j > i) {
                    if(arr[j] < pivot){
                        swap(arr,j, i);
                    }
                    j--;
                }
            }
        }

        swap(arr, right, i);

        return j;


    }

    public static int quickSelect(int[] arr, int left, int right, int k) {
        // If the array contains only one element, return that element
        if (left == right) {
            return arr[left];
        }

        int pivotIndex = rand(left, right);

        pivotIndex = partition(arr, left, right);

        // The pivot is sorted
        if (k == pivotIndex) {
            return arr[k];
        }

        //  k is < pivotIndex
        else if (k < pivotIndex) {
            return quickSelect(arr, left, pivotIndex - 1, k);
        }

        // k is > the pivotIndex
        else {
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }


    public static int [] MaxKnums(int arr[], int low, int high, int K) {

        //same thing as QuickSelect but now for largest K

        int pivotIndex1 = rand(low, high);


        pivotIndex1 = partition(arr, low, high);

        int largeK = arr.length - 1 - K;

        if (pivotIndex1 == largeK) {

            return Arrays.copyOfRange(arr, largeK, arr.length-1);

        } else if (pivotIndex1 < largeK) {

            return MaxKnums(arr, pivotIndex1 + 1, high, K);
        }
        else {
            return MaxKnums(arr, low, pivotIndex1 - 1, K);
        }
    }


    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        /// ---------- Part A ---------

        System.out.println("Smallest Element");
        System.out.println("Please enter a positive integer: ");
        int n = scan.nextInt();
        int arr[] = new int[n];

        Random random = new Random();


        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100 - (-100)) + 100;
        }

        System.out.println("Array Generated: ");
        System.out.println(Arrays.toString(arr));


        System.out.println("Enter kth value:");
        int K = scan.nextInt();

        System.out.print("K'th smallest element is "
                + quickSelect(arr, 0, arr.length - 1, K));



        /// -------- Part B ---------

        System.out.println("\n\nMax K");
        System.out.println("Please enter a positive integer: ");
        int n2 = scan.nextInt();
        int arr2[] = new int[n2];



        for (int j = 0; j < n2; j++) {
            arr2[j] = random.nextInt(100 - (-100)) + 100;
        }

        System.out.println("Array Generated: ");
        System.out.println(Arrays.toString(arr2));


        System.out.println("Enter kth value:");
        int K2 = scan.nextInt();

        int LargestkthValues [] = MaxKnums(arr2, 0, n2 - 1, K2 );
        System.out.println("Kth Largest Elements: " + Arrays.toString(LargestkthValues));

    }
}
