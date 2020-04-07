import com.kelthuzadx.ystream.YStream;

public class LimitTest {
    public static void main(String[] args) {
        YStream.range(5, 20).limit(5).subscribe(System.out::println);
        YStream.range(5, 20).limit(0).subscribe(System.out::println);
        YStream.range(0, 0).limit(5).subscribe(System.out::println);
        YStream.range(-1, -5).limit(3).subscribe(System.out::println);
        YStream.range(-1, -5).limit(-3).subscribe(System.out::println);
        YStream.range(-1, 10).limit(5).subscribe(System.out::println);
        YStream.range(-1, -5).limit(-3).subscribe(System.out::println);
        YStream.range(-12, -1).limit(3).subscribe(System.out::println);
        YStream.range(-12, -1).limit(0).subscribe(System.out::println);
    }
}
