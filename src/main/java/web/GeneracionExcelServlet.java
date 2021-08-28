package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/GeneracionExcelServlet")
public class GeneracionExcelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");//Especificamos el tipo de documento que enviamos al cliente

        //Cuando hacemos click sobre el link va a descargar el documento
        response.setHeader("Content-Disposition", "attachment;filename=excelEjemplo.xls");

        //Le decimos que no guarde informacion en el cache y que la info expire de manera inmediata
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", -1);

        //desplegamos la info al cliente
        PrintWriter out = response.getWriter();
        out.println("\tValores");
        out.println("\t1");
        out.println("\t2");
        out.println("Total\t=SUM(B2:B3)");
        out.close();
    }

}
