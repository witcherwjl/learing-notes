package lambda;

import javax.imageio.stream.ImageInputStream;
import java.io.InputStream;

public class test1 {
    private static void log(int level, MessageBuilder builder){
        if (level==1){
            System.out.println(builder.buildMessage());
        }
    }

    public static void main(String[] args) {
        String msgA = "Hello";
        String msgB = "World";
        String msgC = "Java";
        log(1,()->msgA+msgB+msgC);
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        

    }
}
