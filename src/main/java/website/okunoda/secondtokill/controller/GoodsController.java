package website.okunoda.secondtokill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;
import website.okunoda.secondtokill.VO.GoodsVo;
import website.okunoda.secondtokill.VO.RespBean;
import website.okunoda.secondtokill.pojo.Goods;
import website.okunoda.secondtokill.pojo.User;
import website.okunoda.secondtokill.service.IGoodsService;
import website.okunoda.secondtokill.service.IUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private IUserService userService;

    @Resource
    private IGoodsService goodsService;

    @RequestMapping("/toList")
//    public String toList(HttpServletRequest request, HttpServletResponse response , Model model, @CookieValue("userTicket") String ticket) {
    public String toList(Model model, User user) {

//        if (StringUtils.isEmpty(ticket)) {
//            return "login";
//        }
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute(ticket);

        //获取 redis 中的对象信息
//        User user = userService.getUserByCookie(request, response, ticket);
//
//        if (user == null) {
//            return "login";
//        }
        model.addAttribute("user", user);
        model.addAttribute("goodsList", goodsService.queryAllGoodsVo());
        return "goodsList";
    }

    @GetMapping("toDetail/{id}")
    public String toDetail(@PathVariable Long id, Model model, User user) {
        model.addAttribute("user", user);
        //获取商品视图
        GoodsVo goods = goodsService.queryGoodsVoById(id);
        model.addAttribute("goods", goods);
        //判断秒杀时间是否开始
        Date now = new Date();
        //秒杀状态
        int secKillStatus = 0;
        if (now.before(goods.getStartDate())) {
            //秒杀还未开始
            long gap = goods.getStartDate().getTime() - now.getTime();
            //获取秒数
//            gap /= 1000L;
//            long second = gap % 60;
//            //获取分钟数
//            gap /= 60;
//            long min = gap % 60;
//            //获取小时数
//            gap /= 60;
//            long hour = gap% 24;
//            //获取天数
//            gap /= 24;
//            long day = gap;

            model.addAttribute("remainSeconds", gap / 1000L);
        } else if (now.after(goods.getEndDate())) {
            //秒杀已经结束
            secKillStatus = 2;
        } else {
            //秒杀进行中
            secKillStatus = 1;
        }
        model.addAttribute("secKillStatus", secKillStatus);


        return "goodsDetail";
    }
}
