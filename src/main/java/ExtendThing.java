import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ExtendThing", urlPatterns = "/api")
public  class ExtendThing extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        request.getRequestDispatcher("PersonaleHome.html").include(request, response);
        writer.close();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uid = req.getParameter("username");
        String pwd = req.getParameter("password");
//Hoi
        if (uid.toLowerCase().equals("qq") && pwd.equals("qq")) {
            resp.addCookie(new Cookie("session", uid));
            PrintWriter writer = resp.getWriter();
            resp.sendRedirect("api");
        } else {
            resp.sendRedirect("index.html");
        }
    }
}
