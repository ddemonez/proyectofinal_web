package modelo;

import conexion.conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReparacionDao {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // LISTAR
    public List<Reparacion> listar() {
        List<Reparacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM reparaciones";

        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Reparacion r = new Reparacion(
                        rs.getInt("codigo_servicio"),
                        rs.getString("nombre_cliente"),
                        rs.getString("modelo_moto"),
                        rs.getString("tipo_servicio"),
                        rs.getDouble("costo"),
                        rs.getString("fecha_ingreso")
                );
                lista.add(r);
            }

        } catch (Exception e) {
            System.out.println("Error listar: " + e.getMessage());
        }
        return lista;
    }

    // AGREGAR
    public boolean agregar(Reparacion r) {
        String sql = "INSERT INTO reparaciones(nombre_cliente, modelo_moto, tipo_servicio, costo, fecha_ingreso) "
                   + "VALUES(?,?,?,?,?)";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, r.getNombre_cliente());
            ps.setString(2, r.getModelo_moto());
            ps.setString(3, r.getTipo_servicio());
            ps.setDouble(4, r.getCosto());
            ps.setString(5, r.getFecha_ingreso());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Error agregar: " + e.getMessage());
            return false;
        }
    }

    // OBTENER POR ID (para editar)
    public Reparacion obtenerPorId(int id) {
        Reparacion r = null;
        String sql = "SELECT * FROM reparaciones WHERE codigo_servicio=?";

        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                r = new Reparacion(
                    rs.getInt("codigo_servicio"),
                    rs.getString("nombre_cliente"),
                    rs.getString("modelo_moto"),
                    rs.getString("tipo_servicio"),
                    rs.getDouble("costo"),
                    rs.getString("fecha_ingreso")
                );
            }

        } catch (Exception e) {
            System.out.println("Error obtener: " + e.getMessage());
        }
        return r;
    }

    // ACTUALIZAR
    public boolean actualizar(Reparacion r) {
        String sql = "UPDATE reparaciones SET nombre_cliente=?, modelo_moto=?, tipo_servicio=?, costo=?, fecha_ingreso=? "
                   + "WHERE codigo_servicio=?";
        
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, r.getNombre_cliente());
            ps.setString(2, r.getModelo_moto());
            ps.setString(3, r.getTipo_servicio());
            ps.setDouble(4, r.getCosto());
            ps.setString(5, r.getFecha_ingreso());
            ps.setInt(6, r.getCodigo_servicio());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Error actualizar: " + e.getMessage());
            return false;
        }
    }

    // ELIMINAR
    public boolean eliminar(int id) {
        String sql = "DELETE FROM reparaciones WHERE codigo_servicio=?";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Error eliminar: " + e.getMessage());
            return false;
        }
    }
}
