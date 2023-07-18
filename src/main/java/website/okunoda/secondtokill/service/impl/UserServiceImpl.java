package website.okunoda.secondtokill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import website.okunoda.secondtokill.VO.LoginVO;
import website.okunoda.secondtokill.VO.RespBean;
import website.okunoda.secondtokill.VO.RespBeanEnum;
import website.okunoda.secondtokill.exception.GlobalException;
import website.okunoda.secondtokill.mapper.UserMapper;
import website.okunoda.secondtokill.pojo.User;
import website.okunoda.secondtokill.service.IUserService;
import website.okunoda.secondtokill.utils.CookieUtil;
import website.okunoda.secondtokill.utils.Md5Utils;
import website.okunoda.secondtokill.utils.UUIDUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 服务实现类
 *
 * @author okunoda
 * @since 2023-07-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public RespBean doLogin(LoginVO model, HttpServletRequest request, HttpServletResponse response) {
/*        //校验参数格式
        if (model.getMobile() == null || model.getPassword() == null) {
            return RespBean.error(RespBeanEnum.LOGIN_INFO_ERROR);
        }
        if (!ValidatorUtil.isMobile(model.getMobile())) {
            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
        }*/

        //查询是否存在该用户
        User user = userMapper.selectById(model.getMobile());
        if (user == null) {
//            return RespBean.error(RespBeanEnum.LOGIN_INFO_ERROR);
            throw new GlobalException(RespBeanEnum.LOGIN_INFO_ERROR);
        }
        //匹配密码
        String dbPass = Md5Utils.fromPassToDBPass(model.getPassword(), user.getSalt());
        if (!dbPass.equals(user.getPassword())) {
//            return RespBean.error(RespBeanEnum.LOGIN_INFO_ERROR);
            throw new GlobalException(RespBeanEnum.LOGIN_INFO_ERROR);
        }
        String ticket = UUIDUtil.uuid();
        //将用户信息存入 Redis 中
        redisTemplate.opsForValue().set("user-" + ticket, user);
//        request.getSession().setAttribute(ticket, user);
        CookieUtil.setCookie(request, response, "ticket", ticket);
        return RespBean.success();
    }

    @Override
    public User getUserByCookie(HttpServletRequest request, HttpServletResponse response, String ticket) {
        if (StringUtils.isEmpty(ticket)) {
            return null;
        }
        User user = (User) redisTemplate.opsForValue().get("user-" + ticket);
        if (user != null) {
            CookieUtil.setCookie(request, response, "ticket", ticket);
        }
        return user;
    }
}
