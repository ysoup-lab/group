package cn.bugstack.types.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 回调任务状态
 * @create 2025-01-31 13:44
 */
@Getter
public enum NotifyTaskHTTPEnumVO {

    SUCCESS("success", "成功"),
    ERROR("error", "失败"),
    NULL(null, "空执行"),
    ;

    private final String code;
    private final String info;

    NotifyTaskHTTPEnumVO(String code, String info) {
        this.code = code;
        this.info = info;
    }

}
