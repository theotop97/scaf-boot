package com.scaf.service.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("修改用户dto")
public class UpdateUserDto {

    @ApiModelProperty("要修改的userid")
    @JsonProperty("user_id")
    @NotNull(message = "userId不能为空")
    private Long userId;

    @ApiModelProperty("需要修改的username")
    @JsonProperty("user_name")
    private String userName;

    @ApiModelProperty("需要修改的phoneNumber")
    @JsonProperty("phone_number")
    private Integer phoneNumber;

    @ApiModelProperty("需要修改的mail")
    @JsonProperty("mail")
    private String mail;
}
