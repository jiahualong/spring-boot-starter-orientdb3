package cc.stan.spring.boot.orientdb3.reflex;

import cc.stan.spring.boot.orientdb3.annotation.Ignore;
import cc.stan.spring.boot.orientdb3.annotation.Index;
import cc.stan.spring.boot.orientdb3.annotation.Vertex;
import cc.stan.spring.boot.orientdb3.object.OrientDBSchema;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OType;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

import static cc.stan.spring.boot.orientdb3.reflex.AnnotationUtils.hasAnnotation;
import static com.google.common.base.CaseFormat.LOWER_CAMEL;
import static com.google.common.base.CaseFormat.LOWER_UNDERSCORE;
import static java.util.Objects.requireNonNull;

/**
 * Class -> OrientDB Clazz
 * <p>
 * 从Class生成OrientDB表和字段
 *
 * @author magic.hualong(at)gmail.com
 * @since 1.0
 */
public class SchemaFunction {

    private SchemaFunction() {
    }

    /**
     * Class -> OrientDBSchema
     *
     * @param clazz Clazz原型
     * @return 生成的OrientDB Class
     */
    public static OrientDBSchema genSchemaFromClazz(Class<? extends Object> clazz) {
        if (!clazz.isAnnotationPresent(Vertex.class)) {
            return OrientDBSchema.empty();
        }
        String name = clazz.getSimpleName();
        Map<String, OType> propertiesMap;
        Map<String, OClass.INDEX_TYPE> indexMap;

        Field[] fields = clazz.getDeclaredFields();
        if (fields.length <= 0) {
            return OrientDBSchema.onlyName(name);
        }

        propertiesMap = new LinkedHashMap<>(fields.length);
        indexMap = new LinkedHashMap<>();
        for (int i = 0; i < fields.length; i++) {
            //fields
            Field field = fields[i];
            String fieldName = LOWER_CAMEL.to(LOWER_UNDERSCORE, field.getName());
            if (!hasAnnotation(field, Ignore.class)) {
                propertiesMap.put(fieldName, OType.getTypeByClass(field.getType()));
            }
            //index
            Annotation[] fieldsAnnotations = field.getAnnotations();
            for (Annotation fa : fieldsAnnotations) {
                if (fa instanceof Index) {
                    indexMap.put(fieldName, ((Index) fa).value());
                }
            }
        }
        return OrientDBSchema.builder().name(name).colTypeMap(propertiesMap).indexMap(indexMap).build();
    }

    /**
     * Object -> OrientDBSchema
     *
     * @param obj Object原型
     * @return 生成的OrientDB Clazz
     */
    public static OrientDBSchema genSchemaFromObject(Object obj) {
        Class<?> objClazz = requireNonNull(obj).getClass();
        return genSchemaFromClazz(objClazz);
    }
}
