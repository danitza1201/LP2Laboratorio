package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import bd.*;

public final class DatosPersona_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            String consulta;
            Connection cn;
            PreparedStatement pst;
            ResultSet rs;
            String s_accion;
            String s_idpersona;
            String s_nombre;
            String s_apellidos;
            String s_direccion;
            String s_telefono;
            String s_dni;
            String s_estado;
            
        
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Datos Estudiante</title>\r\n");
      out.write("        <link href=\"css/Estilosparatabla.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

            try{
                ConectaBd bd = new ConectaBd();
                cn = bd.getConnection();
                
                s_accion = request.getParameter("f_accion");
                s_idpersona = request.getParameter("f_idpersona");
                
                if(s_accion!=null && s_accion.equals("M1")){
                    consulta = "    select Nombre, Apellido, Dirección, Telefono, DNI, Estado  "
                                + " from persona "
                                + " where"
                                + " IdPersona = " + s_idpersona + "; ";
                    //out.print(consulta);
                    pst = cn.prepareStatement(consulta);
                    rs = pst.executeQuery();
                    if (rs.next()) {
        
      out.write("\r\n");
      out.write("        <br>\r\n");
      out.write("        <form name=\"EditarEstudianteForm\" action=\"DatosPersona.jsp\" method=\"GET\">\r\n");
      out.write("            <table border=\"0\" align=\"center\">\r\n");
      out.write("                <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th colspan=\"2\">Editar Persona</th>\r\n");
      out.write("                        \r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Nombre: </td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"f_nombre\" value=\"");
 out.print(rs.getString(1)); 
      out.write("\" maxlength=\"30\" size=\"20\" /></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Apellido: </td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"f_apellidos\" value=\"");
 out.print(rs.getString(2)); 
      out.write("\" maxlength=\"30\" size=\"20\" /></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Dirección: </td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"f_direccion\" value=\"");
 out.print(rs.getString(3)); 
      out.write("\" maxlength=\"40\" size=\"8\"/></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Telefono:</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"f_telefono\" value=\"");
 out.print(rs.getString(4)); 
      out.write("\" maxlength=\"9\" size=\"11\"/></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>DNI: </td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"f_dni\" value=\"");
 out.print(rs.getString(5)); 
      out.write("\" maxlength=\"8\" size=\"11\"/></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Estado: </td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"f_estado\" value=\"");
 out.print(rs.getString(6)); 
      out.write("\" maxlength=\"1\" size=\"2\"/></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr align=\"center\">\r\n");
      out.write("                        <td colspan=\"2\">\r\n");
      out.write("                            \r\n");
      out.write("                            <button type=\"submit\" value=\"\" name=\"f_editar\"><img  src=\"imagenes/guardar.png\" width=\"60\"></button>\r\n");
      out.write("                            <input type=\"hidden\" name=\"f_accion\" value=\"M2\" />\r\n");
      out.write("                            <input type=\"hidden\" name=\"f_idpersona\" value=\"");
 out.print(s_idpersona); 
      out.write("\" />\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("\r\n");
      out.write("        </form>\r\n");
      out.write("        ");

                }
            }else{
        
      out.write("\r\n");
      out.write("        <form name=\"AgregarEstudianteForm\" action=\"DatosPersona.jsp\" method=\"GET\">\r\n");
      out.write("            <table border=\"0\" align=\"center\">\r\n");
      out.write("                <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th colspan=\"2\">Agregar Persona</th>\r\n");
      out.write("                        \r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Nombre:</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"f_nombre\" value=\"\" maxlength=\"30\" size=\"20\" /></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Apellido:</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"f_apellidos\" value=\"\" maxlength=\"30\" size=\"20\" /></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Dirección:</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"f_direccion\" value=\"\" maxlength=\"40\" size=\"20\"/></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Telefono:</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"f_telefono\" value=\"\" maxlength=\"9\" size=\"11\"/></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>DNI:</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"f_dni\" value=\"\" maxlength=\"8\" size=\"11\"/></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>Estado:</td>\r\n");
      out.write("                        <td><input type=\"text\" name=\"f_estado\" value=\"\" maxlength=\"1\" size=\"1\"/></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr align=\"center\">\r\n");
      out.write("                        <td colspan=\"2\">\r\n");
      out.write("                            <button type=\"submit\" value=\"\" name=\"f_agregar\"><img  src=\"imagenes/guardar.png\" width=\"60\"></button>\r\n");
      out.write("                            <input type=\"hidden\" name=\"f_accion\" value=\"C\" />\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    \r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("        </form>\r\n");
      out.write("        ");

        }
        
      out.write("\r\n");
      out.write("        <br>\r\n");
      out.write("        <table class=\"general\" border=\"1\" cellspacing=\"0\" cellpadding=\"\" align = \"center\">\r\n");
      out.write("            <thead>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th colspan=\"9\">Datos Persona</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th>N°</th>\r\n");
      out.write("                    <th>Nombre</th>\r\n");
      out.write("                    <th>Apellidos</th>\r\n");
      out.write("                    <th>Direccion</th>\r\n");
      out.write("                    <th>Telefono</th>\r\n");
      out.write("                    <th>DNI</th>\r\n");
      out.write("                    <th>Estado</th>\r\n");
      out.write("                    <th colspan=\"2\">Accion</th>\r\n");
      out.write("                    \r\n");
      out.write("                </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("\r\n");
      out.write("        ");

            
                
                if (s_accion!=null) {
                    if (s_accion.equals("E")) {
                        consulta =  "   delete from persona "
                                    + " where "
                                    + " IdPersona = " + s_idpersona + "; ";
                        //out.print(consulta);
                        pst = cn.prepareStatement(consulta);
                        pst.executeUpdate();
                            
                    }else if (s_accion.equals("C")) {
                        s_nombre = request.getParameter("f_nombre");
                        s_apellidos = request.getParameter("f_apellidos");
                        s_direccion = request.getParameter("f_direccion");
                        s_telefono = request.getParameter("f_telefono");
                        s_dni = request.getParameter("f_dni");
                        s_estado = request.getParameter("f_estado");
                        consulta =  "   insert into "
                                    + " persona(Nombre, Apellido, Dirección, Telefono, DNI, Estado ) "
                                    + " values ('"+ s_nombre +"','"+ s_apellidos +"','"+ s_direccion +"','"+ s_telefono +"','"+ s_dni+"','"+ s_estado +"')";
                        //out.print(consulta);
                        pst = cn.prepareStatement(consulta);
                        pst.executeUpdate();
                    }else if (s_accion.equals("M2")) {
                        s_nombre = request.getParameter("f_nombre");
                        s_apellidos = request.getParameter("f_apellidos");
                        s_direccion = request.getParameter("f_direccion");
                        s_telefono = request.getParameter("f_telefono");
                        s_dni = request.getParameter("f_dni");
                        s_estado = request.getParameter("f_estado");
                        consulta = " update  persona  "
                                + "  set  "
                                + "  Nombre = '"+ s_nombre +"',"
                                + "  Apellido = '"+ s_apellidos +"',"
                                + "  Dirección = '"+ s_direccion +"', "
                                + "  Telefono = '"+ s_telefono +"', "
                                + "  DNI = '"+ s_dni +"', "
                                + "  Estado = '"+ s_estado +"' "
                                + "  where "
                                + "  IdPersona = "+ s_idpersona +"; ";
                        //out.print(consulta);
                        pst = cn.prepareStatement(consulta);
                        pst.executeUpdate();
                    }
                }
                consulta= " Select IdPersona, Nombre, Apellido, Dirección, Telefono, DNI, Estado "
                        + " from persona ";
                //out.print(consulta);
                pst = cn.prepareStatement(consulta);
                rs = pst.executeQuery();
                int num = 0;
                String ide;
                while (rs.next()) {  
                    ide = rs.getString(1);
                    num++;

                    
      out.write("\r\n");
      out.write("                    <tbody>\r\n");
      out.write("                       <tr>\r\n");
      out.write("                        <td>");
out.print(num);
      out.write("</td>\r\n");
      out.write("                        <td>");
out.print(rs.getString(2));
      out.write("</td>\r\n");
      out.write("                        <td>");
out.print(rs.getString(3));
      out.write("</td>\r\n");
      out.write("                        <td>");
out.print(rs.getString(4));
      out.write("</td>\r\n");
      out.write("                        <td>");
out.print(rs.getString(5));
      out.write("</td>\r\n");
      out.write("                        <td>");
out.print(rs.getString(6));
      out.write("</td>\r\n");
      out.write("                        <td>");
out.print(rs.getString(7));
      out.write("</td>\r\n");
      out.write("                        <td><button href=\"DatosPersona.jsp?f_accion=E&f_idpersona=");
out.print(ide);
      out.write("\" type=\"submit\" value=\"\"><img  src=\"imagenes/eliminar.png\" width=\"20\"></button></td>\r\n");
      out.write("                        <td><button href=\"DatosPersona.jsp?f_accion=M1&f_idpersona=");
out.print(ide);
      out.write("\" type=\"submit\" value=\"\"><img  src=\"imagenes/editar.png\" width=\"30\"></button></td>\r\n");
      out.write("\r\n");
      out.write("                    </tr>                    \r\n");
      out.write("                    ");

                    }
            }catch(Exception e){
                out.print("Error SQL");
            }
        
        
      out.write(" \r\n");
      out.write("                    </tbody>\r\n");
      out.write("                    \r\n");
      out.write("        </table>\r\n");
      out.write("        <br>\r\n");
      out.write("        <div align=\"center\">\r\n");
      out.write("            <a href=\"menu.jsp\">Menu</a>\r\n");
      out.write("        </div>\r\n");
      out.write("                    \r\n");
      out.write("        \r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
