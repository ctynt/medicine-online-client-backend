package medicine.online.client.backend.common.cache;

public class RedisKeys {
    public static String getSmsKey(String phone) {
        return "sms:captcha:" + phone;
    }

    public static String getAccessTokenKey(String accessToken) {
        return "sys:access:token:" + accessToken;
    }

    public static String getUserIdKey(Integer id) {
        return "sys:userId:" + id;
    }
    
     /**
     * 获取考试用户试卷ID的Redis key
     */
    public static String getQuizUserPaperId(Integer id) {
        return "quizUserPaperId:" + id;
    }
    
    /**
     * 获取用户答题记录的Redis key
     */
    public static String getQuizUserDetail(String detail) {
        return "quizUserDetail:" + detail;
    }
}
