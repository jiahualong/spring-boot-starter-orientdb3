package cc.stan.spring.boot.orientdb3.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于标记为点的类
 * 被标记为点的类会被生成OrientDB中的Class
 *
 * @author magic.hualong(at)gmail.com
 * @since 0.1
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Vertex {
}
