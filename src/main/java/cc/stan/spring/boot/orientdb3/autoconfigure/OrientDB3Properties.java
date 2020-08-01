package cc.stan.spring.boot.orientdb3.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * OrientDB3配置文件
 *
 * @author magic.hualong(at)gmail.com
 * @since 0.1
 */
@Data
@ConfigurationProperties(prefix = "orientdb3")
public class OrientDB3Properties {
    /** OrientDB的URL(默认值为 127.0.0.1:2424) */
    private String url = "remote:localhost:2424";
    /** 数据库名(默认值为test) */
    private String dbName = "test";
    /** 用户名(默认值为root) */
    private String username = "root";
    /** 密码(默认值为root) */
    private String password = "root";
    /** 池的最小数(默认值为5) */
    private Integer poolMin = 5;
    /** 池的最大数(默认值为10) */
    private Integer poolMax = 10;
}
