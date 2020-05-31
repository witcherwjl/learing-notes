package lambda;

import java.util.function.Function;

public class DemoFunction {
    public static void main(String[] args) {
        String str = "赵丽颖,20";
        int age = getAgeNum(str,
                s -> s.split(",")[1],
                s -> Integer.parseInt(s),
                n -> n+=100);
        System.out.println(age);
    }
    private static int getAgeNum(String str, Function<String ,String > one,
                                 Function<String ,Integer> two,
                                 Function<Integer, Integer> three){
        return one.andThen(two).andThen(three).apply(str);
    }
}
