import com.kelthuzadx.ystream.YStream;

public class YStreamTest {
    public static void main(String[] args) {
        YStream.just(3.1, 6.1, 9.1).map(f -> f + 1.).subscribe(System.out::println);
    }
}
