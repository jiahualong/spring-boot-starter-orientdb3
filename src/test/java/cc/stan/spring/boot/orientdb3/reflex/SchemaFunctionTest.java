package cc.stan.spring.boot.orientdb3.reflex;

import cc.stan.spring.boot.orientdb3.model.Person;
import cc.stan.spring.boot.orientdb3.object.OrientDBSchema;
import org.junit.Test;

import static org.junit.Assert.*;

public class SchemaFunctionTest {

    @Test
    public void genSchemaFromClazzTest() {
        OrientDBSchema schema = SchemaFunction.genSchemaFromClazz(Person.class);
        assertNotNull(schema);
        assertEquals("Person", schema.getName());
        assertSame(3, schema.getColTypeMap().size());
        assertSame(1, schema.getIndexMap().size());
    }

    @Test
    public void genSchemaFromObjectTest() {
        OrientDBSchema schema = SchemaFunction.genSchemaFromObject(new Person());
        assertNotNull(schema);
        assertEquals("Person", schema.getName());
        assertSame(3, schema.getColTypeMap().size());
        assertSame(1, schema.getIndexMap().size());
    }
}
