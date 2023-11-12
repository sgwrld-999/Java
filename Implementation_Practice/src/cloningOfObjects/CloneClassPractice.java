package cloningOfObjects;

public class CloneClassPractice implements Cloneable{
//    String name;
//    int age ;
//    int id;
//    int[] arr = new int[5];
//    CloneClassPractice(){} // Default
//    public CloneClassPractice(String name, int age, int id, int[] arr){
//        this.name = name;
//        this.age = age;
//        this.id = id;
//        this.arr = arr;
//    }
    //This is a copy constructor
    //It'll take the object as a parameter and copy vales from the objects
    //This is a deep copy
//    public CloneClassPractice(CloneClassPractice cloneClassPractice){
//        this.name = cloneClassPractice.name;
//        this.age = cloneClassPractice.age;
//        this.id = cloneClassPractice.id;
//        this.arr = cloneClassPractice.arr;
//    }
//    //Create a clone method for shallow copy of the object
//    public Object clone() throws CloneNotSupportedException{
//        return super.clone();
//    }
    int id;
    String name;
    int age;
    int[] arr = new int[5];
    CloneClassPractice(){}
    public CloneClassPractice(String name, int age, int id, int[] arr){
        this.name = name;
        this.age = age;
        this.id = id;
        this.arr = arr;
    }
//    public CloneClassPractice(CloneClassPractice cloneClassPractice){
//        return super.clone(); ;
//    }
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
