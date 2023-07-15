package website.okunoda.secondtokill.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import website.okunoda.secondtokill.VO.RespBeanEnum;


@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GlobalException extends RuntimeException {
    private RespBeanEnum respBeanEnum;

}
