package 字符串;
/*
字符串连接 - 使用 + 操作符 : 92 ms
字符串连接 - 使用 StringBuffer : 34 ms
字符串连接 - 使用 StringBuilder : 13 ms
*/
/*
 String result = "This is"
            + "testing the"
            + "difference"+ "between"
            + "String"+ "and"+ "StringBuffer"; 速度:0ms
 与
 String result = "This istesting thedifferencebetweenStringandStringBuffer";
 相同，所以严格来说 += 是比较慢的操作
 */

public class 字符串连接_加_StringBuffer_append {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        for(int i=0;i<50000;i++){
            String result = "";
            result += "This is";
            result += "testing the";
            result += "difference";
            result += "between";
            result += "String";
            result += "and";
            result += "StringBuffer";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("字符串连接"
                + " - 使用 + 操作符 : "
                + (endTime - startTime)+ " ms");
        long startTime1 = System.currentTimeMillis();
        for(int i=0;i<50000;i++){
            StringBuffer result = new StringBuffer();
            result.append("This is");
            result.append("testing the");
            result.append("difference");
            result.append("between");
            result.append("String");
            result.append("and");
            result.append("StringBuffer");
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("字符串连接"
                + " - 使用 StringBuffer : "
                + (endTime1 - startTime1)+ " ms");

        long startTime2 = System.currentTimeMillis();
        for(int i=0;i<50000;i++){
            StringBuilder result = new StringBuilder();
            result.append("This is");
            result.append("testing the");
            result.append("difference");
            result.append("between");
            result.append("String");
            result.append("and");
            result.append("StringBuffer");
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("字符串连接"
                + " - 使用 StringBuilder : "
                + (endTime2 - startTime2)+ " ms");
    }

}
