package website.okunoda.secondtokill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import website.okunoda.secondtokill.VO.LoginVO;
import website.okunoda.secondtokill.VO.RespBean;
import website.okunoda.secondtokill.VO.RespBeanEnum;
import website.okunoda.secondtokill.mapper.UserMapper;
import website.okunoda.secondtokill.pojo.User;
import website.okunoda.secondtokill.service.IUserService;
import website.okunoda.secondtokill.utils.Md5Utils;
import website.okunoda.secondtokill.utils.ValidatorUtil;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author okunoda
 * @since 2023-07-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public RespBean doLogin(LoginVO model) {
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
            return RespBean.error(RespBeanEnum.LOGIN_INFO_ERROR);
        }
        //匹配密码
        String dbPass = Md5Utils.fromPassToDBPass(model.getPassword(), user.getSalt());
        if (!dbPass.equals(user.getPassword())) {
            return RespBean.error(RespBeanEnum.LOGIN_INFO_ERROR);
        }
        return RespBean.success();
    }
}
