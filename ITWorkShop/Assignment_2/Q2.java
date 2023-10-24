import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array : ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        scanClass(arr, size);

        System.out.println("Input array:");
        printArray(arr);

        hash(arr, size);
    }

    public static void scanClass(int arr[], int size) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void hash(int arr[], int size) {
        int hash[] = new int[100001];
        for (int i = 0; i < size; i++) {
            hash[arr[i]]++;
        }
        printUniqueFreq(hash);
    }

    public static void printUniqueFreq(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                System.out.println("Number: " + i + " Frequency: " + arr[i]);
            }
        }
    }
}
