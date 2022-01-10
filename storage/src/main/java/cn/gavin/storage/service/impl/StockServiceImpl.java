package cn.gavin.storage.service.impl;

import cn.gavin.storage.entity.Product;
import cn.gavin.storage.mapper.ProductMapper;
import cn.gavin.storage.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class StockServiceImpl implements StockService {

    @Autowired
    ProductMapper productMapper;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Override
    public boolean reduceStock(Long productId, Integer amount) throws Exception {
        // 检查库存
        checkStock(productId, amount);

        log.info("开始扣减 {} 库存", productId);
        // 扣减库存
        Product product = productMapper.selectById(productId);
        product.setStock(product.getStock() - amount);
        Integer record = productMapper.updateById(product);
        log.info("扣减 {} 库存结果:{}", productId, record > 0 ? "操作成功" : "扣减库存失败");

        return record > 0;

    }

    private void checkStock(Long productId, Integer requiredAmount) throws Exception {

        log.info("检查 {} 库存", productId);
        Product product = productMapper.selectById(productId);

        if (product.getStock() < requiredAmount) {
            log.warn("{} 库存不足，当前库存:{}", productId, product.getStock());
            throw new Exception("库存不足");
        }
    }
}
