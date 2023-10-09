package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {
    public static long getCountOfFreeEmails(List<String> emailsList) {
        return emailsList.stream()
                .filter(email -> StringUtils.isNotBlank(email))
                .filter(email -> email.contains("@gmail.com") || email.contains("@yandex.ru")
                        || email.contains("hotmail.com"))
                .count();
    }
}
// END
