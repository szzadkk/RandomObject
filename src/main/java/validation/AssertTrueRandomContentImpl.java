package validation;

import java.lang.annotation.Annotation;

/**
 * @author yanming
 * @date 2019-09-06 22:38
 */
public class AssertTrueRandomContentImpl implements RandomContent {
    @Override
    public Object getRandomContent(Annotation annotation) {
        return Boolean.TRUE;
    }
}
