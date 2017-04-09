package exam.controller;

import exam.service.OrderDetailParserService;
import exam.service.TruncateService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
public class SubscriptionController {

    private static final Logger LOGGER = Logger.getLogger(SubscriptionController.class);

    private final TruncateService truncateService;
    private final OrderDetailParserService orderDetailParserService;

    @Autowired
    public SubscriptionController(TruncateService truncateService, OrderDetailParserService orderDetailParserService) {
        this.truncateService = truncateService;
        this.orderDetailParserService = orderDetailParserService;
    }

    @RequestMapping(value = "/subscribe", method = RequestMethod.GET)
    public String subscribe(HttpServletRequest request) {

        String orderDetails = getOrderDetails(request.getParameter("order"));
        String truncatedOrderDetails = truncate(orderDetails, 250);
        LOGGER.info(truncatedOrderDetails);

        return "Success";
    }

    private String truncate(String orderDetails, int limit) {
        return truncateService.truncate(orderDetails, limit);
    }

    private String getOrderDetails(String order) {
        return orderDetailParserService.getOrderDetails(order);
    }
}
