package com.rw.finance.admin.service;

import com.rw.finance.admin.model.PowerResourceModel;
import com.rw.finance.common.entity.PowerLevel;
import com.rw.finance.common.entity.PowerResource;
import com.rw.finance.common.entity.PowerResourceLevel;
import com.rw.finance.common.utils.Result;

import java.util.List;

/**
 * 权限相关
 */
public interface PowerService {
    //region 资源相关

    /**
     * 取得资源
     *
     * @param rsrcid
     * @param loop
     * @return
     */
    PowerResourceModel getResource(long rsrcid, boolean loop);

    /**
     * 资源列表
     *
     * @param parentid
     * @param loop
     * @return
     */
    List<PowerResourceModel> getResources(long parentid, boolean loop, List<PowerResourceLevel> in);

    /**
     * 保存资源信息
     *
     * @param model
     * @return
     */
    void saveResource(PowerResource model);

    /**
     * 删除资源
     *
     * @param rsrcid
     */
    void delResource(long rsrcid);

    //endregion

    //region 权限等级

    /**
     * 取得等级
     *
     * @param levelid
     * @return
     */
    PowerLevel getLevel(long levelid);

    /**
     * 等级列表
     *
     * @param levelobject
     * @return
     */
    List<PowerLevel> getLevels(int levelobject);

    /**
     * 保存等级
     *
     * @param model
     * @return
     */
    void saveLevel(PowerLevel model);

    /**
     * 删除等级
     *
     * @param levelid
     */
    Result delLevel(Long levelid);

    //endregion

    //region 分配权限

    /**
     * 权限分配情况
     *
     * @param levelid
     * @return
     */
    List<PowerResourceModel> getResourceLevels(long levelid);

    /**
     * 保存权限分配
     *
     * @param list
     */
    void saveResourceLevel(List<PowerResourceLevel> list);

    //endregion
}
