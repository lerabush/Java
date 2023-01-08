import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Additional {
    public static void main(String[] args){


    }
    public static List<Object> test1(A<Object> a, int i){
        Object n = a.call1(i);
        return Stream.generate(()->n).limit(i).collect(Collectors.toList());
    }
    public static int test2(B<Object> b, Object o){
        return b.call2(o);
    }

    public static int test3(C<Object> c, String o){
        return c.call4(o);
    }
}
