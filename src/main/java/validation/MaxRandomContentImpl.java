package validation;

import java.lang.annotation.Annotation;

import javax.validation.constraints.Max;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author yanming
 * @date 2019-09-06 22:54
 */
public class MaxRandomContentImpl implements RandomContent {
    @Override
    public Object getRandomContent(Annotation annotation) {
        Max max = (Max)annotation;
        return RandomUtils.nextLong(Long.MIN_VALUE, max.value());
    }
}
