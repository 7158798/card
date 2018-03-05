package com.rw.finance.admin.model;

import com.rw.finance.common.entity.MemberAccount;
import com.rw.finance.common.entity.MemberCard;
import com.rw.finance.common.entity.MemberInfo;
import com.rw.finance.common.entity.MemberLevel;

import java.util.List;

public class MemberDetailModel {
    /**
     * 基本信息
     */
    private MemberInfo memberinfo;

    /**
     * 会员等级
     */
    private MemberLevel memberlevel;

    /**
     * 会员账户
     */
    private MemberAccount memberaccount;

    /**
     * 会员卡片
     */
    private List<MemberCard> membercards;

    public MemberInfo getMemberinfo() {
        return memberinfo;
    }

    public void setMemberinfo(MemberInfo memberinfo) {
        this.memberinfo = memberinfo;
    }

    public MemberLevel getMemberlevel() {
        return memberlevel;
    }

    public void setMemberlevel(MemberLevel memberlevel) {
        this.memberlevel = memberlevel;
    }

    public MemberAccount getMemberaccount() {
        return memberaccount;
    }

    public void setMemberaccount(MemberAccount memberaccount) {
        this.memberaccount = memberaccount;
    }

    public List<MemberCard> getMembercards() {
        return membercards;
    }

    public void setMembercards(List<MemberCard> membercards) {
        this.membercards = membercards;
    }
}
