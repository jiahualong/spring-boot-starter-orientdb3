package cc.stan.spring.boot.orientdb3.reflex;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import static java.util.Objects.requireNonNull;

/**
 * 注解实用工具
 *
 * @author magic.hualong(at)gmail.com
 * @since 1.0
 */
public class AnnotationUtils {

    private AnnotationUtils() {
    }

    /**
     * 字段中是否有指定注解
     *
     * @param field           要检查的字段
     * @param annotationClass 要寻找的注解
     * @return true包含要寻找的注解
     */
    public static boolean hasAnnotation(Field field, Class<? extends Annotation> annotationClass) {
        Annotation[] annotations = field.getAnnotations();
        for (int i = 0; i < requireNonNull(annotations).length; i++) {
            if (annotations[i].annotationType().equals(annotationClass)) {
                return true;
            }
        }
        return false;
    }
}
