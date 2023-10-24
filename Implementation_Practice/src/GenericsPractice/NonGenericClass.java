package GenericsPractice;

public class NonGenericClass {
    Object obj;
NonGenericClass(){}
    public NonGenericClass(Object obg){
    this.obj = obg;
    }
    public Object getObj() {
        return obj;
    }
    public void setObj(Object obj) {
        this.obj = obj;
    }
    void showTpye(){
        System.out.println("The type of the object is : "  + obj.getClass().getName() );
    }
}
