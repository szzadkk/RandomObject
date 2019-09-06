package validation;

import java.lang.annotation.Annotation;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.hibernate.validator.constraints.Length;

/**
 * @author yanming
 * @date 2019-09-06 23:07
 */
public class LengthRandomContentImpl implements RandomContent {
    @Override
    public Object getRandomContent(Annotation annotation) {
        Length length = (Length)annotation;
        int len = RandomUtils.nextInt(length.min(), length.max());
        return RandomStringUtils.random(len);
    }
}
