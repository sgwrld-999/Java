package ExceptionHandlingPract;

public class ClassNewException extends Exception{ // Extending the exception class
    private int detail ;
    ClassNewException(int a){
        detail = a ;
    }
  @Override  // Overriding the toString() method of the Exception class
    public String toString(){
        return "ClassNewException[" + detail + "]" ;
    }
}
class ExceptionDemo{
    static void compute(int a) throws ClassNewException {
        System.out.println("Called compute(" + a + ")");
        if(a > 10)
            throw new ClassNewException(a) ;
        System.out.println("Normal Exit");
    }

    public static void main(String[] args) {
        try{
            compute(1);
            compute(20);
        }catch (ClassNewException e){
            System.out.println("Caught " + e);
        }
    }
}