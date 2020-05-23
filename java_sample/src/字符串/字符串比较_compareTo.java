package 字符串;

import java.io.ObjectStreamClass;
/*
以下实例中我们通过字符串函数
compareTo (string) ，compareToIgnoreCase(String) 及 compareTo(object string)
来比较两个字符串，并返回字符串中第一个字母ASCII的差值。
 */
public class 字符串比较_compareTo {
    public static void main(String[] args) {
        String str = "Hello World";
        String anotstr = "hello world";
        Object objstrr = str;


        System.out.println("输出:"+str.compareTo(anotstr));
        System.out.println("输出："+str.compareToIgnoreCase(anotstr));
        System.out.println(str.compareTo(objstrr.toString()));
    }
}
