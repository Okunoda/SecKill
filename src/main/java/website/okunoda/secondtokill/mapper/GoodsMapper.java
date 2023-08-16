package website.okunoda.secondtokill.mapper;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
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
@Component("goodsMapper")
public interface GoodsMapper extends BaseMapper<Goods> {

    List<GoodsVo> queryAllGoodsVo();

    Goods queryById(Long id);

    GoodsVo queryGoodsVoById(Long id);
}
