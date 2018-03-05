package com.rw.finance.server.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rw.finance.common.entity.RepayPlan;
/**
 * 
 * @file RepayPlanDao.java	
 * @author huanghongfei
 * @date 2017年12月15日 下午2:12:19
 * @declaration
 */
public interface RepayPlanDao extends JpaRepository<RepayPlan, Long>{
	
	@Query(value="select * from repay_plan o where o.member_id=?1 and o.card_id=?2 and o.status!=0 order by o.create_time desc",nativeQuery=true)
	List<RepayPlan> findByMemberidAndCardidOrderByCreatetime(long memberid,long cardid);

	Page<RepayPlan> findByMemberidAndCardidAndStatusOrderByCreatetime(long memberid,long cardid,int status,Pageable pageable);
	
	RepayPlan findByMemberidAndPlanid(long memberid,long planid);
	
	List<RepayPlan> findByStatus(int status);
}
