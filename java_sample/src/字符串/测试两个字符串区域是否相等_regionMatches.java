package 字符串;
//first_str.regionMatches(bool ,11, second_str, 12, 9)
// (是否区分大小写，first_str开始位置,
// 比较的字符串second_str，second开始位置，比较长度)
public class 测试两个字符串区域是否相等_regionMatches {
    public static void main(String[] args) {
        String first_str = "Welcome to Microsoft";
        String second_str = "I work with microsoft";
        boolean match1 = first_str.
                regionMatches(11, second_str, 12, 9);

    }
}
