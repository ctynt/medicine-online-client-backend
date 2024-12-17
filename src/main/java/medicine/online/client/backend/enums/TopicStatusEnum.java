package medicine.online.client.backend.enums;

import lombok.Getter;

/**
 * @author: orange
 * @projectName: medicine-online-client-backend
 * @description:
 */
@Getter
public enum TopicStatusEnum {
    YES(1, "已回答"),
    NO(0, "未回答");

    private final Integer status;
    private final String desc;

    TopicStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static String getDescription(int code) {
        for (TopicStatusEnum s : TopicStatusEnum.values()) {
            if (s.getStatus() == code) {
                return s.getDesc();
            }
        }
        return null;
    }
}
