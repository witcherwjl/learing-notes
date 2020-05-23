package 字符串;
/* 字符串函数 substring() 函数来删除字符串中的一个字符
 s.substring(indexbegin,indexend) 取 indexbegin~indexend 的字符串
 s.substring(index) 去掉index之前的字符
*/
public class 删除字符串中的一个字符_substring {
    public static void main(String[] args) {
        String s = "tdsgad gsg";
        System.out.println(s);

        s = s.substring(0,3)+s.substring(4);
        System.out.println(s);
    }
}
