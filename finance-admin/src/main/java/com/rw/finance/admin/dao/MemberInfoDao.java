package com.rw.finance.admin.dao;

import com.rw.finance.common.entity.MemberInfo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * 会员信息
 */
public interface MemberInfoDao extends PagingAndSortingRepository<MemberInfo, Long>,
        JpaSpecificationExecutor<MemberInfo> {
    /**
     * 查询会员列表
     *
     * @param agentid
     * @return
     */
    List<MemberInfo> findByAgentid(Long agentid);

    /**
     * 查询会员列表
     *
     * @param agentid
     * @param start
     * @param end
     * @return
     */
    List<MemberInfo> findByAgentidAndRegistertimeBetween(Long agentid, String start, String end);


    /**
     * 查询会员列表
     *
     * @param start
     * @param end
     * @return
     */
    List<MemberInfo> findByRegistertimeBetween(String start, String end);

    /**
     * 查询会员列表
     *
     * @param agentid
     * @param start
     * @param end
     * @return
     */
    List<MemberInfo> findByAgentidAndActivetimeBetween(Long agentid, String start, String end);


    /**
     * 查询会员列表
     *
     * @param start
     * @param end
     * @return
     */
    List<MemberInfo> findByActivetimeBetween(String start, String end);

    /**
     * 查询会员列表
     *
     * @param agentid
     * @param start
     * @param end
     * @return
     */
    List<MemberInfo> findByAgentidAndLastlogintimeBetween(Long agentid, String start, String end);


    /**
     * 查询会员列表
     *
     * @param start
     * @param end
     * @return
     */
    List<MemberInfo> findByLastlogintimeBetween(String start, String end);

    /**
     * 统计会员数量
     *
     * @param agentid
     * @return
     */
    Long countByAgentid(Long agentid);

    @Query(value = "select memberid from MemberInfo where telephone like concat('%',?1,'%')")
    List<Long> findMemberidByMobile(String mobile);
}
