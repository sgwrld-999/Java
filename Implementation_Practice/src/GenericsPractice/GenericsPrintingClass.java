package GenericsPractice;
/*
* Syntax of the creating a generics classes :  class className<T>{}
* T is just a parameterized variable it can anything A,B,C...
*  To use the passed class for future reference we'll use the T or the reference variable
* */
/*
* The important thing here to notice is that  the even when we're creating our own class
* the object class is imported automatically.
* That also prove again that the Object class is at the top of the hierarchy of the Inheritance
*  */
class GenericsPrintingClass<U> {
    //Here U is the generic or general class which can implement the
    //passed class object
    U obj ; // Syntax for creating obj of the U class
    GenericsPrintingClass(){}// Default constructor
    public U getObj() {
        return obj;
    }

    public void setObj(U obj) {
        this.obj = obj;
    }

    GenericsPrintingClass(U ob){
        obj = ob ;
    }
    void showType(){
        System.out.println("Type of U is : " + obj.getClass().getName());
    }
}