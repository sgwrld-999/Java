import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        System.out.println("We've to find the Two pair which sum is closest to zero.");
        Scanner sc = new Scanner(System.in);
        int size;
        System.out.printf("Enter the size of an array : ");
        size = sc.nextInt();
        int arr[] = new int[size];
        System.out.printf("Enter the elements of the an array : ");
        scanfun(arr);
        int res[] = new int[2];
        res = brute_force(arr);
        System.out.println("Printing the resulting pair using Brute force with Time Complexity of O(N^2) and Space-Comp : O(1)");
        printArr(res);
        quickSort(arr, 0, size - 1);
        res = efficient_method(arr);
        System.out.println("Printing the resulting pair using Efficient-Method with Time Complexity of O(nLogn) and space Complexity O(1):");
        printArr(res);
    }

    public static void scanfun(int[] arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static int[] brute_force(int[] arr) {
        int res[] = new int[2];
        int closestSum = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int tempSum = arr[i] + arr[j];
                if (Math.abs(tempSum) < Math.abs(closestSum)) {
                    closestSum = tempSum;
                    res[0] = arr[i];
                    res[1] = arr[j];
                }
            }
        }
        return res;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int[] efficient_method(int[] arr) {
        int res[] = new int[2];
        int closestSum = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int tempSum = arr[i] + arr[left] + arr[right];
                if (Math.abs(tempSum) < Math.abs(closestSum)) {
                    closestSum = tempSum;
                    res[0] = arr[i];
                    res[1] = arr[left];
                }

                if (tempSum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    public static void printArr(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
