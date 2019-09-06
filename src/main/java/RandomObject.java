import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.hibernate.validator.constraints.Length;

/**
 * @author yanming
 */
public class RandomObject {
    public static <T> T random(Class<T> cl)
        throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Field[] fields = cl.getDeclaredFields();
        Map<String, Object> randomContent = new ConcurrentHashMap<>(fields.length);
        for (Field field : fields) {
            if (field.getClass().isAssignableFrom(Collection.class)) {
                randomContent.put(field.getName(), field.getClass().newInstance());
            } else {
                Annotation[] annotations = field.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    Class<? extends Annotation> annotationType = annotation.annotationType();
                    if (annotationType == Length.class) {
                        Length length = (Length)annotation;
                        int len = RandomUtils.nextInt(length.min(), length.max());
                        randomContent.put(field.getName(), RandomStringUtils.random(len));
                        break;
                    }
                }

            }
        }
        T entity = cl.newInstance();
        Method[] methods = cl.getMethods();
        for (Method method : methods) {
            if ("set".equals(method.getName().substring(0, 3))) {
                String fieldName = method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4);
                method.invoke(
                    randomContent.containsKey(fieldName) ? randomContent.get(fieldName) : RandomStringUtils.random(10));
            }
        }
        return entity;
    }
}
