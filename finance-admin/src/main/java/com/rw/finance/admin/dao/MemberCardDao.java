package com.rw.finance.admin.dao;

import com.rw.finance.common.entity.MemberCard;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 会员卡片
 */
public interface MemberCardDao extends JpaRepository<MemberCard, Long> {
    List<MemberCard> findAllByMemberid(Long memberid, Sort sort);
}
