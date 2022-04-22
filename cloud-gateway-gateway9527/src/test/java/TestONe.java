import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class TestONe {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("now = " + now);

        LocalDateTime now1 = LocalDateTime.now();
        System.out.println("now1 = " + now1);
    }
}
