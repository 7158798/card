package com.rw.finance.admin.controller;

import com.rw.finance.admin.annotation.AgentInfoAuthor;
import com.rw.finance.admin.model.AgentDetailModel;
import com.rw.finance.admin.model.AgentInfoModel;
import com.rw.finance.admin.model.AgentInfoQueryModel;
import com.rw.finance.admin.model.AgentLoginModel;
import com.rw.finance.admin.service.AgentCardService;
import com.rw.finance.admin.service.AgentInfoService;
import com.rw.finance.admin.service.PowerService;
import com.rw.finance.common.entity.AgentCard;
import com.rw.finance.common.entity.AgentInfo;
import com.rw.finance.common.utils.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 代理相关
 *
 * @author huanghongfei
 * @file AgentInfoController.java
 * @date 2017年12月9日 下午6:34:34
 * @declaration
 */
@RestController
@RequestMapping(value = "/agent")
public class AgentInfoController {
    @Autowired
    private AgentInfoService agentInfoService;

    @Autowired
    private AgentCardService agentCardService;

    @Autowired
    private PowerService powerService;

    //region 代理信息

    /**
     * 代理登录
     *
     * @param username 登录用户名
     * @param password 登录密码
     * @return jwt
     */
    @PostMapping(value = "/login")
    public Result<Object> login(@RequestParam(value = "username", required = true) String username,
                                @RequestParam(value = "password", required = true) String password) {
        String jwt = agentInfoService.login(username, password);
        if (StringUtils.isEmpty(jwt)) {
            return new Result<Object>(501, "用户名或密码错误", null);
        }

        return new Result<Object>(200, null, jwt);
    }

    /**
     * 取得登录信息
     *
     * @param agentid
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "getlogininfo")
    public Result getLoginInfo(@RequestAttribute(value = "agentid", required = true) Long agentid) {
        // 登录信息
        AgentLoginModel model = new AgentLoginModel();

        // 代理信息
        AgentInfoModel info = agentInfoService.getAgentInfo(agentid);
        if (info == null) {
            return new Result(202, "登录信息不存在", null);
        }

        BeanUtils.copyProperties(info, model);
        model.setMenues(powerService.getResourceLevels(model.getPowerlevel()));
        return new Result(200, null, model);
    }

    /**
     * 查询代理编号
     *
     * @param username
     * @param mobile
     * @param isagent
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "getagentid")
    public Result getAgentId(@RequestParam(value = "username", required = true) String username, @RequestParam(value =
            "mobile", required = true) String mobile, @RequestParam(value = "isagent", required = true) Boolean
                                     isagent) {
        return new Result(200, null, this.agentInfoService.getAgentId(username, mobile, isagent));
    }

    /**
     * 获取代理信息
     *
     * @param agentid
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/getagentinfo")
    public Result getAgentInfo(@RequestParam(value = "agentid", required = true) Long agentid) {
        AgentInfoModel agentInfo = this.agentInfoService.getAgentInfo(agentid);
        return new Result(200, null, agentInfo);
    }

    /**
     * 获取代理明细
     *
     * @param agentid
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/getagentdetail")
    public Result getAgentDetail(@RequestParam(value = "agentid", required = true) Long agentid) {
        AgentDetailModel data = agentInfoService.getAgentDetail(agentid);
        return new Result(200, null, data);
    }

    /**
     * 获取代理列表
     *
     * @param query
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/getagentinfos")
    public Result getAgentInfos(AgentInfoQueryModel query) {
        Page<AgentInfo> data = agentInfoService.getAgentInfos(query);
        return new Result(200, null, data);
    }

    /**
     * 保存代理信息
     *
     * @param model
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/saveagentinfo")
    public Result saveAgentInfo(@RequestAttribute(value = "agentid", required = true) Long agentid, AgentInfoModel
            model) {
        //region 参数判断

        if (model.getUsername() == null || model.getUsername().length() <= 0) {
            return new Result(202, "账号为必输项", null);
        }

        if (model.getPassword() == null || model.getPassword().length() <= 0) {
            return new Result(202, "登录密码为必输项", null);
        }

        if (model.getAgentlevel() > 0 && (model.getAgentname() == null || model.getAgentname().length() <= 0)) {
            return new Result(202, "代理名称为必输项", null);
        }

        if (model.getLinkman() == null || model.getLinkman().length() <= 0) {
            return new Result(202, "联系人名为必输项", null);
        }

        if (model.getMobile() == null || model.getMobile().length() <= 0) {
            return new Result(202, "联系电话为必输项", null);
        }

        if (model.getTypeid() == null || model.getTypeid() <= 0) {
            return new Result(202, "代理类型为必输项", null);
        }

        if (model.getRepaysharerate() > 0 && model.getRepaysharerate() <= 0) {
            return new Result(202, "代还分润费率必须大于0", null);
        }

        if (model.getBorrowsharerate() > 0 && model.getBorrowsharerate() <= 0) {
            return new Result(202, "收款分润费率必须大于0", null);
        }

        if (model.getActivatesharerate() > 0 && model.getActivatesharerate() <= 0) {
            return new Result(202, "激活分润费率必须大于0", null);
        }

        //endregion

        // 提交处理
        try {
            Result result = this.agentInfoService.saveAgentInfo(agentid, model);
            if (result.getCode() != 200) {
                return result;
            }
        } catch (Exception ex) {
            return new Result(500, "服务器发生异常", null);
        }

        return new Result(200, "保存成功", null);
    }

    /**
     * 修改登录密码
     *
     * @param agentid
     * @param newpwd
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/updateloginpwd")
    public Result updateLoginPwd(@RequestParam(value = "agentid", required = true) Long agentid, @RequestParam(value =
            "newpwd", required = true) String newpwd) {
        if (agentid <= 0) {
            return new Result(202, "代理编号为必输项", null);
        }

        if (newpwd == null || newpwd.length() <= 0) {
            return new Result(202, "新密码为必输项", null);
        }

        // 提交处理
        try {
            Result result = this.agentInfoService.updateLoginPwd(agentid, newpwd);
            if (result.getCode() != 200) {
                return result;
            }
        } catch (Exception ex) {
            return new Result(500, "服务器发生异常", null);
        }

        return new Result(200, "修改成功", null);
    }

    /**
     * 修改交易密码
     *
     * @param agentid
     * @param newpwd
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/updatepaypwd")
    public Result updatePayPwd(@RequestParam(value = "agentid", required = true) Long agentid, @RequestParam(value =
            "newpwd", required = true) String newpwd) {
        if (agentid <= 0) {
            return new Result(202, "代理编号为必输项", null);
        }

        if (newpwd == null || newpwd.length() <= 0) {
            return new Result(202, "新密码为必输项", null);
        }

        // 提交处理
        try {
            Result result = this.agentInfoService.updatePayPwd(agentid, newpwd);
            if (result.getCode() != 200) {
                return result;
            }
        } catch (Exception ex) {
            return new Result(500, "服务器发生异常", null);
        }

        return new Result(200, "修改成功", null);
    }

    /**
     * 修改代理状态
     *
     * @param agentid
     * @param status
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/updatestatus")
    public Result updateStatus(@RequestParam(value = "agentid", required = true) String agentid, @RequestParam(value =
            "status", required = true) Integer status) {
        if (agentid == null || agentid.length() <= 0) {
            return new Result(202, "代理编号为必输项", null);
        }

        // 处理编号
        List<Long> listId = new ArrayList();
        for (String item : agentid.split(",")) {
            listId.add(Long.parseLong(item));
        }

        // 提交处理
        try {
            Result result = this.agentInfoService.updateStatus(listId, status);
            if (result.getCode() != 200) {
                return result;
            }
        } catch (Exception ex) {
            return new Result(500, "服务器发生异常", null);
        }

        return new Result(200, "修改成功", null);
    }

    /**
     * 修改用户费率
     *
     * @param agentid
     * @param rate
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/updateuserrate")
    public Result updateUserRate(@RequestParam(value = "agentid", required = true) Long agentid, @RequestParam(value =
            "rate", required = true) Double rate) {
        if (agentid <= 0) {
            return new Result(202, "代理编号为必输项", null);
        }

        if (rate <= 0) {
            return new Result(202, "用户费率为必输项", null);
        }

        // 提交处理
        try {
            Result result = this.agentInfoService.updateUserRate(agentid, rate);
            if (result.getCode() != 200) {
                return result;
            }
        } catch (Exception ex) {
            return new Result(500, "服务器发生异常", null);
        }

        return new Result(200, "修改成功", null);
    }

    /**
     * 删除代理信息
     *
     * @param agentid
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/delagentinfo")
    public Result delAgentInfo(@RequestParam(name = "agentid", required = true) Long agentid) {
        Result result = null;
        try {
            result = this.agentInfoService.deleteAgentInfo(agentid);
            if (result.getCode() != 200) {
                return result;
            }
        } catch (Exception ex) {
            return new Result(500, "服务器发生异常", null);
        }

        return result;
    }

    //endregion

    // region 代理卡片

    /**
     * 获取卡片信息
     *
     * @param cardid
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/getagentcard")
    public Result getAgentCard(@RequestParam(value = "cardid", required = true) Long cardid) {
        AgentCard agentCard = agentCardService.getAgentCard(cardid);
        return new Result(200, null, agentCard);
    }

    /**
     * 获取卡片列表
     *
     * @param agentid
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/getagentcards")
    public Result<Object> getAgentCards(@RequestParam(value = "agentid", required = true) Long agentid) {
        List<AgentCard> list = agentCardService.getAgentCards(agentid);
        return new Result(200, null, list);
    }

    /**
     * 保存代理卡片
     *
     * @param model
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/saveagentcard")
    public Result saveAgentCard(AgentCard model) {
        //region 参数判断

        if (model.getCardno() == null || model.getCardno().length() <= 0) {
            return new Result(202, "银行卡号为必输项", null);
        }

        if (model.getCardholder() == null || model.getCardholder().length() <= 0) {
            return new Result(202, "持卡人为必输项", null);
        }

        if (model.getMobile() == null || model.getMobile().length() <= 0) {
            return new Result(202, "预留手机号为必输项", null);
        }

        if (model.getBankid() <= 0) {
            return new Result(202, "银行编号为必输项", null);
        }

        if (model.getBankname() == null || model.getBankname().length() <= 0) {
            return new Result(202, "开户银行为必输项", null);
        }

        if (model.getAgentid() <= 0) {
            return new Result(202, "代理编号为必输项", null);
        }

        //endregion

        // 提交处理
        try {
            Result result = this.agentCardService.saveAgentCard(model);
            if (result.getCode() != 200) {
                return result;
            }
        } catch (Exception ex) {
            return new Result(500, "服务器发生异常", null);
        }

        return new Result(200, "保存成功", null);
    }

    /**
     * 删除代理卡片
     *
     * @param cardid
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/delagentcard")
    public Result delAgentCard(@RequestParam(name = "cardid", required = true) Long cardid) {
        try {
            this.agentCardService.delAgentCard(cardid);
        } catch (Exception ex) {
            return new Result(500, "服务器发生异常", null);
        }

        return new Result(200, "删除成功", null);
    }

    // endregion

    /**
     * 取得代理统计
     *
     * @param agentid
     * @param start
     * @param end
     * @return
     */
    @PostMapping(value = "/getagentcount")
    @AgentInfoAuthor(level = 99)
    public Result getAgentCount(@RequestAttribute(value = "agentid", required = true) Long agentid, @RequestParam
            (value = "start", required = true) String start, @RequestParam(value = "end", required = true) String end) {
        return new Result(200, null, this.agentInfoService.getAgentCount(agentid, start, end));
    }
}
