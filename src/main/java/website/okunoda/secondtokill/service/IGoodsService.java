package website.okunoda.secondtokill.service;

import website.okunoda.secondtokill.VO.GoodsVo;
import website.okunoda.secondtokill.pojo.Goods;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author okunoda
 * @since 2023-07-18
 */
public interface IGoodsService extends IService<Goods> {

    List<GoodsVo> queryAllGoodsVo();

    Goods queryById(Long id);

    GoodsVo queryGoodsVoById(Long id);
}
