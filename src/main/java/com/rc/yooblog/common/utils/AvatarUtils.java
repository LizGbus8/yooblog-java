package com.rc.yooblog.common.utils;

/**
 * 作者：flandre on 2019/4/8 21:34
 * 描述：头像获取工具
 */
public class AvatarUtils {
    private static final String QQ_API = "http://q1.qlogo.cn/g?b=qq&nk=QQ&s=640";
    private static final String GRAVATAR_API = "http://www.gravatar.com/avatar/EMAILMD5?s=320";
    /**
     * 获取QQ头像
     * @param email
     * @return 如果为不是QQ邮箱或前缀不是QQ号码，返回null
     */
    public static String getQQAvatar(String email) {
        if (email.contains("@qq.com")) {
            //邮箱前缀
            String preMail = email.substring(0,email.lastIndexOf("@"));
            //邮箱前缀为QQ号码
            if (preMail.matches("[1-9][0-9]{4,14}")) {
                return QQ_API.replace("QQ", preMail);
            }
        }
        return null;
    }

    /**
     * 获取Gravatar头像
     * @param email
     * @return
     */
    public static String getGravatarAvatar(String email) {
        //1.获取MD5
        String emailMd5 = MD5Utils.getMD5(email);
        //2.拼接
        return GRAVATAR_API.replace("EMAILMD5", emailMd5);
    }

    public static void main(String[] args) {
        String test = "837422051@163.com";
        String qqAvatar = AvatarUtils.getGravatarAvatar(test);
        System.out.println(qqAvatar);
    }
}
