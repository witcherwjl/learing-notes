package 字符串;
import java.io.BufferedInputStream;

/*
当通过语句str.intern()调用intern()方法后，
JVM 就会在当前类的常量池中查找是否存在与str等值的String，
若存在则直接返回常量池中相应Strnig的引用；
若不存在，则会在常量池中创建一个等值的String，然后返回这个String在常量池中的引用。
 */

/*
每次都需要与常量池中的数据进行比较以查看常量池中是否存在等值数据
1. 如果进行intern操作的是大量不会被重复利用的String的话，不适合使用；
2. 适用于只有有限值，并且这些有限值会被重复利用的场景，如数据库表中的列名、人的姓氏、编码类型等。
 */
public class 字符串内存优化_intern_常量池 {
    public static void main(String[] args){
        String variables[] = new String[50000];
        for( int i=0;i <50000;i++){
            variables[i] = "s"+i;
        }
        long startTime0 = System.currentTimeMillis();
        for(int i=0;i<50000;i++){
            variables[i] = "hello";
        }
        long endTime0 = System.currentTimeMillis();
        System.out.println("直接使用字符串： "+ (endTime0 - startTime0)  + " ms" );
        long startTime1 = System.currentTimeMillis();
        for(int i=0;i<50000;i++){
            variables[i] = new String("hello");
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("使用 new 关键字：" + (endTime1 - startTime1) + " ms");
        long startTime2 = System.currentTimeMillis();
        for(int i=0;i<50000;i++){
            variables[i] = new String("hello");
            variables[i] = variables[i].intern();
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("使用字符串对象的 intern() 方法: "
                + (endTime2 - startTime2)
                + " ms");
    }
}
