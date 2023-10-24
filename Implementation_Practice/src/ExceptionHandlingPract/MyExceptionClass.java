package ExceptionHandlingPract;

import java.util.Random;

public class MyExceptionClass extends Exception{
//    public MyExceptionClass(String message) {
//        super(message);
//    }
//    int sol = 111/d;
//    public static void main(String[] args) {
//        int d = 0 ;
//        /* The benefit of the Exception handling is that
//         * 1 : The program will not terminate abruptly
//         * 2: The program will not show the error message to the user and allow us to fix the error
//         * */
//        try{
////            int sol = 111/d;
//            int sol = d/0;
//            System.out.println("This will not be printed");
//        }
//        //And we can use only one at a time either Exception or ArithmeticException but not both
//        //Check the below code snippet for more details.
////        catch(Exception e){ // This will work just fine as the ArithmeticException is a subclass of Exception
////            System.out.println("Exception caught");
////            System.out.println(e.getMessage());
////        }
//        catch(ArithmeticException a){ // This will work just fine as the ArithmeticException is a subclass of Exception            System.out.println("Exception caught");
//            System.out.println(a.getMessage());
//        }
//        finally { // Finally block will always be executed no matter what and the working is similar to the switch case DEFAULT block
//            System.out.println("Inside finally block");
//        }
//        // The below code snippet will not work as the ArithmeticException is a subclass of Exception
//        //It's just like writing the below code snippet in the above code snippet
//        //It's not a part of the try catch block
//        System.out.println("After catch statement");
//        System.out.println("Sum of 2 and 3  : " + (2+3));
//        }
public static void main(String[] args) {
    int a = 0;
    int b = 0;
    int c = 0;
    Random random = new Random(); // Random class is used to generate random numbers
    while(true){
        try{
            b = random.nextInt();
            c = random.nextInt();
//            int d  = b*c;                                                                                                                    
            a = 12345/(b/c) ;  //b/c can be zero and hence the exception will be thrown as the denominator can't be zero
            break;
        }catch(ArithmeticException e){
            System.out.println("Division by zero");
            System.out.println("b : " + b + " c : " + c);
            a = 0;
        }
        System.out.println("a : " + a);
    }
}

}
