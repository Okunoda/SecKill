package website.okunoda.secondtokill.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespBean {
    private Integer code;
    private String message;
    private Object obj;

    /**
     * 成功结果返回类
     *
     * @return
     */
    public static RespBean success() {
        return new RespBean(RespBeanEnum.SUCCESS.getCode(), RespBeanEnum.SUCCESS.getMsg(), null);
    }

    /**
     * 成功结果返回类
     *
     * @param obj
     * @return
     */
    public static RespBean success(Object obj) {
        return new RespBean(RespBeanEnum.SUCCESS.getCode(), RespBeanEnum.SUCCESS.getMsg(), obj);
    }

    /**
     * 失败结果返回类
     *
     * @return
     */
    public static RespBean error(RespBeanEnum respBeanEnum) {
        return new RespBean(respBeanEnum.getCode(), respBeanEnum.getMsg(), null);
    }

    /**
     * 失败结果返回类
     *
     * @param obj
     * @return
     */
    public static RespBean error(RespBeanEnum respBeanEnum, Object obj) {
        return new RespBean(respBeanEnum.getCode(), respBeanEnum.getMsg(), obj);
    }
}
