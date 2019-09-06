package validation;

import java.lang.annotation.Annotation;

import javax.validation.constraints.Pattern;

import nl.flotsam.xeger.Xeger;

/**
 * @author yanming
 * @date 2019-09-06 23:00
 */
public class PatternRandomContentImpl implements RandomContent {
    @Override
    public Object getRandomContent(Annotation annotation) {
        Pattern pattern = (Pattern)annotation;
        Xeger generator = new Xeger(pattern.regexp());
        return generator.generate();
    }
}
