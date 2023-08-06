package com.scaf.service.business.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.scaf.domain.entity.User;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@ApiModel("user 返回结果")
@Data
public class UserVo {
    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("phone_number")
    private Integer phoneNumber;

    public static UserVo convert(User user) {
        UserVo userVo = new UserVo();
        userVo.setUserName(user.getUserName());
        userVo.setUserId(user.getUserId());
        userVo.setPhoneNumber(user.getPhoneNumber());
        return userVo;
    }
}
