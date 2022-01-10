package cn.gavin.order.controller;

import cn.gavin.common.constant.OperationResponse;
import cn.gavin.order.entity.PlaceOrderRequestVO;
import cn.gavin.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Bussiness {
    @Autowired
    OrderService orderService;
    // 下单
    @RequestMapping("createOrder")
    public OperationResponse createOrder() {
        PlaceOrderRequestVO placeOrderRequestVO = PlaceOrderRequestVO.builder().price(10).productId(1L).userId(10086L).build();
        return orderService.create(placeOrderRequestVO);
    }
}
