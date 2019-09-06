package validation;

import java.lang.annotation.Annotation;

/**
 * @author yanming
 * @date 2019-09-06 22:26
 */
public interface RandomContent {
    /**
     * 根据注解类生成随机随机对象
     * 
     * @param annotation
     *            注解
     * @return 随机生成的对象
     */
    Object getRandomContent(Annotation annotation);
}
