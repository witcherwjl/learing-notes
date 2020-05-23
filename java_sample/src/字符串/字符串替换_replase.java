package 字符串;
/*
 java String 类的 replace 方法来替换字符串中的字符
 均不改变原有String
 replace(a,b) 替换所有cahr a为 char b
 replaceFirst(a,b) 替换第一个字符串a为字符串b
 replaceAll(a,b) 替换所有字符串a为字符串b
 */
public class 字符串替换_replase {
    public static void main(String[] args) {
        String s= "gasgadf";
        s.replace("g","t");
        s.replaceAll("ga","ff");
        s.replaceFirst("ga","tt");
        System.out.println(s.replace("g","t"));
        System.out.println(s.replaceAll("ga","ff"));
        System.out.println(s.replaceFirst("ga","tt"));
    }
}
