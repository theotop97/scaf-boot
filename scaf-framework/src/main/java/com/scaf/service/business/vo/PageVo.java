package com.scaf.service.business.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ApiModel("分页返回结果")
@Data
public class PageVo {
    private List rows;

    private Long total;
}
