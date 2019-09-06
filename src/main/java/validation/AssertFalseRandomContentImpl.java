package validation;

import java.lang.annotation.Annotation;

/**
 * @author yanming
 * @date 2019-09-06 22:28
 */
public class AssertFalseRandomContentImpl implements RandomContent {
    @Override
    public Object getRandomContent(Annotation annotation) {
        return Boolean.FALSE;
    }
}
