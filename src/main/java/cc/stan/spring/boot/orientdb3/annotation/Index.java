package cc.stan.spring.boot.orientdb3.annotation;


import com.orientechnologies.orient.core.metadata.schema.OClass;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于标记属性为索引
 * 被标记的属性会被创建索引
 *
 * @author magic.hualong(at)gmail.com
 * @since 0.1
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Index {
    OClass.INDEX_TYPE value() default OClass.INDEX_TYPE.UNIQUE;
}
