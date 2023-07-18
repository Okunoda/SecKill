package website.okunoda.secondtokill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;
import website.okunoda.secondtokill.pojo.User;
import website.okunoda.secondtokill.service.IUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    IUserService userService;

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
        return "goodsList";
    }
}
