package ExceptionHandlingPract;
//class ThrowDemo {
//    static void demoproc(){
//        try {
//            throw new NullPointerException("demo");
//        }catch (NullPointerException e){
//            System.out.println("Caught inside demoproc");
//            throw e;
//        }
//    }
//}
class ThrowsDemo{
    void throwMethodName(int a) throws  IllegalAccessException{
        System.out.println("Inside throwMethodName");
        if(a == 0){
            throw new ArithmeticException("Divide by 0");
        }
        System.out.println("After if statement");
    }
}
public class ExceptionClassNew extends Exception{
//    public static void main(String[] args) {
// The  multiple clause catch will only catch the first exception that is thrown
//        try {
//            int a = args.length;
//            System.out.println("a  : " + a);
//            int b = 13 / a;
//            System.out.println("b" + b);
//            int[] c = {1};
//            c[99] = 99;
            /*
            It'll throw an error as we have first used the Exception class
            and then the ArrayIndexOutOfBoundsException class
            which is a subclass of the Exception class
            Subclass should be used first and then the superclass
            And MUST Remember that the multiple clause catch will only catch the first exception that is thrown
            If it's a exception other  just like switch statement it'll go to the default(Finally) block
            */
//        }catch (Exception e){
//            System.out.println("Divide by 0" + e);
//        }catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("Array index oob" + e);
//        }
//        System.out.println("After try/catch blocks");
//    }
//    class NestTry{
    public static void main(String[] args) {
//        try {
//            int  a =2;
//            int b = 42 / a;
//            System.out.println("a = " + a);
//            try {
//                if(a == 1) a = a/(a-a);
//                if(a == 2){
//                    int[] c = {1};
//                    c[42] = 99;
//                }
//                }catch(ArrayIndexOutOfBoundsException e){
//                    System.out.println("Array index OOB" + e );
//            }
//        }catch (ArithmeticException e){
//            System.out.println("Divide by 0" + e);
//        }
//        System.out.println("After try/catch blocks");
//        try{
//            ThrowDemo.demoproc();
//        }catch (NullPointerException e){
//            System.out.println("Recaught" + e);
//        }
//        System.out.println("After catch statement");
//    }
//}
        try{
            ThrowsDemo ob = new ThrowsDemo();
            ob.throwMethodName(0);
        }catch (IllegalAccessException e){
            System.out.println("Caught" + e);
        }
        System.out.println("After try/catch statement");
    }
}
