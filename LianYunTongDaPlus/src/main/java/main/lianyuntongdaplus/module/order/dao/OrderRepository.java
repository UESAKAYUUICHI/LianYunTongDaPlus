package main.lianyuntongdaplus.module.order.dao;

import main.lianyuntongdaplus.module.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Modifying
    @Transactional
    @Query("delete from Order b where b.orderId = :id")
    Integer deleteBookById (@Param("id") Integer id);

    // 根据订单名称模糊查询
    List<Order> findByOrderNameContaining(String orderName);

    // 根据订单ID精确查找
    List<Order> findByOrderId(Integer orderId);

}
