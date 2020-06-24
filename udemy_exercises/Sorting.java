package udemy_exercises;

import java.util.Scanner;

class Sorting {
    static final Scanner sc = new Scanner(System.in);

    public static int[] sortIntegers(int[] nums) {
        int[] arr = new int[nums.length];
        int temp;
        boolean isDone = false;

        for(int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }

        while(!isDone) {
            isDone = true;

            for(int i = 0; i < arr.length - 1; i++) {
                if(arr[i] < arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;

                    isDone = false;
                }
            }
        }

        return arr;
    }

    public static void printNums(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println("Value at index " + i + ": " + arr[i]);
        }
    }

    public static int[] getNums(int size) {
        int[] inNums = new int[size];
        System.out.println("Please enter " + size + " integers:\r");

        for(int i = 0; i < size; i++) {
            inNums[i] = sc.nextInt();
        }

        return inNums;
    }

    public static int[] reverse(int[] numbers) {
        int[] arr = new int[numbers.length];

        for(int i = arr.length - 1, counter = 0; i >= 0; i--, counter++) {
            arr[counter] = numbers[i];
        }

        return arr;
    }

    public static void main(String[] args) {
        System.out.println("This is the Sorting Class");

        int[] intArr = getNums(5);
        int[] sorted = sortIntegers(intArr);

        printNums(sorted);
        System.out.println();

        int[] reversed = reverse(sorted);

        printNums(reversed);
    }

}
