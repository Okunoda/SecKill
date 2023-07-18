package website.okunoda.secondtokill.service.impl;

import website.okunoda.secondtokill.pojo.Order;
import website.okunoda.secondtokill.mapper.OrderMapper;
import website.okunoda.secondtokill.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author okunoda
 * @since 2023-07-18
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
