package cn.gavin.storage.controller;

import cn.gavin.common.constant.OperationResponse;
import cn.gavin.storage.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Bussiness {
    @Autowired
    StockService stockService;
    // 下单
    @RequestMapping("reduceStock")
    public OperationResponse createOrder(@RequestParam Long productId, @RequestParam Integer amount) {
        boolean rs = false;
        try {
            rs = stockService.reduceStock(productId, amount);
        } catch (Exception e) {
            log.error("reduceStock fail", e);
        }
        return OperationResponse.builder().success(rs).build();
    }
}
