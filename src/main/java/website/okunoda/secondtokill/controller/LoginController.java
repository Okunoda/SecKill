package website.okunoda.secondtokill.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import website.okunoda.secondtokill.VO.LoginVO;
import website.okunoda.secondtokill.VO.RespBean;
import website.okunoda.secondtokill.service.IUserService;

import javax.annotation.Resource;
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
    public RespBean doLogin(@Valid LoginVO model) {
        log.info("{}", model);
        return userService.doLogin(model);
    }
}
