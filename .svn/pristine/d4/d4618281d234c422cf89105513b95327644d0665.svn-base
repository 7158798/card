package com.rw.finance.admin.service.impl;

import com.rw.finance.admin.dao.AgentInfoDao;
import com.rw.finance.admin.dao.PowerLevelDao;
import com.rw.finance.admin.dao.PowerResourceDao;
import com.rw.finance.admin.dao.PowerResourceLevelDao;
import com.rw.finance.admin.model.PowerResourceModel;
import com.rw.finance.admin.service.PowerService;
import com.rw.finance.common.entity.PowerLevel;
import com.rw.finance.common.entity.PowerResource;
import com.rw.finance.common.entity.PowerResourceLevel;
import com.rw.finance.common.utils.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 权限相关
 */
@Service
public class PowerServiceImpl implements PowerService {
    //region 自动装配

    @Autowired
    private PowerResourceLevelDao powerResourceLevelDao;

    @Autowired
    private PowerResourceDao powerResourceDao;

    @Autowired
    private PowerLevelDao powerLevelDao;

    @Autowired
    private AgentInfoDao agentInfoDao;

    //endregion

    //region 资源管理

    @Override
    public PowerResourceModel getResource(long rsrcid, boolean loop) {
        // 返回对象
        PowerResourceModel model = new PowerResourceModel();

        // 反射处理
        BeanUtils.copyProperties(powerResourceDao.findOne(rsrcid), model);
        if (loop && model != null) {
            model.setSubResources(this.loopResources(powerResourceDao.findAll(), model.getResourceid(), null));
        }

        return model;
    }

    @Override
    public List<PowerResourceModel> getResources(long parentid, boolean loop, List<PowerResourceLevel> in) {
        // 处理反射
        List<PowerResourceModel> list = this.copyList(powerResourceDao.findByParentid(parentid));

        // 是否遍历
        if (loop && list != null && list.size() > 0) {
            // 所有资源
            List<PowerResource> all = powerResourceDao.findAll();
            for (PowerResourceModel item : list) {
                if (in != null && in.size() > 0) {
                    if (in.stream().filter((p) -> (p.getResourcesid() == item.getResourceid())).count() > 0) {
                        item.setSelected(true);
                    }
                }

                item.setSubResources(this.loopResources(all, item.getResourceid(), in));
            }
        }

        return list;
    }

    @Override
    public void saveResource(PowerResource model) {
        if (model.getType() == null) {
            model.setType(0);
        }

        powerResourceDao.save(model);
    }

    @Transactional
    @Override
    public void delResource(long rsrcid) {
        powerResourceDao.deleteAllByParentid(rsrcid);
        powerResourceDao.delete(rsrcid);
    }

    //endregion

    //region 权限等级

    @Override
    public PowerLevel getLevel(long levelid) {
        PowerLevel model = powerLevelDao.findOne(levelid);
        return model;
    }

    @Override
    public List<PowerLevel> getLevels(int levelobject) {
        if (levelobject == 99)
            return powerLevelDao.findAll();
        else
            return powerLevelDao.findByLevelobject(levelobject);
    }

    @Override
    public void saveLevel(PowerLevel model) {
        powerLevelDao.save(model);
    }

    @Override
    @Transactional
    public Result delLevel(Long levelid) {
        if (agentInfoDao.existsByPowerlevel(levelid)) {
            return new Result(202, "该等级下已经存在用户", null);
        }

        powerResourceLevelDao.deleteAllByLevelid(levelid);
        powerLevelDao.delete((long) levelid);
        return new Result(200, "删除成功", null);
    }

    //endregion

    //region 权限分配

    @Override
    public List<PowerResourceModel> getResourceLevels(long levelid) {
        // 分配资源
        List<PowerResourceLevel> listPower = this.powerResourceLevelDao.findAllByLevelid(levelid);

        // 所有资源
        List<PowerResourceModel> listResource = null;
        if (listPower == null || listPower.size() <= 0)
            listResource = this.getResources(0, true, null);
        else
            listResource = this.getResources(0, true, listPower);

        return listResource;
    }

    @Transactional
    @Override
    public void saveResourceLevel(List<PowerResourceLevel> list) {
        if (list != null && list.size() > 0) {
            // 删除所有
            this.powerResourceLevelDao.delete(this.powerResourceLevelDao.findAllByLevelid(list.get(0).getLevelid()));

            // 保存记录
            this.powerResourceLevelDao.save(list);
        }
    }

    //endregion

    /**
     * 遍历资源
     *
     * @param all
     * @param parentid
     * @return
     */
    private List<PowerResourceModel> loopResources(List<PowerResource> all, long parentid, List<PowerResourceLevel>
            in) {
        if (all == null || all.size() <= 0) {
            return null;
        }

        // 处理反射
        List<PowerResourceModel> result = this.copyList(all.stream().filter((p) -> (p.getParentid() == parentid))
                .collect(Collectors.toList()));

        // 处理子级
        if (result != null && result.size() > 0) {
            for (PowerResourceModel item : result) {
                if (in != null && in.size() > 0)
                    if (in.stream().filter((p) -> (p.getResourcesid() == item.getResourceid())).count() > 0) {
                        item.setSelected(true);
                    }

                item.setSubResources(this.loopResources(all, item.getResourceid(), in));
            }
        }

        return result;
    }

    /**
     * 复制代理对象集合
     *
     * @param list
     * @return
     */
    private List<PowerResourceModel> copyList(List<PowerResource> list) {
        // 排序
        Collections.sort(list, new Comparator<PowerResource>() {
            public int compare(PowerResource o1, PowerResource o2) {

                // 按照顺序排序
                if (o1.getSortno() > o2.getSortno()) {
                    return 1;
                }
                if (o1.getSortno() == o2.getSortno()) {
                    return 0;
                }

                return -1;
            }
        });

        // 返回结果
        List<PowerResourceModel> result = new ArrayList<>();

        // 循环复制
        for (PowerResource item : list) {
            PowerResourceModel model = new PowerResourceModel();
            BeanUtils.copyProperties(item, model);
            result.add(model);
        }

        return result;
    }
}
