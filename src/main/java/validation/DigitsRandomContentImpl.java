package validation;

import java.lang.annotation.Annotation;

import javax.validation.constraints.Digits;

import com.mifmif.common.regex.Generex;

/**
 * @author yanming
 * @date 2019-09-06 22:52
 */
public class DigitsRandomContentImpl implements RandomContent {
    @Override
    public Object getRandomContent(Annotation annotation) {
        Digits digits = (Digits)annotation;
        String regex = String.format("\\d{1,%d}\\.\\d{1,%d}", digits.integer(), digits.fraction());
        Generex generex = new Generex(regex);
        return generex.random();
    }
}
