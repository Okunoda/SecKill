package website.okunoda.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author Okunoda
 * @date 2023年03月11日17:16
 */
public class Md5Utils {

    /**
     * md5 加密
     * @param str
     * @return
     */
    public static String md5(String str){
        return DigestUtils.md5Hex(str);
    }

    private  static final String salt = "123abc!@#";

    /**
     * 与前端加密通信时使用的方法
     * @param inputPass
     * @return
     */
    public static String inputPassToFromPass(String inputPass){
        //随机取密钥的位数，进一步提高加密性
        String str = ""+salt.charAt(0) + salt.charAt(3) + inputPass + salt.charAt(5) + salt.charAt(7);
        return md5(str);
    }

    /**
     * 二次加密，真正存储到数据库中的密码
     * @param fromPass
     * @param salt  随机生成的盐
     * @return
     */
    public static String fromPassToDBPass(String fromPass , String salt){
        String str = ""+salt.charAt(0) + salt.charAt(3) + fromPass + salt.charAt(5) + salt.charAt(7);
        return md5(fromPass);
    }

    /**
     * 后端真正调用的二次加密接口
     * @param inputPass
     * @param salt 随机盐
     * @return
     */
    public static String inputPassToDBPass(String inputPass , String salt){
        String fromPass = inputPassToFromPass(inputPass);
        return fromPassToDBPass(fromPass,salt);
    }

    public static void main(String[] args) {
        System.out.println(inputPassToDBPass("123123", "12345678"));
    }

}
