package website.okunoda.secondtokill.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import website.okunoda.secondtokill.VO.LoginVO;
import website.okunoda.secondtokill.VO.RespBean;
import website.okunoda.secondtokill.service.IUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Resource
    private IUserService userService;

    @GetMapping("toLogin")
    public String toLogin(){
        return "login";
    }


    @PostMapping("doLogin")
    @ResponseBody
    public RespBean doLogin(@Valid LoginVO model, HttpServletRequest request, HttpServletResponse response) {
        log.info("{}", model);
        return userService.doLogin(model, request, response);
    }
}
