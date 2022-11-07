package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.service.BalloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "balloon-order-servlet", urlPatterns = "/orderServlet")
public class BalloonOrderServlet extends HttpServlet {

    private final BalloonService balloonService;
    private final SpringTemplateEngine springTemplateEngine;

    public BalloonOrderServlet(BalloonService balloonService, SpringTemplateEngine springTemplateEngine) {
        this.balloonService = balloonService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WebContext context = new WebContext(req, resp, req.getServletContext());
        this.springTemplateEngine.process("deliveryInfo.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String clientName = req.getParameter("clientName").toString();
        String clientAddress = req.getParameter("clientAddress").toString();
        req.getSession().setAttribute("clientName", clientName);
        req.getSession().setAttribute("clientAddress", clientAddress);
        req.getSession().setAttribute("ipAddress", req.getRemoteAddr());
        req.getSession().setAttribute("clientAgent", req.getHeader("User-Agent"));

        resp.sendRedirect("/confirmationInfoServlet");
    }
}
