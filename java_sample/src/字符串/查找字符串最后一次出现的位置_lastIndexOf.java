package 字符串;

public class 查找字符串最后一次出现的位置_lastIndexOf {
    public static void main(String[] args) {
        String strOig = "HHLKjkaldgfd";
        int lastIndex = strOig.lastIndexOf("fd");
        if(lastIndex == -1){
            System.out.println("不存在");
        }else{
            System.out.println("所在位置:"+lastIndex);
        }
    }
}
