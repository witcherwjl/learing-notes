package lambda;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class 常用函数式接口 {
    private static void consumerString(Consumer<String> one, Consumer<String> two){
        one.andThen(two).accept("Hello");
    }
    private static void method(Predicate<String> predicate){
        boolean veryLong = predicate.test("helloworld");
        System.out.println("字符串很长吗+"+veryLong);
    }
    private static void meApply(Function<String,Integer> function){
        int num = function.apply("10");
        System.out.println(num+10);
    }

    public static void main(String[] args) {
        consumerString(
                s -> System.out.println(s.toUpperCase()),
                s ->System.out.println(s.toLowerCase())
        );
        method(s->s.length()>5);

        meApply(s->Integer.parseInt(s));
    }
}
