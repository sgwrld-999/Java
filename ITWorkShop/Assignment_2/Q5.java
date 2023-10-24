import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        int arr[], size;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of an array: ");
        size = sc.nextInt();
        arr = new int[size];
        takeInputArr(arr, size);
        printArr(arr, size);
    }

    public static void takeInputArr(int arr[], int size) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static void printArr(int[] arr, int size) {
        System.out.println("Printing the array in reverse:");
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
