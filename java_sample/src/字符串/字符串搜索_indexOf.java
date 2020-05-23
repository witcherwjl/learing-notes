package 字符串;
/*
String 自带 indexOf 寻找字符串开头位置
 */
public class 字符串搜索_indexOf {
    public static void main(String[] args) {
        String strOrig = "Google Nowcoder Taobao";
        int index = strOrig.indexOf("Goo");
        if(index != -1){
            System.out.println(index);
        }else{
            System.out.println("没找到");
        }
    }
}
