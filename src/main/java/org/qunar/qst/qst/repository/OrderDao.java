package org.qunar.qst.qst.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.qunar.qst.qst.entity.Order;

/**
 * Created by ronghaizheng on 15/2/15.
 */
public interface OrderDao extends PagingAndSortingRepository<Order, Long>, JpaSpecificationExecutor<Order>{

}
