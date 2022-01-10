package cn.gavin.storage.controller;

import cn.gavin.common.constant.OperationResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {
    @RequestMapping("/")
    public OperationResponse index() {
        return OperationResponse.builder().success(true).build();
    }
}
