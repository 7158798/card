package com.rw.finance.server.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rw.finance.common.entity.RepayTask;
/**
 * 
 * @file RepayTaskDao.java	
 * @author huanghongfei
 * @date 2017年12月15日 下午2:13:04
 * @declaration
 */
public interface RepayTaskDao extends JpaRepository<RepayTask,Long>{

	List<RepayTask> findByPlanidIn(List<Long> planids);
	
	RepayTask findByTaskid(long taskid);
	
	@Query(value="select * from repay_task o where o.member_id=?1 and o.plan_id=?2 and o.execute_time=(select min(execute_time) from repay_task where status=?3 )",nativeQuery=true)
	RepayTask findByMemberidAndPlanidAndStatusAndExecutetimeMinOrderByExecutetime(long memberid,long planid,int status);
	
	List<RepayTask> findByMemberidAndPlanidAndStatusOrderByExecutetime(long memberid,long planid,int status);
	
	List<RepayTask> findByMemberidAndPlanid(long memberid,long planid);
	
	List<RepayTask> findByMemberidAndPlanidAndBatch(long memberid,long planid,int batch);
}
