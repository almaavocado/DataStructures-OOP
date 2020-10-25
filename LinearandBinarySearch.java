import java.util.Scanner;

public class LinearandBinarySearch {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Please enter an integer to find the square root of: ");
        int N = scnr.nextInt();
        System.out.println("The square root is: " + squareRoot(N));
        System.out.println("Enter a number (Range): ");
        int m = scnr.nextInt();
        int[] Array = {0, 1, 3, 6, 8 ,9};
        //int[] Array2 = {2, 5, 7, 11};
        //int[] Array3 = {0, 1, 2, 3, 4};
        //int[] Array4 = {12};
        System.out.println("The smallest missing number is: " + missingNumber(Array, 0, m));
        //System.out.println("The smallest missing number is: " + missingNumber(Array2, 0, m));
        //System.out.println("The smallest missing number is: " + missingNumber(Array3, 0, m ));
        //System.out.println("The smallest missing number is: " + missingNumber(Array4, 0, m));
    }

    //     ------------    Part A   ------------

    private static int squareRoot(int N) {
        int middle_index = N / 2;
        System.out.println(middle_index);

        //implementing binary search when we divide by 2 to find the middle "index"

        while (middle_index * middle_index != N){
            /*
            if our number (middle index) does not equal N when we multiply it with each other
            then we do not have our square root.
            */

            if (middle_index * middle_index > N) {

                int temp = middle_index - 1;

                if ((middle_index * middle_index > N) && ((temp)*(temp) < N)) {
                    break;
                }
                middle_index = middle_index - 1;
                System.out.println(middle_index);
            }
            else{
                middle_index = middle_index + 1;
                System.out.println(middle_index);
            }
        }
        return middle_index;
    }


    //          -------------  Part B --------------

    private static int missingNumber(int[] distinctArray, int first_num, int last) {
        boolean flag = true;
        first_num = 0;
        int middle;
        last = distinctArray.length - 1;
        int missing_number = 0 ;

        while (flag) {
            if (first_num >= last) {
                missing_number = last + 1;
                //System.out.println(missing_number);
                flag = false;
            }
            if (first_num != distinctArray[first_num]) {
                missing_number = first_num;
                //System.out.println(missing_number);
                flag = false;
            }
            middle = (first_num + last) / 2;
            if (distinctArray[middle] == middle) {
                first_num = middle + 1;
                //System.out.println(first_num);
            }
            else if (distinctArray[middle] != middle) {
                last = middle;
                //System.out.println(last);
            }
        }
        return missing_number;
    }
}

