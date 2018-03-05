package com.rw.finance.admin.controller;

import com.rw.finance.admin.annotation.AgentInfoAuthor;
import com.rw.finance.admin.model.ActvcodeInfoQueryModel;
import com.rw.finance.admin.service.ActvcodeInfoService;
import com.rw.finance.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 激活码控制
 */
@RestController
@RequestMapping(value = "/actvcode")
public class ActvcodeInfoController {
    @Autowired
    private ActvcodeInfoService actvcodeInfoService;

    /**
     * 查询激活码列表
     *
     * @param query
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/getcodes")
    public Result<Object> getCodes(ActvcodeInfoQueryModel query) {
        return new Result(200, null, actvcodeInfoService.getActvcodes(query));
    }

    /**
     * 生成激活码
     *
     * @param agentid
     * @param count
     * @param issale
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/saveactvcode")
    public Result saveActvcode(@RequestParam(value = "agentid", required = true) Long agentid, @RequestParam(value =
            "count", required = true) Integer count, @RequestParam(value =
            "level", required = true) Integer level, @RequestParam(value = "issale", required = true) Integer issale,
                               @RequestParam(value = "price", required = true) Double price) {
        if (agentid == null || agentid <= 0) {
            return new Result<Object>(202, "代理编号不能为空", null);
        }

        if (count == null || count <= 0) {
            return new Result<Object>(202, "生成个数必须大于0", null);
        }

        if (issale == null) {
            return new Result<Object>(202, "销售状态必须选择", null);
        }

        Result result = actvcodeInfoService.saveActvcode(agentid, count, level, issale, price);
        return result;
    }

    /**
     * 下放激活码
     *
     * @param agentid
     * @param toid
     * @param count
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/grantactvcode")
    public Result grantActvcode(@RequestAttribute(value = "agentid", required = true) long agentid, @RequestParam(value
            = "toid", required = true) long toid, @RequestParam(value = "count", required = true) int count) {
        if (toid <= 0) {
            return new Result<Object>(202, "目标代理不能为空", null);
        }

        if (count <= 0) {
            return new Result<Object>(202, "下放个数必须大于0", null);
        }

        Result result = actvcodeInfoService.grantActvcode(agentid, toid, count);
        return result;
    }

    /**
     * 修改使用状态
     *
     * @param activeid
     * @param status
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/updateusestatus")
    public Result updateUseStatus(@RequestParam(value = "activeid", required = true) String activeid, @RequestParam
            (value = "status", required = true) Integer status) {
        if (activeid == null || activeid.length() <= 0) {
            return new Result(202, "激活码编号为必输项", null);
        }

        // 处理编号
        List<Long> listId = new ArrayList();
        for (String item : activeid.split(",")) {
            listId.add(Long.parseLong(item));
        }

        // 提交处理
        try {
            this.actvcodeInfoService.updateUseStatus(listId, status);
        } catch (Exception ex) {
            return new Result(500, "服务器发生异常", null);
        }

        return new Result(200, "修改成功", null);
    }

    /**
     * 修改销售状态
     *
     * @param activeid
     * @param status
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/updatesalestatus")
    public Result updateSaleStatus(@RequestParam(value = "activeid", required = true) String activeid, @RequestParam
            (value = "status", required = true) Integer status) {
        if (activeid == null || activeid.length() <= 0) {
            return new Result(202, "激活码编号为必输项", null);
        }

        // 处理编号
        List<Long> listId = new ArrayList();
        for (String item : activeid.split(",")) {
            listId.add(Long.parseLong(item));
        }

        // 提交处理
        try {
            this.actvcodeInfoService.updateSaleStatus(listId, status);
        } catch (Exception ex) {
            return new Result(500, "服务器发生异常", null);
        }

        return new Result(200, "修改成功", null);
    }

    /**
     * 取得激活码统计
     *
     * @param agentid
     * @param start
     * @param end
     * @return
     */
    @PostMapping(value = "/getactvcodecount")
    @AgentInfoAuthor(level = 99)
    public Result getActvcodeCount(@RequestAttribute(value = "agentid", required = true) Long agentid, @RequestParam
            (value = "start", required = true) String start, @RequestParam(value = "end", required = true) String end) {
        return new Result(200, null, this.actvcodeInfoService.getActvcodeCount(agentid, start, end));
    }
}
