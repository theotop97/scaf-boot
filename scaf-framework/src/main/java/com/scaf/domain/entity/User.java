package com.scaf.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("user")
public class User implements Serializable {
    
    private Integer id;
    
    private String userName;
    
    private Integer userId;
    
    private Integer phoneNumber;
    
    private String mail;


}