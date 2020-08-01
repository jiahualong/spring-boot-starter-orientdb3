package cc.stan.spring.boot.orientdb3.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 忽略字段可用来在创建Class时忽略属性
 *
 * @author magic.hualong(at)gmail.com
 * @since 0.1
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Ignore {
}
