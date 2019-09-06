package validation;

import java.lang.annotation.Annotation;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author yanming
 * @date 2019-09-06 22:58
 */
public class NotNullRandomContentImpl implements RandomContent {
    @Override
    public Object getRandomContent(Annotation annotation) {
        return RandomStringUtils.random(1);
    }
}
