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
                req.getRequestDispatcher("formAgregar.jsp").forward(req, resp);
                break;

            case "editar":
                int idEditar = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("dato", dao.obtenerPorId(idEditar));
                req.getRequestDispatcher("formEditar.jsp").forward(req, resp);
                break;

            case "eliminar":
                int idEliminar = Integer.parseInt(req.getParameter("id"));
                dao.eliminar(idEliminar);
                resp.sendRedirect("Controlador?accion=listar");
                break;

            case "pdf":
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

            case "agregar":
                r.setNombre_cliente(req.getParameter("nombre"));
                r.setModelo_moto(req.getParameter("modelo"));
                r.setTipo_servicio(req.getParameter("tipo"));
                r.setCosto(Double.parseDouble(req.getParameter("costo")));
                r.setFecha_ingreso(req.getParameter("fecha"));
                dao.agregar(r);
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
