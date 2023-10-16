package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
public class App {
    public static String getForwardedVariables(String fileContent) {
        String[] lines = fileContent.split("\n");
        List<String> list = Arrays.asList(lines);

        List<String> newList = list.stream()
                .filter(line -> line.startsWith("environment="))
                .flatMap(line -> Stream.of(line.replaceAll("environment=", "").split(",")))
                .map(line -> line.replaceAll("^\"|\"$", ""))
                .filter(line -> line.startsWith("X_FORWARDED_"))
                .flatMap(line -> Stream.of(line.replaceAll("X_FORWARDED_", "")))
                .map(line -> String.join(",", line))
                .collect(Collectors.toList());

        return String.join(",", newList);
    }
}

//END
