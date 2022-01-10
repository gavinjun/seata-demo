package cn.gavin.order.controller;

import cn.gavin.common.constant.OperationResponse;
import cn.gavin.order.client.StockClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {
    @Autowired
    StockClient stockClient;

    @RequestMapping("/")
    public OperationResponse index(@RequestParam("productId") Long productId, @RequestParam("amount") Integer amount) {
        return stockClient.deduct(productId.toString(), amount);
    }
}
