package cn.gavin.order.service.impl;

import cn.gavin.common.constant.OperationResponse;
import cn.gavin.order.client.StockClient;
import cn.gavin.order.entity.Order;
import cn.gavin.order.entity.OrderStatus;
import cn.gavin.order.entity.PlaceOrderRequestVO;
import cn.gavin.order.mapper.order.OrderMapper;
import cn.gavin.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    StockClient stockClient;

    @Transactional
    @Override
    public OperationResponse create(PlaceOrderRequestVO placeOrderRequestVO) {
        // 下单
        Integer amount = 1;
        Integer price = placeOrderRequestVO.getPrice();
        Order order = Order.builder().userId(placeOrderRequestVO.getUserId()).productId(
                placeOrderRequestVO.getProductId()).status(OrderStatus.INIT).payAmount(price).build();
        Integer saveOrderRecord = orderMapper.insert(order);
        // 扣库存
        stockClient.deduct(placeOrderRequestVO.getProductId().toString(), amount);
        int b = 10;
        int a = 10-b;
        a = 10/a;
        return null;
    }
}
