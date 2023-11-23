package website.okunoda.secondtokill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import website.okunoda.secondtokill.VO.GoodsVo;
import website.okunoda.secondtokill.VO.RespBeanEnum;
import website.okunoda.secondtokill.pojo.Order;
import website.okunoda.secondtokill.pojo.SeckillOrder;
import website.okunoda.secondtokill.pojo.User;
import website.okunoda.secondtokill.service.IGoodsService;
import website.okunoda.secondtokill.service.ISeckillOrderService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @Resource
    private IGoodsService goodsService;

    @Resource
    private ISeckillOrderService seckillOrderService;

    @RequestMapping("doSeckill")
    public String doSeckill(User user, Model model, Long goodsId) {
        //拦截器 user 是空的话并没有缆接并跳转登录页面，而是返回的一个空的 user 对象，所以这里需要判断其是否为空对象
        if (user == null) {
            return "login";
        }
        model.addAttribute("user", user);
        //判断库存
        GoodsVo goodsVo = goodsService.queryGoodsVoById(goodsId);
        if (goodsVo.getStockCount() < 1) {
            model.addAttribute("errMsg", RespBeanEnum.EMPTY_STOCK.getMsg());
            return "seckillFail";
        }

        //判断是否重复抢购
        SeckillOrder repeatOrder = seckillOrderService.queryOrderByGoodsIdAndUserId(goodsVo.getId(), user.getId());
        if (repeatOrder != null) {
            model.addAttribute("errMsg", RespBeanEnum.REPEAT_ORDER.getMsg());
            return "seckillFail";
        }

        //秒杀订单生成
        Order order = seckillOrderService.doSeckill(goodsVo.getId(), user.getId());

        //页面跳转
        model.addAttribute("goods", goodsVo);
        model.addAttribute("order", order);
        return "orderDetail";
    }

}
