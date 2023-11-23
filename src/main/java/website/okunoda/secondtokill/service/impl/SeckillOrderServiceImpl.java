package website.okunoda.secondtokill.service.impl;

import lombok.var;
import website.okunoda.secondtokill.mapper.GoodsMapper;
import website.okunoda.secondtokill.mapper.OrderMapper;
import website.okunoda.secondtokill.pojo.Order;
import website.okunoda.secondtokill.pojo.SeckillOrder;
import website.okunoda.secondtokill.mapper.SeckillOrderMapper;
import website.okunoda.secondtokill.service.ISeckillOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author okunoda
 * @since 2023-07-18
 */
@Service
public class SeckillOrderServiceImpl extends ServiceImpl<SeckillOrderMapper, SeckillOrder> implements ISeckillOrderService {

    @Resource
    private SeckillOrderMapper seckillOrderMapper;

    @Resource
    private OrderMapper orderMapper;
    @Resource(name = "goodsMapper")
    private GoodsMapper goodsMapper;

    @Override
    public SeckillOrder queryOrderByGoodsIdAndUserId(Long goodsId, Long userId) {
        return seckillOrderMapper.queryOrderByGoodsIdAndUserId(goodsId, userId);

    }

    @Override
    public Order doSeckill(Long goodsId, Long userId) {
        //查询出商品信息，减少其库存
        var goodsVo = goodsMapper.queryGoodsVoById(goodsId);

        goodsVo.setGoodsStock(goodsVo.getGoodsStock() - 1);
        goodsVo.setStockCount(goodsVo.getStockCount() - 1);

        goodsMapper.updateById(goodsVo);

        //生成订单记录
        var order = new Order();
        order.setUserId(userId)
                .setGoodsId(goodsId)
                .setGoodsName(goodsVo.getGoodsName())
                .setGoodsCount(1)
                .setDeliveryAddrId(0L)
                .setGoodsPrice(goodsVo.getSeckillPrice())
                .setStatus(0)
                .setCreateDate(new Date())
                .setOrderChannel(1);
        orderMapper.insert(order);

        //生成秒杀订单
        SeckillOrder seckillOrder = new SeckillOrder();
        seckillOrder.setUserId(userId);
        seckillOrder.setOrderId(order.getId());
        seckillOrder.setGoodsId(goodsId);
        seckillOrderMapper.insert(seckillOrder);
        return order;
    }
}
