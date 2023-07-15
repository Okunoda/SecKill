package website.okunoda.secondtokill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import website.okunoda.secondtokill.VO.LoginVO;
import website.okunoda.secondtokill.VO.RespBean;
import website.okunoda.secondtokill.pojo.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author okunoda
 * @since 2023-07-14
 */
public interface IUserService extends IService<User> {

    RespBean doLogin(LoginVO model);

}