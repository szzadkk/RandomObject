package validation;

import com.fasterxml.classmate.Annotations;

/**
 * @author yanming
 * @date 2019-09-08 22:51
 */
public interface RandomContentMultiAnnotations extends RandomContent {
    Object getRandomContentMultiAnnotations(Annotations... annotations);
}
