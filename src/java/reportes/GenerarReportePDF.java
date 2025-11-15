package reportes;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import conexion.conexion;

public class GenerarReportePDF {

    public static void crearReporte() {
        Document documento = new Document(PageSize.A4);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
        String fecha = sdf.format(new Date());
        String nombreArchivo = "Reporte_Reparaciones_" + fecha + ".pdf";

        Connection con = null;

        try {
            PdfWriter.getInstance(documento, new FileOutputStream(nombreArchivo));
            documento.open();

            // === Cargar logotipo ===
            try {
                Image logo = Image.getInstance("imagenes/logo.png"); // Ruta dentro del proyecto
                logo.scaleToFit(80, 80);
                logo.setAlignment(Element.ALIGN_LEFT);
                documento.add(logo);
            } catch (Exception ex) {
                System.out.println("⚠ No se encontró el logotipo. Continuando sin la imagen.");
            }

            // === Título ===
            Paragraph titulo = new Paragraph("MOTO REPARACIONES CALEL\n\n",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 22, BaseColor.BLUE));
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            // === Subtítulo ===
            Paragraph subtitulo = new Paragraph("Listado de Servicios Realizados\n\n",
                    FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, BaseColor.DARK_GRAY));
            subtitulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(subtitulo);

            // === Línea separadora ===
            LineSeparator linea = new LineSeparator();
            linea.setLineColor(BaseColor.LIGHT_GRAY);
            documento.add(linea);
            documento.add(new Paragraph("\n"));

            // === Crear tabla ===
            PdfPTable tabla = new PdfPTable(6);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{1.5f, 3, 2.5f, 3, 2, 2});

            Font fontHeader = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
            BaseColor azulOscuro = new BaseColor(0, 102, 204);

            String[] headers = {"Código", "Cliente", "Modelo", "Servicio", "Costo", "Fecha"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(header, fontHeader));
                cell.setBackgroundColor(azulOscuro);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setPadding(6);
                tabla.addCell(cell);
            }

            // === Conexión a base de datos ===
            conexion cn = new conexion();
            con = cn.conectar();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM reparaciones");

            Font fontData = FontFactory.getFont(FontFactory.HELVETICA, 11, BaseColor.BLACK);

            while (rs.next()) {
                tabla.addCell(new Phrase(String.valueOf(rs.getInt("codigo_servicio")), fontData));
                tabla.addCell(new Phrase(rs.getString("nombre_cliente"), fontData));
                tabla.addCell(new Phrase(rs.getString("modelo_moto"), fontData));
                tabla.addCell(new Phrase(rs.getString("tipo_servicio"), fontData));
                tabla.addCell(new Phrase("Q " + rs.getDouble("costo"), fontData));
                tabla.addCell(new Phrase(rs.getString("fecha_ingreso"), fontData));
            }

            documento.add(tabla);

            documento.add(new Paragraph("\n"));

            // === Pie de página ===
            Paragraph pie = new Paragraph(
                    "Generado automáticamente por Moto Reparaciones Calel\n" +
                    "Fecha: " + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()),
                    FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 10, BaseColor.GRAY));
            pie.setAlignment(Element.ALIGN_CENTER);
            documento.add(pie);

            documento.close();
            con.close();

            JOptionPane.showMessageDialog(null,
                    "Reporte PDF generado correctamente:\n" + nombreArchivo);

            // Abrir el archivo automáticamente
            File pdf = new File(nombreArchivo);
            if (pdf.exists()) {
                java.awt.Desktop.getDesktop().open(pdf);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "❌ Error al generar el reporte:\n" + e.getMessage());
        }
    }
}
