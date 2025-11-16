package controlador;

package controlador;

import modelo.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import reportes.GenerarReportePDF;


public class Controlador extends HttpServlet {

    ReparacionDao dao = new ReparacionDao();
    Reparacion r = new Reparacion();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String accion = req.getParameter("accion");

        switch (accion) {

            case "listar":
                req.setAttribute("lista", dao.listar());
                req.getRequestDispatcher("listar.jsp").forward(req, resp);
                break;

            case "nuevo":
                req.getRequestDispatcher("agregar.jsp").forward(req, resp);
                break;

            case "editar":
                int codigoEditar = Integer.parseInt(req.getParameter("codigo"));
                Reparacion dato = dao.obtener(codigoEditar);
                req.setAttribute("dato", dato);
                req.getRequestDispatcher("editar.jsp").forward(req, resp);
                break;

            case "eliminar":
                int codigoEliminar = Integer.parseInt(req.getParameter("codigo"));
                dao.eliminar(codigoEliminar);
                resp.sendRedirect("Controlador?accion=listar");
                break;

            case "reporte":
                reportes.GenerarReportePDF.crearReporte();
                req.getRequestDispatcher("listar.jsp").forward(req, resp);
                break;

            default:
                req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String accion = req.getParameter("accion");

        switch (accion) {
            case "insertar":
                r.setNombre_cliente(req.getParameter("nombre"));
                r.setModelo_moto(req.getParameter("modelo"));
                r.setTipo_servicio(req.getParameter("tipo"));
                r.setCosto(Double.parseDouble(req.getParameter("costo")));
                r.setFecha_ingreso(req.getParameter("fecha"));
                dao.insertar(r);
                resp.sendRedirect("Controlador?accion=listar");
                break;

            case "actualizar":
                r.setCodigo_servicio(Integer.parseInt(req.getParameter("codigo")));
                r.setNombre_cliente(req.getParameter("nombre"));
                r.setModelo_moto(req.getParameter("modelo"));
                r.setTipo_servicio(req.getParameter("tipo"));
                r.setCosto(Double.parseDouble(req.getParameter("costo")));
                r.setFecha_ingreso(req.getParameter("fecha"));
                dao.actualizar(r);
                resp.sendRedirect("Controlador?accion=listar");
                break;
        }
    }

}
