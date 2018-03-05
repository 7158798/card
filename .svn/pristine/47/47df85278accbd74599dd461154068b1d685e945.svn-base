package com.rw.finance.admin.controller;

import com.rw.finance.admin.annotation.AgentInfoAuthor;
import com.rw.finance.admin.model.PowerResourceModel;
import com.rw.finance.admin.service.PowerService;
import com.rw.finance.common.entity.PowerLevel;
import com.rw.finance.common.entity.PowerResource;
import com.rw.finance.common.entity.PowerResourceLevel;
import com.rw.finance.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限控制
 */
@RestController
@RequestMapping(value = "/power")
public class PowerController {
    @Autowired
    private PowerService powerService;

    //region 资源相关

    /**
     * 取得资源信息
     *
     * @param id
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/getresource")
    public Result getResource(@RequestParam(name = "id", required = true) long id, @RequestParam(name = "loop",
            defaultValue = "false") boolean loop) {
        PowerResourceModel model = this.powerService.getResource(id, loop);
        return new Result(200, null, model);
    }

    /**
     * 取得资源列表
     *
     * @param parentid
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/getresources")
    public Result getResources(@RequestParam(name = "parentid", required = true) long parentid, @RequestParam(name =
            "loop", defaultValue = "false") boolean loop) {
        List<PowerResourceModel> list = this.powerService.getResources(parentid, loop, null);
        return new Result(200, null, list);
    }

    /**
     * 保存资源
     *
     * @param model
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/saveresource")
    public Result saveResource(PowerResource model) {
        //region 参数判断

        if (model.getResourcename() == null || model.getResourcename().length() <= 0) {
            return new Result(202, "资源名称为必输项", null);
        }

        if (model.getResourceurl() == null || model.getResourceurl().length() <= 0) {
            return new Result(202, "资源地址为必输项", null);
        }

        //endregion

        // 提交处理
        try {
            this.powerService.saveResource(model);
        } catch (Exception ex) {
            return new Result(500, "服务器发生异常", null);
        }

        return new Result(200, "保存成功", null);
    }

    /**
     * 删除资源
     *
     * @param id
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/delresource")
    public Result delResource(@RequestParam(name = "id", required = true) long id) {
        try {
            this.powerService.delResource(id);
        } catch (Exception ex) {
            return new Result(500, "服务器发生异常", null);
        }

        return new Result(200, "删除成功", null);
    }

    //endregion

    //region 权限等级

    /**
     * 取得等级信息
     *
     * @param id
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/getlevel")
    public Result getLevel(@RequestParam(name = "id", required = true) int id) {
        PowerLevel model = this.powerService.getLevel(id);
        return new Result(200, null, model);
    }

    /**
     * 取得等级列表
     *
     * @param levelobject
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/getlevels")
    public Result getLevels(@RequestParam(name = "levelobject", required = true) int levelobject) {
        List<PowerLevel> list = this.powerService.getLevels(levelobject);
        return new Result(200, null, list);
    }

    /**
     * 保存权限等级
     *
     * @param model
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/savelevel")
    public Result saveLevel(PowerLevel model) {
        //region 参数判断

        if (model.getLevelname() == null || model.getLevelname().length() <= 0) {
            return new Result(202, "等级名称为必输项", null);
        }

        //endregion

        // 提交处理
        try {
            this.powerService.saveLevel(model);
        } catch (Exception ex) {
            return new Result(500, "服务器发生异常", null);
        }

        return new Result(200, "保存成功", null);
    }

    /**
     * 删除权限等级
     *
     * @param id
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/dellevel")
    public Result delLevel(@RequestParam(name = "id", required = true) Long id) {
        Result result = null;
        try {
            result = this.powerService.delLevel(id);
            if (result.getCode() != 200) {
                return result;
            }
        } catch (Exception ex) {
            return new Result(500, "服务器发生异常", null);
        }

        return result;
    }

    //endregion

    //region 权限分配

    /**
     * 取得分配权限
     *
     * @param levelid
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/getpower")
    public Result getPower(@RequestParam(name = "levelid", required = true) long levelid) {
        List<PowerResourceModel> list = this.powerService.getResourceLevels(levelid);
        return new Result(200, null, list);
    }

    /**
     * 保存权限分配
     *
     * @param levelid
     * @param resourcesid
     * @return
     */
    @AgentInfoAuthor(level = 99)
    @PostMapping(value = "/savepower")
    public Result savePower(@RequestParam(name = "levelid", required = true) long levelid, @RequestParam(name =
            "resourcesid", required = true) String resourcesid) {
        if (levelid <= 0) {
            return new Result(202, "等级编号不能为空", null);
        }

        if (resourcesid == null || resourcesid.isEmpty()) {
            return new Result(202, "权限编号不能为空", null);
        }

        String[] resources = resourcesid.split(",");
        if (resources == null || resources.length <= 0) {
            return new Result(202, "权限编号不能为空", null);
        }

        // 处理数据
        List<PowerResourceLevel> list = new ArrayList<PowerResourceLevel>();
        for (String item : resources) {
            PowerResourceLevel model = new PowerResourceLevel();
            model.setLevelid(levelid);
            model.setResourcesid(Long.valueOf(item));
            list.add(model);
        }

        // 提交处理
        try {
            this.powerService.saveResourceLevel(list);
        } catch (Exception ex) {
            return new Result(500, "服务器发生异常", null);
        }

        return new Result(200, "保存成功", null);
    }

    //endregion
}
