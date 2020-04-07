import com.kelthuzadx.ystream.YStream;

public class YStreamTest {
    public static void main(String[] args) {
        YStream.just(3.1, 6.1, 9.1).map(f -> f + 1.).subscribe(System.out::println);
        YStream.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(val -> val % 2 == 0)
                .map(val -> (int) Math.pow(val, 2))
                .subscribe(System.out::println);
    }
}
