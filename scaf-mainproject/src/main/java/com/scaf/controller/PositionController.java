package com.scaf.controller;



import com.scaf.domain.entity.User;
import com.scaf.service.UserService;
import com.scaf.service.business.vo.UserVo;
import com.scaf.service.exception.UserException;
import com.scaf.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/position")

public class PositionController {
    @PostMapping("/modifyMoney")
    public boolean modifyMoney() {

        return true;
    }

}
