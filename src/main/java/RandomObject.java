import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yanming
 */
public class RandomObject {
    public static <T> T random(Class<T> cl) throws InvocationTargetException, IllegalAccessException,
        InstantiationException, ClassNotFoundException, NoSuchMethodException {
        Field[] fields = cl.getDeclaredFields();
        Map<String, Object> randomContentMap = new ConcurrentHashMap<>(fields.length);
        for (Field field : fields) {
            if (field.getClass().isAssignableFrom(Collection.class)) {
                randomContentMap.put(field.getName(), field.getClass().newInstance());
            } else {
                Annotation[] annotations = field.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    String annotationName = annotation.annotationType().getName();
                    String[] splitNames = annotationName.split("\\.");
                    Class RandomContentClass =
                        Class.forName("validation." + splitNames[splitNames.length - 1] + "RandomContentImpl");
                    Method method = RandomContentClass.getMethod("getRandomContent", Annotation.class);

                    randomContentMap.put(field.getName(), method.invoke(RandomContentClass.newInstance(), annotation));
                }
            }
        }
        T entity = cl.newInstance();
        Method[] methods = cl.getMethods();
        for (Method method : methods) {
            if ("set".equals(method.getName().substring(0, 3))) {
                String fieldName = method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4);
                method.invoke(entity, randomContentMap.get(fieldName));
            }
        }
        return entity;
    }
}
