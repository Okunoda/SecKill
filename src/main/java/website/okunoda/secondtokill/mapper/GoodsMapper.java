package website.okunoda.secondtokill.mapper;

import website.okunoda.secondtokill.VO.GoodsVo;
import website.okunoda.secondtokill.pojo.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author okunoda
 * @since 2023-07-18
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    List<GoodsVo> queryAllGoodsVo();
}
