<%@page import="java.sql.DriverManager"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.Connection"%>


<%
    //Connection conex;
    //if((request.getParameter("conn")!=null) && (request.getParameter("cpps")!=null) )
    //{
           //variable tipo Cpp en la q recibo el javabean
        
    //    conex = (Connection)request.getAttribute("conn");
    //}


    
    Connection cn=null;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cobranza","root","admin");
        }
        catch(Exception e)
        {
            
        }
        
        

   File reportFile = new File(application.getRealPath("cpp.jasper"));

    Map parameters = new HashMap();

    byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath (),parameters,cn);

    response.setContentType("application/pdf");
    response.setContentLength(bytes.length);
    ServletOutputStream ouputStream = response.getOutputStream();
    ouputStream.write(bytes, 0, bytes.length);
    ouputStream.flush();
    ouputStream.close();
%>
