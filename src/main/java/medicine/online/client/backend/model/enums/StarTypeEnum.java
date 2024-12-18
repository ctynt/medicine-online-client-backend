package medicine.online.client.backend.model.enums;

public enum StarTypeEnum {
    SPECIAL(0, "special"),    // 专题
    ARTICLE(1, "article"),    // 资讯
    VIDEO(2, "video");        // 视频课程

    private final Integer code;
    private final String type;

    StarTypeEnum(Integer code, String type) {
        this.code = code;
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public static Integer getCodeByType(String type) {
        for (StarTypeEnum starType : StarTypeEnum.values()) {
            if (starType.getType().equalsIgnoreCase(type)) {
                return starType.getCode();
            }
        }
        return null;
    }
} 