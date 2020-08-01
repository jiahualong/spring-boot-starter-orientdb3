package cc.stan.spring.boot.orientdb3.object;

/**
 * OrientDB的基本操作
 *
 * @author magic.hualong(at)gmail.com
 * @since 0.1
 */
public class OrientGraphDBTemplate {

    private OrientDBFactory factory;

    public OrientGraphDBTemplate(OrientDBFactory factory) {
        this.factory = factory;
    }

}
