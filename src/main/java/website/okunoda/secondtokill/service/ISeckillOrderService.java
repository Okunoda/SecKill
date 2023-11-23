package website.okunoda.secondtokill.service;

import org.springframework.stereotype.Service;
import website.okunoda.secondtokill.pojo.Order;
import website.okunoda.secondtokill.pojo.SeckillOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author okunoda
 * @since 2023-07-18
 */

public interface ISeckillOrderService extends IService<SeckillOrder> {

    SeckillOrder queryOrderByGoodsIdAndUserId(Long goodsId, Long userId);

    Order doSeckill(Long goodsId, Long userId);
}
