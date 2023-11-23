package website.okunoda.secondtokill.VO;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import website.okunoda.secondtokill.validator.IsMobile;


/**
 * 登录 VO
 *
 * @author okunoda
 */
@Data
public class LoginVO {
    @NotNull
    @IsMobile
    private String mobile;

    @NotNull
    @Length(max = 32)
    private String password;
}
