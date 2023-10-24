import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of 1st Array: ");
        int size1 = sc.nextInt();
        int arr1[] = new int[size1];
        System.out.print("Enter the elements of the first array : ");
        scanfun(arr1);
        System.out.print("Enter the size of 2nd Array: ");
        int size2 = sc.nextInt();
        int arr2[] = new int[size2];
        System.out.print("Enter the elements of the second array : ");
        scanfun(arr2);int[] resArr = mergefun(arr1, arr2);
        resArr = mergefun(arr1, arr2);
        System.out.println("Merged Array:");
        for (int value : resArr) {
            System.out.print(value + " ");
        }

    }
    public static void scanfun(int[] arr) {
        Scanner sc = new Scanner(System.in);
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
    }
    public static int[] mergefun(int[] arr1, int[] arr2) {
        int[] mergearr = new int[arr1.length + arr2.length];
        int i = 0, j = 0;
        int k = 0;
        while ((i < arr1.length) && (j < arr2.length)) {
            if (arr1[i] <= arr2[j]) {
                mergearr[k++] = arr1[i++];
            } else {
                mergearr[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {

            mergearr[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            mergearr[k++] = arr2[j++];
        }
        return mergearr;
    }
}
