package website.okunoda.secondtokill.mapper;

import org.apache.ibatis.annotations.Param;
import website.okunoda.secondtokill.pojo.SeckillOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author okunoda
 * @since 2023-07-18
 */
public interface SeckillOrderMapper extends BaseMapper<SeckillOrder> {

    SeckillOrder queryOrderByGoodsIdAndUserId(Long goodsId, Long userId);

    Integer insertSeckillOrder(@Param("order") SeckillOrder seckillOrder);
}
