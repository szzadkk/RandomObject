package validation;

import java.lang.annotation.Annotation;

import javax.validation.constraints.Pattern;

import com.mifmif.common.regex.Generex;

/**
 * @author yanming
 * @date 2019-09-06 23:00
 */
public class PatternRandomContentImpl implements RandomContent {
    @Override
    public Object getRandomContent(Annotation annotation) {
        Pattern pattern = (Pattern)annotation;
        Generex generator = new Generex(pattern.regexp());
        return generator.random();
    }
}
