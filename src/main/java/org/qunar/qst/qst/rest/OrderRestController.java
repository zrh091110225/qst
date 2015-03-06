package org.qunar.qst.qst.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.qunar.qst.qst.entity.Order;
import org.qunar.qst.qst.service.order.OrderService;
import org.qunar.qst.qst.web.MediaTypes;

import javax.annotation.Resource;

/**
 * Created by ronghaizheng on 15/2/13.
 */
@RestController
@RequestMapping(value = "/api/order")
public class OrderRestController {
    private static Logger logger = LoggerFactory.getLogger(OrderRestController.class);
    @Resource
    private OrderService orderService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
    public Order get(@PathVariable("id") String id) {
        Order order = orderService.redisQueryOrderDetail(id);
        if (order == null) {
            String message = "订单号不存在(id:" + id + ")";
            logger.warn(message);
            throw new RestException(HttpStatus.NOT_FOUND, message);
        }
        return order;
    }

    @RequestMapping(value = "/copy", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
    public String copyOrder(@RequestParam("start") int start,
                            @RequestParam("end") int end) {
        return "";
    }

    @RequestMapping(value = "/copy/{orderId}", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
    public Order copyOrderId(@PathVariable("orderId") String orderId) {
        Order order = orderService.getOrderByOrderId(orderId);
        if (orderService.addOrderDetail(order)) {
            return order;
        } else {
            String message = "订单号不存在(id:" + orderId + ")";
            logger.warn(message);
            throw new RestException(HttpStatus.NOT_FOUND, message);
        }
    }
}
