package org.qunar.qst.qst.service.order;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.qunar.qst.qst.domain.RedisConfig;
import org.qunar.qst.qst.entity.Order;
import org.qunar.qst.qst.modules.DynamicSpecifications;
import org.qunar.qst.qst.modules.SearchFilter;
import org.qunar.qst.qst.repository.OrderDao;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ronghaizheng on 15/2/7.
 */
@Service
public class OrderService {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private RedisTemplate redisTemplate;
    private OrderDao orderDao;


    public Order redisQueryOrderDetail(String orderId) {
        if (StringUtils.isBlank(orderId)) {
            return null;
        }
        HashOperations<String, String, Order> hashOrderOpt = redisTemplate.opsForHash();
        return hashOrderOpt.get(RedisConfig.ORDER_DETAIL_HASH_KEY, orderId);
    }

    public Order getOrderByOrderId(String orderId) {
        return orderDao.findOne(buildSpecification(orderId, new HashMap<String, Object>()));
    }

    /**
     * 创建动态查询条件组合.
     */
    private Specification<Order> buildSpecification(String orderId, Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        filters.put("orderId", new SearchFilter("orderId", SearchFilter.Operator.EQ, orderId));
        Specification<Order> spec = DynamicSpecifications.bySearchFilter(filters.values(), Order.class);
        return spec;
    }

    public boolean addOrderDetail(Order order) {
        try {
            if (order == null) {
                logger.error("order is null!");
                return false;
            }
            HashOperations<String, String, Order> hashOrderOpt = redisTemplate.opsForHash();
            hashOrderOpt.put(RedisConfig.ORDER_DETAIL_HASH_KEY, order.getOrderId(), order);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    public boolean addOrderFromDB(String orderId) {
        Order order = getOrderByOrderId(orderId);
        if (order == null) return false;

        return addOrderDetail(order);
    }
}
