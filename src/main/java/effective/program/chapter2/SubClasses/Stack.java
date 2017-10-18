package effective.program.chapter2.SubClasses;

/**
 * このスタッククラスを使う側からすると、
 * Created by keiwada on 2017/10/01.
 */
public class Stack {

    private static Object[] elements;
    private static int size;
    static {
        elements = new Object[10];
    }

    public static void push(Object e){
        elements[size++] = e;
    }

    public static void pop(){
        if(size!=0)
            size--;
    }

    public static int getSize(){
           return size;
    }
}
