import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size ;
        System.out.printf("Enter the size of a char array : ");
        size = sc.nextInt();
        char arr[] = new char[size];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = sc.next().charAt(0);
        }
        printArr(arr);

        System.out.printf("Enter the required key : ");
        char key ;
        key = sc.next().charAt(0); // Read the key character

        solutionFun(arr, key);
        printArr(arr);
    }

    public static void printArr(char[] arr) {
        for (char x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void solutionFun(char[] arr, char key){
        int i = 0 , j = arr.length - 1;
        while(i <= j){
            if (key == arr[i]) {
                if (arr[j] != key) {
                    swap(arr, i, j);
                }
                j--;
            } else {
                i++;
            }
        }
    }
}
