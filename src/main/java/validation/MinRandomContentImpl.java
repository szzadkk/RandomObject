package validation;

import java.lang.annotation.Annotation;

import javax.validation.constraints.Min;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author yanming
 * @date 2019-09-06 22:57
 */
public class MinRandomContentImpl implements RandomContent {
    @Override
    public Object getRandomContent(Annotation annotation) {
        Min min = (Min)annotation;
        return RandomUtils.nextLong(min.value(), Long.MAX_VALUE);
    }
}
