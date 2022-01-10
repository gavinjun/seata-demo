package cn.gavin.storage.service;

public interface StockService {
    boolean reduceStock(Long productId, Integer amount) throws Exception;
}
