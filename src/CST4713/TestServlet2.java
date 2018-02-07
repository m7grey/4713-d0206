package CST4713;

import java.io.*;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import coreservlets.*;

/**
 * Simple servlet for testing. Makes use of a helper class.
 */

@WebServlet("/getFormData")
public class TestServlet2 extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Halo";
        out.println
                (ServletUtilities.headWithTitle(title) +
                        "<body bgcolor=\"#fdf5e6\">\n" +
                        "<h1>" + title + "</h1>\n");

        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            out.println("<BR>" + paramName + ": " + request.getParameter(paramName));
        }

//                        "First Name: "+ request.getParameter("firstName")+"\n"+
//                        "Last Name: "+ request.getParameter("lastName")+
        out.println("</body></html>");
    }
}
