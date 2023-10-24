import java.util.Scanner;

public class Q2 {
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
        scanfun(arr2);
        System.out.print("Enter the size of 3rd Array: "); // Changed "3nd" to "3rd"
        int size3 = sc.nextInt();
        int arr3[] = new int[size3];
        System.out.print("Enter the elements of the third array : ");
        scanfun(arr3);
        int k ;
        System.out.print("Enter the K : ");
        k = sc.nextInt();
        int[] resArr = mergefun(arr1, arr2);
        resArr = mergefun(resArr, arr3);
        resArr = solutionFun(resArr,k);
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

    public static int[] solutionFun(int[] arr, int size) {
        int[] res = new int[size];
        int ctr1 = 0;
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (k != size) {
                if (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                    ctr1++;
                    if (ctr1 != 3) {
                        res[k++] = arr[i];
                    }
                }
            }
        }
        return res;
    }
}