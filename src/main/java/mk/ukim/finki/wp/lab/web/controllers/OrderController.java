package mk.ukim.finki.wp.lab.web.controllers;

import mk.ukim.finki.wp.lab.service.OrderService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getOrdersPage(Model model){

        model.addAttribute("orders",orderService.listAll());
        return "userOrders";
    }

    @GetMapping("/getOrder")
    public String getPlaceOrderPage(Model model){

        return "place-Order";
    }

    @PostMapping("/placeOrder")
    public String placeOrder(Model model, HttpSession session
            , @RequestParam("date_Created")
                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateCreated
    ){


        orderService.placeOrder(session.getAttribute("color").toString()
                ,session.getAttribute("clientName").toString()
                ,session.getAttribute("size").toString()
                , dateCreated);

        model.addAttribute("orders",orderService.listAll());
        return "userOrders";
    }
}