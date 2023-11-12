public class Main {
    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter a number:");
        int ip = scanner.nextInt();
        System.out.println(isPowerOfTwo(ip));
    }
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false; // Handle non-positive numbers
        }

        int temp = n;
        int bitSize = 0;
        while (temp > 1) {
            bitSize++;
            temp /= 2;
        }
       bitSize++; // Add 1 to account for the last bit
        int i = 0; // Initialize i to 0
        temp = 0;

        while (i < bitSize) { // Use '<' instead of '<='
            int LSB = n & 1;
            if (LSB > 0 && i < bitSize - 1) {
                return false; // If there's a set bit before the last bit, it's not a power of two
            }
            int shiftLSB = LSB << i;
            temp = temp | shiftLSB;
            n = n >> 1; // Shift n to check the next bit
            i++;
        }

        return true;
    }

}