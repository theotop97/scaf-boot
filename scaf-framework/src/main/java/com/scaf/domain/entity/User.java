package com.scaf.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2023-04-09 00:34:57
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户实体类")
@TableName("user")
public class User implements Serializable {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("用户id")
    private Integer userId;
    @ApiModelProperty("用户电话")
    private Integer phoneNumber;
    @ApiModelProperty("用户邮箱")
    private String mail;


}