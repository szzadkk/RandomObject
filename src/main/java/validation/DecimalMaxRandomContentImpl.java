package validation;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author yanming
 * @date 2019-09-06 22:38
 */
public class DecimalMaxRandomContentImpl implements RandomContent {
    @Override
    public Object getRandomContent(Annotation annotation) {
        DecimalMax decimalMax = (DecimalMax)annotation;
        return BigDecimal.valueOf(RandomUtils.nextDouble(-Double.MAX_VALUE, decimalMax.inclusive()
            ? Double.valueOf(decimalMax.value()) : (Double.valueOf(decimalMax.value()) - Double.MIN_VALUE)));
    }
}
