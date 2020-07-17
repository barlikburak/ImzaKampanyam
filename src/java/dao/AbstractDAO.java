package dao;

import java.sql.Connection;
import util.Connector;

/**
 *
 * @author burak
 */
public class AbstractDAO {

    private Connector connector;
    private Connection connection;

    public Connector getConnector() {
        if (this.connector == null) {
            this.connector = new Connector();
        }
        return this.connector;
    }

    public Connection getConnection() {
        if (this.connection == null) {
            this.connection = getConnector().connect();
        }
        return connection;
    }
}
