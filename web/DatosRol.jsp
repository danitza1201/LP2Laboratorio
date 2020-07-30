<%@page import="java.sql.*" %>
<%@page import="bd.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos Rol</title>
        <link href="css/Estilosparatabla.css" rel="stylesheet" type="text/css"/>
        <%!
            String consulta;
            String consulta2;
            Connection cn;
            Connection cn2;
            PreparedStatement pst;
            PreparedStatement pst2;
            ResultSet rs;
            ResultSet rs2;
            String s_accion;
            String s_idrol;
            String s_nombre;
            String s_estado;
            boolean valor;
            
        %>
    </head>
    <body>
        <%
            try{
                ConectaBd bd = new ConectaBd();
                cn = bd.getConnection();
                
                s_accion = request.getParameter("f_accion");
                s_idrol = request.getParameter("f_idrol");
                
                if(s_accion!=null && s_accion.equals("M1")){
                    consulta = "    select Nombre, Estado  "
                                + " from rol "
                                + " where"
                                + " IdRol = " + s_idrol + "; ";
                    //out.print(consulta);
                    pst = cn.prepareStatement(consulta);
                    rs = pst.executeQuery();
                    if (rs.next()) {
        %>
        <br>
        <form name="EditarRolForm" action="DatosRol.jsp" method="GET">
            <table border="0" align="center">
                <thead>
                    <tr>
                        <th colspan="2">Editar Area</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nombre: </td>
                        <td><input type="text" name="f_nombre" value="<% out.print(rs.getString(1)); %>" maxlength="30" size="20" /></td>
                    </tr>
                    <tr>
                        <td>Estado: </td>
                        <td><input type="text" name="f_estado" value="<% out.print(rs.getString(2)); %>" maxlength="1" size="2"/></td>
                    </tr>
                    <tr align="center">
                        <td colspan="2">
                            
                            <button type="submit" value="" name="f_editar"><img  src="imagenes/guardar.png" width="60"></button>
                            <input type="hidden" name="f_accion" value="M2" />
                            <input type="hidden" name="f_idrol" value="<% out.print(s_idrol); %>" />
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
        <%
                }
            }else{
        %>
        <form name="AgregarRolForm" action="DatosRol.jsp" method="GET">
            <table border="0" align="center">
                <thead>
                    <tr>
                        <th colspan="2">Agregar Rol</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nombre:</td>
                        <td><input type="text" name="f_nombre" value="" maxlength="30" size="20" /></td>
                    </tr>
                    <tr>
                        <td>Estado:</td>
                        <td><input type="text" name="f_estado" value="" maxlength="1" size="1"/></td>
                    </tr>
                    <tr align="center">
                        <td colspan="2">
                            <button type="submit" value="" name="f_agregar"><img  src="imagenes/guardar.png" width="60"></button>
                            <input type="hidden" name="f_accion" value="C" />
                        </td>
                    </tr>
                    
                </tbody>
            </table>
        </form>
        <%
        }
        %>
        <br>
        <table class="general" border="1" cellspacing="0" cellpadding="" align = "center">
            <thead>
                <tr>
                    <th colspan="9">Datos Rol</th>
                </tr>
                <tr>
                    <th>N°</th>
                    <th>Nombre</th>
                    <th>Estado</th>
                    <th colspan="2">Accion</th>
                    
                </tr>
            </thead>

        <%
            
                
                if (s_accion!=null) {
                    if (s_accion.equals("E")) {
                        consulta =  "   delete from rol "
                                    + " where "
                                    + " IdRol = " + s_idrol + "; ";
                        //out.print(consulta);
                        pst = cn.prepareStatement(consulta);
                        pst.executeUpdate();
                            
                    }else if (s_accion.equals("C")) {
                        s_nombre = request.getParameter("f_nombre");
                        s_estado = request.getParameter("f_estado");
                        consulta =  "   insert into "
                                    + " rol(Nombre, Estado ) "
                                    + " values ('"+ s_nombre +"','"+ s_estado +"')";
                        //out.print(consulta);
                        pst = cn.prepareStatement(consulta);
                        pst.executeUpdate();
                    }else if (s_accion.equals("M2")) {
                        s_nombre = request.getParameter("f_nombre");
                        s_estado = request.getParameter("f_estado");
                        consulta = " update  rol  "
                                + "  set  "
                                + "  Nombre = '"+ s_nombre +"',"
                                + "  Estado = '"+ s_estado +"' "
                                + "  where "
                                + "  IdRol = "+ s_idrol +"; ";
                        //out.print(consulta);
                        pst = cn.prepareStatement(consulta);
                        pst.executeUpdate();
                    }
                }
                consulta= " Select IdRol, Nombre, Estado "
                        + " from rol ";
                //out.print(consulta);
                pst = cn.prepareStatement(consulta);
                rs = pst.executeQuery();
                int num = 0;
                String ide;
                String ide2;
                while (rs.next()) {  
                    ide = rs.getString(1);
                    num++;

                    %>
                    <tbody>
                       <tr>
                        <td><%out.print(num);%></td>
                        <td><%out.print(rs.getString(2));%></td>
                        <td><%out.print(rs.getString(3));%></td>
                
                    <% consulta2 = "select IdRol from sugerencia; ";
                        pst2 = cn.prepareStatement(consulta2);
                        rs2 = pst2.executeQuery();
                        while(rs2.next()){
                         ide2 = rs2.getString(1);
                         //out.print(Integer.parseInt(ide2) ==Integer.parseInt(ide));
                            if(Integer.parseInt(ide2) ==Integer.parseInt(ide)){
                                valor= true;
                                break;

                            }else{
                                valor = false;
                                //out.print(valor);
                            }
                        }  
                      //out.print(" final:"+valor);
                    if(valor){%>
                   
                         <td><a  ><img  src="imagenes/eliminar.png" width="20"></a></td>
                        <% }else{                    
                        %>
                        
                        <td><a href="DatosRol.jsp?f_accion=E&f_idrol=<%out.print(ide);%>"><img  src="imagenes/eliminar2.png" width="30"></a></td>                 
                    <%
                    }%>
                    <td><a href="DatosRol.jsp?f_accion=M1&f_idrol=<%out.print(ide);%>" ><img  src="imagenes/editar.png" width="30"></a></td>
                    </tr>
                        <%}
            }catch(Exception e){
                out.print("Error SQL");
            }
        
        %> 
                    </tbody>
                    
        </table>
        <br>
        <div align="center">
            <a href="menu.jsp">Menu</a>
        </div>
                    
        
    </body>
</html>
