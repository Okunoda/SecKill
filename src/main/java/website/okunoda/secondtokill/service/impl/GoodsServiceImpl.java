package website.okunoda.secondtokill.service.impl;

import website.okunoda.secondtokill.VO.GoodsVo;
import website.okunoda.secondtokill.pojo.Goods;
import website.okunoda.secondtokill.mapper.GoodsMapper;
import website.okunoda.secondtokill.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author okunoda
 * @since 2023-07-18
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Resource
    private GoodsMapper mapper;

    @Override
    public List<GoodsVo> queryAllGoodsVo() {
        return mapper.queryAllGoodsVo();
    }
}
