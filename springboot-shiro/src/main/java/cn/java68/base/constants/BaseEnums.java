package cn.java68.base.constants;

import cn.java68.base.enums.BaseEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 基础枚举值
 *
 */
public enum BaseEnums implements BaseEnum<String, String> {

    //登录系列
    NOT_USER("500","用户名或密码为空"),
    LOGIN_FAIL("500","用户名或密码错误"),
    LOGIN_SUCCESS("200","登录成功"),

    SUCCESS("request.success", "请求成功"),

    FAILURE("request.failure", "请求失败"),

    OPERATION_SUCCESS("operation.success", "操作成功"),

    OPERATION_FAILURE("operation.failure", "操作失败"),

    ERROR("system.error", "系统异常"),

    NOT_FOUND("not_found", "请求资源不存在"),

    FORBIDDEN("forbidden", "无权限访问"),

    VERSION_NOT_MATCH("record_not_exists_or_version_not_match", "记录版本不存在或不匹配"),

    USER_LOGIN_FAIL("USER_LOGIN_FAIL", "用户名或密码错误"),

    PARAMETER_NOT_NULL("parameter_not_be_null", "参数不能为空");

    private String code;

    private String desc;

    private static Map<String, String> allMap = new HashMap<>();

    BaseEnums(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    static {
        for(BaseEnums enums : BaseEnums.values()){
            allMap.put(enums.code, enums.desc);
        }
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String desc() {
        return desc;
    }

    public String desc(String code) {
        return allMap.get(code);
    }

}
