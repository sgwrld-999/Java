import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        int inp1 , inp2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 1st num : ");
        inp1 = sc.nextInt();
        System.out.println("Enter the 2nd num : ");
        inp2 = sc.nextInt();
        if(inp2 == 0){
            System.out.println("False");
            return;
        }
        if (ifElseLadder(inp1,inp2))
            System.out.println("True");
        else
            System.out.println("False");
        if(ternaryOperator(inp1,inp2))
            System.out.println("True");
        else
            System.out.println("False");
    }
    public static boolean ifElseLadder(int num1 , int num2){
        if (num1%num2 == 0)
            return true;
        else
            return false;
    }
    public static boolean ternaryOperator(int num1 , int num2){
        boolean hold;
        hold = (num1%num2 == 0) ? true : false ;
        return hold ;
    }
}
