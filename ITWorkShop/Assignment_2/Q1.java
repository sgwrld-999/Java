public class Q1 {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[5];
        arr[0] = 1;arr[1] = 1;arr[2] = 1;arr[3] = 1;arr[4] = 1;
        int sum = 0;
        for(int i = 0 ; i < 5 ; i++){
            sum += arr[i];
        }
        System.out.println("The required sum is : " + sum);
    }
}

