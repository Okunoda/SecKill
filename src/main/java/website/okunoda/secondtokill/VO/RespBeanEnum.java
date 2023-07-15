package website.okunoda.secondtokill.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public enum RespBeanEnum {
    /*
    通用结果返回
     */
    SUCCESS(200,"成功"),
    ERROR(500,"服务器异常"),

    LOGIN_INFO_ERROR(500201,"用户名或密码错误"),
    MOBILE_ERROR(500202,"未找到该用户！")
    ;

    private final Integer code;
    private final String msg;
}
