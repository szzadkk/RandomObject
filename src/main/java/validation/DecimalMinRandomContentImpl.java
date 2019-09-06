package validation;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author yanming
 * @date 2019-09-06 22:48
 */
public class DecimalMinRandomContentImpl implements RandomContent {
    @Override
    public Object getRandomContent(Annotation annotation) {
        DecimalMin decimalMin = (DecimalMin)annotation;
        return BigDecimal.valueOf(RandomUtils.nextDouble(decimalMin.inclusive() ? Double.valueOf(decimalMin.value())
            : (Double.valueOf(decimalMin.value()) + Double.MIN_VALUE), Double.MAX_VALUE));
    }
}
