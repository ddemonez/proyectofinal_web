package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {

    private String url = "jdbc:mariadb://localhost:3333/taller_moto";
    private String user = "root";
    private String pass = "porsche911$";
    private String driver = "org.mariadb.jdbc.Driver";

    public Connection conectar() {
        Connection con = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión exitosa a MariaDB");
        } catch (Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }

        return con;
    }
}
