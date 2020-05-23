package 字符串;
/*
reverse是StringBuffer方法，返回StringBuffer
再通过toString转为字符串
 */
public class 字符串反转_BufferString_reverse {
    public static void main(String[] args) {
        String string="nowcoder";
        String reverse1 = new StringBuffer(string).reverse().toString();
        System.out.println(reverse1);

    }
}
