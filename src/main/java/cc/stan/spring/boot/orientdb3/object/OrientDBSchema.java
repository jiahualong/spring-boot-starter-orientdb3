package cc.stan.spring.boot.orientdb3.object;

import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Map;

/**
 * OrientDB 表结构
 *
 * @author magic.hualong(at)gmail.com
 * @since 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrientDBSchema {
    /** Clazz名 */
    private String name;
    /** Clazz字段名及类型 */
    private Map<String, OType> colTypeMap;
    /** 索引列表 */
    private Map<String, OClass.INDEX_TYPE> indexMap;

    /**
     * 空白的Schema
     *
     * @return 空白的Schema
     */
    public static OrientDBSchema empty() {
        return OrientDBSchema.builder().build();
    }

    /**
     * 仅有名字没有字段的Schema
     *
     * @param name Schema的名字
     * @return 生成的Schema
     */
    public static OrientDBSchema onlyName(String name) {
        return OrientDBSchema.builder()
                .name(name)
                .colTypeMap(Collections.emptyMap())
                .indexMap(Collections.emptyMap())
                .build();
    }
}