package ObjectSorting;

import java.util.StringTokenizer;
class Base {
    int i ;
    void print() {
        System.out.println(i);
    }
}
class Derived extends Base {
    int j;
    void print1() {
        System.out.println(j);
    }
}
public class StringTokenizerExample {
    public static void main(String[] args) {
       Derived d = new Derived();
       d.i = 1;
       d.j = 2;
       Base b = d;
       b.print();
    }
}
