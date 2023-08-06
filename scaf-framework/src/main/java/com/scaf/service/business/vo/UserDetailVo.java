package com.scaf.service.business.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.scaf.domain.entity.User;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel("user detail返回结果")
public class UserDetailVo {
    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("phone_number")
    private Integer phoneNumber;

    @JsonProperty("mail")
    private String mail;

    public static UserDetailVo convert(User user) {
        UserDetailVo userDetailVo = new UserDetailVo();
        userDetailVo.setUserName(user.getUserName());
        userDetailVo.setUserId(user.getUserId());
        userDetailVo.setPhoneNumber(user.getPhoneNumber());
        userDetailVo.setMail(user.getMail());
        return userDetailVo;
    }
}
