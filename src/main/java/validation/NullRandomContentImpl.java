package validation;

import java.lang.annotation.Annotation;

/**
 * @author yanming
 * @date 2019-09-06 22:59
 */
public class NullRandomContentImpl implements RandomContent {
    @Override
    public Object getRandomContent(Annotation annotation) {
        return null;
    }
}
