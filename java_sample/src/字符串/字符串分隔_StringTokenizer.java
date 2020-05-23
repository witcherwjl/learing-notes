package 字符串;

import java.util.StringTokenizer;

public class 字符串分隔_StringTokenizer {
    public static void main(String[] args) {
        String str = "This is String , split by StringTokenizer, created by nowcoder";
        StringTokenizer st = new StringTokenizer(str);

        System.out.println("----- 通过空格分隔 ------");
        while (st.hasMoreElements()) {
            System.out.println(st.nextElement());
        }
        System.out.println("----- 通过逗号分隔 ------");

        StringTokenizer st1 = new StringTokenizer(str, ",");
        while (st1.hasMoreElements()) {
            System.out.println(st1.nextElement());
        }
    }
}
