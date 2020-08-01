package cc.stan.spring.boot.orientdb3.object;

import com.orientechnologies.orient.core.config.OGlobalConfiguration;
import com.orientechnologies.orient.core.db.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * OrientDB用于标记属性为索引
 * 被标记的属性会被创建索引
 *
 * @author magic.hualong(at)gmail.com
 * @since 0.1
 */
@NoArgsConstructor
public class OrientDBFactory {

    private OrientDB orientDB;
    private ODatabasePool pool;

    @Setter
    private String url;
    @Setter
    private String dbName;
    @Setter
    private String username;
    @Setter
    private String password;
    @Setter
    private Integer poolMin;
    @Setter
    private Integer poolMax;

    /**
     * 通过配置初始化链接池
     */
    public void initPool() {
        orientDB = new OrientDB(url, username, password, OrientDBConfig.defaultConfig());
        orientDB.createIfNotExists(dbName, ODatabaseType.PLOCAL, OrientDBConfig.defaultConfig());
        OrientDBConfigBuilder poolCfg = OrientDBConfig.builder();
        poolCfg.addConfig(OGlobalConfiguration.DB_POOL_MIN, poolMin);
        poolCfg.addConfig(OGlobalConfiguration.DB_POOL_MAX, poolMax);
        pool = new ODatabasePool(orientDB, dbName, username, password, poolCfg.build());
    }

    /**
     * 销毁链接池
     */
    public void destroy() {
        pool.close();
        orientDB.close();
    }

    /**
     * 通过池获取Session
     *
     * @return 可用的Session
     */
    public ODatabaseSession getDBSession() {
        return pool.acquire();
    }
}
