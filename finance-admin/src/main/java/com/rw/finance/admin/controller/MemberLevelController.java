package com.rw.finance.admin.controller;

import com.rw.finance.admin.annotation.AgentInfoAuthor;
import com.rw.finance.admin.service.MemberLevelService;
import com.rw.finance.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员等级控制
 */
@RestController
@RequestMapping(value = "/memberlevel")
public class MemberLevelController {
    @Autowired
    private MemberLevelService memberLevelService;

    /**
     * 取得等级列表
     *
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/getlevels")
    public Result getLevels() {
        return new Result(200, "", memberLevelService.getMemberLevels());
    }
}
