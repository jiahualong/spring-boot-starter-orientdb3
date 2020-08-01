package cc.stan.spring.boot.orientdb3.autoconfigure;

import cc.stan.spring.boot.orientdb3.object.OrientDBFactory;
import cc.stan.spring.boot.orientdb3.object.OrientGraphDBTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OrientDB3 SpringBoot自动配置
 *
 * @author magic.hualong(at)gmail.com
 * @since 0.1
 */
@Configuration
@ConditionalOnClass(OrientGraphDBTemplate.class)
@EnableConfigurationProperties(OrientDB3Properties.class)
public class OrientDB3AutoConfiguration {

    @Bean
    @ConditionalOnClass(OrientDBFactory.class)
    public OrientDBFactory orientGraphDBFactory(OrientDB3Properties properties) {
        OrientDBFactory factory = new OrientDBFactory();
        factory.setUrl(properties.getUrl());
        factory.setDbName(properties.getDbName());
        factory.setUsername(properties.getUsername());
        factory.setPassword(properties.getPassword());
        factory.setPoolMin(properties.getPoolMin());
        factory.setPoolMax(properties.getPoolMax());
        factory.initPool();
        return factory;
    }

    @Bean
    @ConditionalOnClass(OrientGraphDBTemplate.class)
    public OrientGraphDBTemplate orientGraphDBTemplate(OrientDBFactory factory) {
        return new OrientGraphDBTemplate(factory);
    }

}
