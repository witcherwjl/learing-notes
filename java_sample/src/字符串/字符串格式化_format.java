package 字符串;

import java.util.Locale;

public class 字符串格式化_format {
    public static void main(String[] args) {
        double e = Math.E;
        System.out.format("%f%n", e);
        System.out.format(Locale.CHINA  , "%-10.4f%n", e);  //指定本地为中国（CHINA）
    }
}
