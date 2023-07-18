package website.okunoda.secondtokill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;
import website.okunoda.secondtokill.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @RequestMapping("/toList")
    public String toList(HttpServletRequest request, Model model, @CookieValue("userTicket") String ticket) {

        if (StringUtils.isEmpty(ticket)) {
            return "login";
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(ticket);
        if (user == null) {
            return "login";
        }
        model.addAttribute("user", user);
        return "goodsList";
    }
}
