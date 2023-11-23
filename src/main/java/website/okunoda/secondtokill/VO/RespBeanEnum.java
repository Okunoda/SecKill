package website.okunoda.secondtokill.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.ConstraintViolation;

@AllArgsConstructor
@ToString
@Getter
public enum RespBeanEnum {
    /*
    通用结果返回
     */
    SUCCESS(200, "成功"),
    ERROR(500, "服务器异常"),

    /*
    参数校验结果
     */
    LOGIN_INFO_ERROR(500201, "用户名或密码错误"),
    MOBILE_ERROR(500202, "未找到该用户！"),
    BIND_ERROR(500203, "参数校验错误！"),

    EMPTY_STOCK(500301, "商品库存不足"),
    REPEAT_ORDER(500302, "每人限购该商品一件");

    private final Integer code;
    private final String msg;
}
