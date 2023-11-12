package exercise;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> result = new ArrayList<>();
        Field[] fields = address.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)){
                field.setAccessible(true);
                try {
                    Object value = field.get(address);
                    if (value == null) {
                        result.add(field.getName());
                    }
                } catch (IllegalAccessException a) {
                    a.printStackTrace();
                }
            }
        }
        return result;
    }
}
// END
