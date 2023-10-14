package exercise;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        List<String> men = users.stream()
                .filter(user -> "male".equals(user.get("gender")))
                .sorted((user1, user2) -> {
                    try {
                        Date date1 = dateFormat.parse(user1.get("birthday"));
                        Date date2 = dateFormat.parse(user2.get("birthday"));
                        return date1.compareTo(date2);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(user -> user.get("name"))
                .collect(Collectors.toList());

        return men;
    }
}
// END
