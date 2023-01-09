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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("Ahoy!");
        writer.close();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uid = req.getParameter("username");
        String pwd = req.getParameter("password");

        if (uid.toLowerCase().equals("qq") && pwd.equals("qq")) {
            resp.addCookie(new Cookie("session", uid));
            PrintWriter writer = resp.getWriter();
            writer.print("Congratulations, " + uid + ", you got in!");
        } else {
            resp.sendRedirect("index.html");
        }
    }
}
