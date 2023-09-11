
package ar.charlycimino.recetorium.model.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Charly Cimino
 * Aprendé más Java en mi canal: https://www.youtube.com/c/CharlyCimino
 * Encontrá más código en mi repo de GitHub: https://github.com/CharlyCimino
 */
public class ConnectionPool {
    
    /*
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-dbcp2</artifactId>
            <version>2.9.0</version>
        </dependency>
    */
    
    private static BasicDataSource dataSource;
    private static ConnectionPool pool;

    private ConnectionPool() {
        try {
            Properties prop = new Properties();
            InputStream in = getClass().getClassLoader().getResourceAsStream("META-INF/DBConnection.properties"); // Mirar en 'Other sources'
            prop.load(in);
            in.close();            
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName(prop.getProperty("driverClassName")); // https://dev.mysql.com/doc/connector-j/8.1/en/connector-j-reference-driver-name.html
            dataSource.setUrl(prop.getProperty("url"));
            dataSource.setUsername(prop.getProperty("username"));
            dataSource.setPassword(prop.getProperty("password"));
            dataSource.setInitialSize(Integer.parseInt(prop.getProperty("tamInicial"))); // Número inicial de conexiones en el pool
            dataSource.setMaxTotal(Integer.parseInt(prop.getProperty("tamMaximo"))); // Número máximo de conexiones en el pool
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }
    
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    
    public void freeConnection(Connection c) {
        try {
            c.close();
        } catch (SQLException ex) {
            System.out.println("Error al liberar conexión");
            ex.printStackTrace(System.out);
        }
    }
    
}
