package com.rw.finance.admin.dao;

import com.rw.finance.common.entity.AgentInfo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * 代理信息
 */
public interface AgentInfoDao extends PagingAndSortingRepository<AgentInfo, Long>, JpaSpecificationExecutor<AgentInfo> {

    /**
     * 根据用户名和密码查询代理
     *
     * @param username
     * @param password MD5 pass
     * @return
     */
    AgentInfo findByUsernameAndPassword(String username, String password);

    /**
     * 根据用户名查找代理
     *
     * @param username
     * @return
     */
    AgentInfo findByUsername(String username);

    /**
     * 根据代理名查找代理
     *
     * @param agentname
     * @return
     */
    AgentInfo findByAgentname(String agentname);

    /**
     * 查找子级代理
     *
     * @param agentid
     * @return
     */
    List<AgentInfo> findAllByParentid(Long agentid);

    /**
     * 查询代理列表
     *
     * @param agentid
     * @param start
     * @param end
     * @return
     */
    List<AgentInfo> findAllByParentidAndAgentlevelGreaterThanAndCreatetimeBetween(Long agentid, Integer level, String
            start, String end);


    /**
     * 查询代理列表
     *
     * @param start
     * @param end
     * @return
     */
    List<AgentInfo> findByAgentlevelGreaterThanAndCreatetimeBetween(Integer level, String start, String end);

    /**
     * 根据用户名或手机查找代理
     */
    List<AgentInfo> findAllByUsername(String username);

    /**
     * 是否存在权限等级代理
     *
     * @param levelid
     * @return
     */
    boolean existsByPowerlevel(Long levelid);

    /**
     * 统计代理数量
     *
     * @param agentid
     * @param level
     * @return
     */
    Long countByParentidAndAgentlevelGreaterThan(Long agentid, Integer level);

    /**
     * 统计代理数量
     *
     * @param level
     * @return
     */
    Long countByAgentlevelGreaterThan(Integer level);

    @Query(value = "select agentid from AgentInfo where mobile like concat('%',?1,'%')")
    List<Long> findAgentidByMobile(String mobile);
}
