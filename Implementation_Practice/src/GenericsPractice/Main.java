package GenericsPractice;

import java.util.Scanner;

public class Main {
//    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //Syntax of the creating an object of a Generic class
        // Syntax :-> ClassName<ClassType> objectName = new  ClassName<ClassType> ();
//        GenericsPrintingClass<Integer> obj = new GenericsPrintingClass<Integer>(88) ;
//        GenericsPrintingClass<Float> obj2 = new GenericsPrintingClass<Float>(8.0908f) ;
//        GenericsPrintingClass<String> obj3 = new GenericsPrintingClass<String>();
//        // After creating the object we simply use the obj properties and functionality like normal object
//        obj2.showType();
//        int temp;
//        System.out.println("Enter the value to store the obj for the Integer class : ");
//        temp = scanner.nextInt();
//        obj.setObj(temp);
//        System.out.println("Printing the obj of Generic Integer class : " + obj.getObj());
//        System.out.println("Enter the value to store the obj for the String class : ");
//        String temp = scanner.nextLine();
//        obj3.setObj(temp);
//        System.out.println("Printing the obj of Generic Integer class : " + obj3.getObj());
//        System.out.println("The class of the object is : " );
//        obj3.showType();
        NonGenericClass obj1 = new NonGenericClass(67);
        NonGenericClass obj2 = new NonGenericClass("Siddhant Gond");
        NonGenericClass obj3 = new NonGenericClass(56756.56f);
        //For printing the value this works fine
//        System.out.println( " Printing the Integer Object :  "  + obj1.getObj());
//        System.out.println( " Printing the String Object :  " + obj2.getObj());
//        System.out.println( " Printing the Float Object :  " + obj3.getObj());
        //But what if we have to change the reference of the obj or we have to give some
        //Other variable reference to  the object
//        int intObjRef = obj1.getObj(); // It'll be showing an error
        int intObjRef = (int) obj1.getObj(); // It'll work fine and here the problem arises that for every
        //change of reference we have to  do the type casting manually
        System.out.println("The value of the intObjRef : " + intObjRef);
        //So to overcome this problem we use the Generics
        //Generics are the classes which can take any type of class as a parameter
    }

}
