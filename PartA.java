import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class PartA {

    public static int LinearSearch(int[] a, int key){
        for(int i = 0; i < a.length -1; i++ ){ //looping through the array to look for key
            if(a[i] == key){ //if key is found return index/position found at
                return i;
            }
        }
        return -1; //if key is not found
    }

    public static boolean binarySearch(int [] a, int key){
        //beginning, middle, end of the array
        int beginning = 0;
        int end = a.length - 1; //the end is the length of the array
        int middle; //setting a variable for the middle of the array

        while (beginning <= end) //while the end is greater than the beginning
        {
            middle = (beginning + end)/2; //we find the middle by dividing the array in half
            if(a[middle] == key) //if the middle index holds they key were done searching
            {
                return true;
            }
            else if(a[middle] < key) //else we have to keep searching through the array
            {
                end = middle - 1;
            }
            else if(a[middle] > key)
            {
                beginning = middle + 1;
            }
        }
        return false;
    }


    public static void main (String[] args){

        //---------------Part A:------------------------

        Scanner scnr = new Scanner(System.in);

        int key;
        int num;
        double beginning;
        double end;
        double binary = 0.00;
        double linear = 0.00;
        double binary_time = 0;
        double linear_time = 0;

        Random random = new Random();

        System.out.println("Part A: Please enter a positive integer:  ");

        num = scnr.nextInt();
        int [] arr = new int [num];
        //making the array based on the number the user inputs

        for(int i = 0; i < arr.length -1; i++){
            arr[i] = random.nextInt(1000 +1 + 1000) - 1000;
            //generating numbers from -1000 to 1000
        }

        Arrays.sort(arr);

        for(int i = 0; i < 100; i++) {
            //looping 100 times

            key = arr[random.nextInt(num)];
            //has a bound of num

            //binary search
            beginning = System.nanoTime();
            binarySearch(arr, key);
            end = System.nanoTime();
            binary = end - beginning;
            binary_time += binary;

            //linear search
            beginning = System.nanoTime();
            LinearSearch(arr, key);
            end = System.nanoTime();
            linear_time = end - beginning;
            linear_time += linear;
        }

        System.out.println("Binary Search Time: " + binary_time + " nanoseconds ");
        System.out.println("Linear Search Time: " + linear_time + " nanoseconds");

        

        //----------------Part B: -------------------

        System.out.println("\nPart B: Please enter a positive integer:");

        num = scnr.nextInt();
        arr = new int[num];

        for(int i = 0; i < arr.length -1; i++){
            arr[i] = random.nextInt(1000 + 1 + 1000) - 1000;
            //generating numbers between -1000 to 1000
        }

        Arrays.sort(arr);
        key = 5000;
        double OneLine;
        double runtime;
        double math = Math.log(2);

        arr = new int[num];
        beginning = System.nanoTime();
        binarySearch(arr, key);
        end = System.nanoTime();
        binary = end - beginning;
        //binary time will be the end of the array minus the beginning of the array


        OneLine = (binary / ((Math.log(num) / math)));

        System.out.println("One Step: " + OneLine + " nanoseconds");

        System.out.println("The worst-case Running Time for Binary Search when n = 10^5 : "
                + binary + " nanoseconds");

        //Calculating running time when n = 10^5
        runtime = (OneLine * (Math.log(Math.pow(10, 5)) / math));
        System.out.println("Binary Search Worst-Case Running time  : " + runtime  + " nanoseconds");

        runtime = (OneLine * Math.pow(10, 5));

        System.out.println("Linear Search Worst-Case Running time  : " + runtime  + " nanoseconds");

    }
}

