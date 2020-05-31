package 流操作和方法引用;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class demo4GetStream {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("张无忌", "张三丰", "周芷若");
        stream.forEach(name->System.out.println(name));
//        System.out.println(stream);
        Stream<String> or = Stream.of("张无忌", "张三丰", "周芷若");
        Stream<String> result = or.filter(s -> s.startsWith("张"));
//        result.forEach(name->System.out.println(name));

        Stream<String> or1 = Stream.of("10","11","12");
        Stream<Integer> result1 = or1.map(str->Integer.parseInt(str));
        result1.forEach(name->System.out.println(name));
        // limit
        // count
        // concat
        // skip


    }
}
