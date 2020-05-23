package 字符串;
//String.split

public class 字符串分割_split {
    public static void main(String[] args) {
        String str = "www-nowcoder-com";
        String[] temp;
        temp = str.split("-");
        for(String s: temp){
            System.out.println(s);
        }
    }
}
