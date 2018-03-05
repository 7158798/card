package com.rw.finance.server.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rw.finance.common.entity.MemberProfit;
/**
 * 
 * @file MemberProfitDao.java	
 * @author huanghongfei
 * @date 2017年12月22日 下午4:46:30
 * @declaration
 */
public interface MemberProfitDao extends JpaRepository<MemberProfit,Long>{

	Page<MemberProfit> findByMemberidAndLevelOrderByCreatetime(long memberid,int level,Pageable pageable);
	
	/**
	 * 求和利润金额，交易金额，统计会员数，等级分组
	 * @param memberid
	 * @return
	 */
	@Query(value="select sum(amount) as amount,sum(biz_amount)as biz_amount,count(distinct pro_member_id) as pro_member_id from member_profit o where member_id=?1 group by o.level",nativeQuery=true)
	List<Object[]> sumAmountAndBizamountCountPromemberidByMemberidGroupByLevel(long memberid);
	/**
	 * 统计当日收益
	 * @param memberid
	 * @param date
	 * @return
	 */
	@Query(value="select ifnull(sum(amount),0) from member_profit o where o.member_id=?1 and o.create_time like ?2%",nativeQuery=true)
	double sumAmountByMemberidAndCreatetimeLikeDate(long memberid,String date);
	/**
	 * 统计当月收益
	 * @param memberid
	 * @param month
	 * @return
	 */
	@Query(value="select ifnull(sum(amount),0) from member_profit o where o.member_id=?1 and o.create_time like ?2%",nativeQuery=true)
	double sumAmountByMemberidAndCreatetimeLikeMonth(long memberid,String month);
	/**
	 * 统计所有收益
	 * @param memberid
	 * @return
	 */
	@Query(value="select ifnull(sum(amount),0) from member_profit o where o.member_id=?1",nativeQuery=true)
	double sumAmountByMemberid(long memberid);
	
	Page<MemberProfit> findByMemberid(long memberid,Pageable pageable);

}
