package medicine.online.client.backend.common.constant;

public interface Constant {
    //    创建时间
    String CREATE_TIME = "createTime";
    //    更新时间
    String UPDATE_TIME = "updateTime";
    //   逻辑删除
    String DELETE_FLAG = "deleteFlag";

    //    用户id
    String USER_ID = "userId";

    // 微信小程序 appId
    String APP_ID = "wxde650a3ec541717a";
    //  appsecret
    String APP_SECRET = "96322d512512ba272fc028c47111b6ff";
    // 微信返回参数中的属性名
    String WX_ERR_CODE = "errCode";
    // 返回参数中的属性名
    String WX_OPENID = "openid";
    //返回参数中的属性名
    String WX_SESSION_KEY = "session_key";
    //前端没有登录的时候会携带的token，后续会用到
    String NO_TOKEN = "no-token";
    Integer ROOT = 0;
}