package cn.gavin.order.service;

import cn.gavin.common.constant.OperationResponse;
import cn.gavin.order.entity.PlaceOrderRequestVO;

public interface OrderService {
    OperationResponse create(PlaceOrderRequestVO placeOrderRequestVO);
}
