package website.okunoda.secondtokill.config;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.thymeleaf.util.StringUtils;
import website.okunoda.secondtokill.pojo.User;
import website.okunoda.secondtokill.service.IUserService;
import website.okunoda.secondtokill.utils.CookieUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    @Resource
    private IUserService userService;

    /**
     * 判断此次操作是否需要需要处理
     *
     * @param parameter the method parameter to check
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> clazz = parameter.getClass();
        return clazz == User.class;
    }

    /**
     * 如果需要处理参数则在本方法中进行处理
     *
     * @param parameter     the method parameter to resolve. This parameter must
     *                      have previously been passed to {@link #supportsParameter} which must
     *                      have returned {@code true}.
     * @param mavContainer  the ModelAndViewContainer for the current request
     * @param webRequest    the current request
     * @param binderFactory a factory for creating {@link WebDataBinder} instances
     * @return
     * @throws Exception
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);

        //获取用户 ticket
        String ticket = CookieUtil.getCookieValue(request, "ticket");

        if (StringUtils.isEmpty(ticket)) {
            return "login";
        }

        //获取 redis 中的对象信息
        return userService.getUserByCookie(request, response, ticket);
    }
}
