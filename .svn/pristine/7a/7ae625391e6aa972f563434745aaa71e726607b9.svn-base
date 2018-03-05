package com.rw.finance.admin.service.impl;

import com.rw.finance.admin.dao.*;
import com.rw.finance.admin.model.CountMemberEChartsModel;
import com.rw.finance.admin.model.MemberAuthInfoModel;
import com.rw.finance.admin.model.MemberDetailModel;
import com.rw.finance.admin.model.MemberInfoQueryModel;
import com.rw.finance.admin.service.BaseCacheService;
import com.rw.finance.admin.service.MemberInfoService;
import com.rw.finance.common.constants.TimeConstants;
import com.rw.finance.common.entity.*;
import com.rw.finance.common.utils.DateUtils;
import com.rw.finance.common.utils.SortUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 会员接口实现
 */
@Service
public class MemberInfoServiceImpl implements MemberInfoService {
    @Autowired
    private MemberInfoDao memberInfoDao;

    @Autowired
    private MemberLevelDao memberLevelDao;

    @Autowired
    private MemberAccountDao memberAccountDao;

    @Autowired
    private MemberCardDao memberCardDao;

    @Autowired
    private AgentInfoDao agentInfoDao;

    @Autowired
    private SystemSettingDao systemSettingDao;

    @Autowired
    private BaseCacheService baseCacheService;

    @Override
    public Page<MemberInfo> getMemberInfos(MemberInfoQueryModel model) {
        // 处理排序
        List<Sort.Order> listOrder = SortUtils.toSortOrder(model.getOrderby());
        if (model.getPage() > 0) {
            model.setPage(model.getPage() - 1);
        }

        // 处理条件
        Page<MemberInfo> info = memberInfoDao.findAll(new Specification<MemberInfo>() {
            @Override
            public Predicate toPredicate(Root<MemberInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder
                    criteriaBuilder) {

                // 条件集合
                List<Predicate> predicates = new ArrayList();

                // 手机号码
                if (model.getTelephone() != null && !model.getTelephone().isEmpty()) {
                    predicates.add(criteriaBuilder.like(root.get("telephone"), "%" + model.getTelephone() + "%"));
                }

                // 会员名称
                if (model.getNickname() != null && !model.getNickname().isEmpty()) {
                    predicates.add(criteriaBuilder.like(root.get("nickname"), "%" + model.getNickname() + "%"));
                }

                // 是否实名
                if (model.getIsreal() != null && model.getIsreal() != 99) {
                    predicates.add(criteriaBuilder.equal(root.get("isreal"), model.getIsreal()));
                }

                // 真实姓名
                if (model.getRealname() != null && !model.getRealname().isEmpty()) {
                    predicates.add(criteriaBuilder.like(root.get("realname"), "%" + model.getRealname() + "%"));
                }

                // 身份证号
                if (model.getIdnumber() != null && !model.getIdnumber().isEmpty()) {
                    predicates.add(criteriaBuilder.like(root.get("idnumber"), "%" + model.getIdnumber() + "%"));
                }

                // 代理等级
                if (model.getLevel() != null && model.getLevel() != 99) {
                    predicates.add(criteriaBuilder.equal(root.get("level"), model.getLevel()));
                }

                // 代理编号
                if (model.getAgentid() != null && model.getAgentid() > 0) {
                    predicates.add(criteriaBuilder.equal(root.get("agentid"), model.getAgentid()));
                } else {
                    if (model.getAgentname() != null && !model.getAgentname().isEmpty()) {
                        AgentInfo agentInfo = agentInfoDao.findByAgentname(model.getAgentname());
                        if (agentInfo != null) {
                            predicates.add(criteriaBuilder.equal(root.get("agentid"), agentInfo.getAgentid()));
                        } else {
                            predicates.add(criteriaBuilder.equal(root.get("agentid"), -1));
                        }
                    }
                }

                // 状态
                if (model.getStatus() != null && model.getStatus() != 99) {
                    predicates.add(criteriaBuilder.equal(root.get("status"), model.getStatus()));
                }

                // 注册开始
                if (model.getSregistertime() != null && !model.getSregistertime().isEmpty()) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.<Date>get("registertime"), DateUtils
                            .getTimeByStr(model
                                    .getSregistertime())));
                }

                // 注册结束
                if (model.getEregistertime() != null && !model.getEregistertime().isEmpty()) {
                    predicates.add(criteriaBuilder.lessThan(root.<Date>get("registertime"), DateUtils
                            .getTimeByStr(model
                                    .getEregistertime())));
                }

                // 判断条件
                if (predicates.size() > 0) {
                    return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
                }

                return null;
            }
        }, new PageRequest(model.getPage(), model.getSize(), new Sort(listOrder)));

        // 特殊处理
        if (info.getContent() != null && info.getContent().size() > 0) {
            // 代理编号
            List<Long> longs = null;
            Stream<MemberInfo> memberInfoStream = info.getContent().stream().filter(s -> s.getAgentid() != null);
            if (memberInfoStream != null && memberInfoStream.count() > 0) {
                memberInfoStream.close();
                longs = info.getContent().stream().filter(s -> s.getAgentid() != null).map(s -> s.getAgentid())
                        .collect(Collectors.toList());
            }

            // 代理集合
            Iterable<AgentInfo> listAgent = agentInfoDao.findAll(longs);
            for (MemberInfo member : info.getContent()) {
                if (listAgent != null) {
                    listAgent.forEach((s) -> {
                        if (s.getAgentid() == member.getAgentid()) {
                            member.agentname = s.getAgentname();
                            return;
                        }
                    });
                }

                // 手机号码
                if (model.getAgentlevel() > 0) {
                    member.setTelephone(member.getTelephone().substring(0, 3) + "****" + member.getTelephone().substring
                            (member.getTelephone().length() - 4));
                }

                // 密码信息
                member.setPassword("");
                member.setPaypwd("");

                // 身份证号
                if (member.getIdnumber() != null && member.getIdnumber().length() > 0) {
                    member.setIdnumber(member.getIdnumber().substring(0, 4) + "****" + member
                            .getIdnumber().substring(member.getIdnumber().length() - 4));
                }

                // 真实姓名
                if (member.getRealname() != null && !member.getRealname().isEmpty()) {
                    if (member.getRealname().length() >= 3) {
                        member.setRealname(member.getRealname().substring(0, 1) + "*" + member.getRealname()
                                .substring(member.getRealname().length() - 1));
                    } else {
                        member.setRealname("*" + member.getRealname().substring(member.getRealname().length() - 1));
                    }
                }

                // 资源附件
                member.setIdpath("");
                member.setIdobverse("");
                member.setIdreverse("");
            }
        }

        return info;
    }

    @Override
    public MemberInfo getMemberInfo(Long memberid) {
        return memberInfoDao.findOne(memberid);
    }

    @Override
    public MemberDetailModel getMemberDetail(Long memberid, int agentlevel) {
        // 会员信息
        MemberInfo member = memberInfoDao.findOne(memberid);
        if (member == null) {
            return null;
        }

        // 返回对象
        MemberDetailModel result = new MemberDetailModel();

        // 取得代理
        if (member.getAgentid() != null && member.getAgentid() > 0) {
            AgentInfo agentInfo = agentInfoDao.findOne(member.getAgentid());
            if (agentInfo != null) {
                member.agentname = agentInfo.getAgentname();
            }
        }

        // 手机号码
        if (agentlevel > 0) {
            member.setTelephone(member.getTelephone().substring(0, 3) + "****" + member.getTelephone().substring
                    (member.getTelephone().length() - 4));
        }

        // 密码信息
        member.setPassword("");
        member.setPaypwd("");

        // 身份证号
        if (member.getIdnumber() != null && member.getIdnumber().length() > 0) {
            member.setIdnumber(member.getIdnumber().substring(0, 4) + "****" + member
                    .getIdnumber().substring(member.getIdnumber().length() - 4));
        }

        // 真实姓名
        if (member.getRealname() != null && !member.getRealname().isEmpty()) {
            if (member.getRealname().length() >= 3) {
                member.setRealname(member.getRealname().substring(0, 1) + "*" + member.getRealname().substring(member
                        .getRealname().length() - 1));
            } else {
                member.setRealname("*" + member.getRealname().substring(member.getRealname().length() - 1));
            }
        }

        // 资源附件
        member.setIdpath("");
        member.setIdobverse("");
        member.setIdreverse("");
        result.setMemberinfo(member);

        // 会员等级
        /*MemberLevel level = memberLevelDao.findByLevel(member.getLevel());
        if (level != null) {
            result.setMemberlevel(level);
        }*/

        // 会员账户
        MemberAccount account = memberAccountDao.findByMemberid(member.getMemberid());
        if (account != null) {
            result.setMemberaccount(account);
        }

        // 会员卡片
        List<MemberCard> listCard = memberCardDao.findAllByMemberid(member.getMemberid(), new Sort(Sort.Direction
                .DESC, "createtime"));
        if (listCard != null && listCard.size() > 0) {
            // 处理卡片
            for (MemberCard card : listCard) {
                // 卡号
                if (card.getCardno() != null && !card.getCardno().isEmpty()) {
                    card.setCardno(card.getCardno().substring(0, 4) + "****" + card.getCardno().substring(card
                            .getCardno().length() - 4));
                }

                // 名字
                if (card.getRealname() != null && !card.getRealname().isEmpty()) {
                    if (card.getRealname().length() >= 3) {
                        card.setRealname(card.getRealname().substring(0, 1) + "*" + card.getRealname().substring(card
                                .getRealname().length() - 1));
                    } else {
                        card.setRealname("*" + card.getRealname().substring(card.getRealname().length() - 1));
                    }
                }

                // 手机
                if (card.getMobile() != null && !card.getMobile().isEmpty()) {
                    card.setMobile(card.getMobile().substring(0, 3) + "****" + card.getMobile().substring
                            (card.getMobile().length() - 4));
                }

                // 其它
                card.setCardcolor("");
                card.setBankextra("");
                card.setBilldate("");
                card.setRepaydate("");
                card.setExpirydate("");
                card.setAuthcode("");
            }

            result.setMembercards(listCard);
        }

        return result;
    }

    @Override
    public MemberAuthInfoModel getMemberAuthinfo(Long memberid) {
        // 会员信息
        MemberInfo member = memberInfoDao.findOne(memberid);
        if (member == null) {
            return null;
        }

        // 返回对象
        MemberAuthInfoModel result = new MemberAuthInfoModel();
        BeanUtils.copyProperties(member, result);

        // 资源服务器
        String sourceUrl = "";

        // 缓存对象
        Object object = baseCacheService.get("RESOURCE_HOST", String.class);
        if (object == null) {
            // 写入缓存
            SystemSetting systemSetting = systemSettingDao.findByDictkeyAndStatus("RESOURCE_HOST", 1);
            if (systemSetting != null) {
                sourceUrl = systemSetting.getDictval();
                baseCacheService.set("RESOURCE_HOST", sourceUrl, TimeConstants.SMS_CODE_EXPRIE_TIME);
            }
        } else {
            sourceUrl = object.toString();
        }

        result.setIdobverse(sourceUrl + result.getIdobverse());
        result.setIdpath(sourceUrl + result.getIdpath());
        result.setIdreverse(sourceUrl + result.getIdreverse());
        return result;
    }

    @Override
    public void auditMemberReal(List<Long> listid, int isreal) {
        Iterable<MemberInfo> list = memberInfoDao.findAll(listid);
        if (list != null) {
            list.forEach((s) -> {
                if (s.getIsreal() != isreal) {
                    s.setIsreal(isreal);
                    if (isreal == 1) {
                        s.setIsrealtime(org.apache.tools.ant.util.DateUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
                    } else {
                        s.setIsrealtime("");
                    }

                    memberInfoDao.save(s);
                }
            });
        }
    }

    @Transactional
    @Override
    public void updateMemberLevel(List<Long> listid, Integer level) {
        Iterable<MemberInfo> list = memberInfoDao.findAll(listid);
        if (list != null) {
            list.forEach((s) -> {
                if (s.getLevel() != level) {
                    s.setLevel(level);
                    memberInfoDao.save(s);
                }
            });
        }
    }

    @Transactional
    @Override
    public void updateMemberStatus(List<Long> listid, Integer status) {
        Iterable<MemberInfo> list = memberInfoDao.findAll(listid);
        if (list != null) {
            list.forEach((s) -> {
                if (s.getStatus() != status) {
                    s.setStatus(status);
                    if (status == 1) {
                        s.setActivetime(org.apache.tools.ant.util.DateUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
                    } else {
                        s.setActivetime("");
                    }

                    memberInfoDao.save(s);
                }
            });
        }
    }

    @Override
    public CountMemberEChartsModel getMemberCount(Long agentid, String start, String end) {
        // 代理信息
        AgentInfo agentInfo = this.agentInfoDao.findOne(agentid);
        if (agentInfo == null) {
            return null;
        }

        // 统计结果
        CountMemberEChartsModel model = new CountMemberEChartsModel();

        // 日期集合
        List<String> date = DateUtils.getDateList(start, end);
        model.setDate(date);

        // 周期开始与结束
        start = date.get(0) + " 00:00:00";
        end = date.get(date.size() - 1) + " 23:59:59";

        // region 统计注册

        List<MemberInfo> memberInfoList = null;
        if (agentInfo.getAgentlevel() > 0) {
            memberInfoList = memberInfoDao.findByAgentidAndRegistertimeBetween(agentInfo.getAgentid(), start, end);
        } else {
            memberInfoList = memberInfoDao.findByRegistertimeBetween(start, end);
        }

        List<Long> count = new ArrayList();
        for (String item : date) {
            if (memberInfoList == null || memberInfoList.size() <= 0) {
                count.add(0L);
            } else {
                Long date_1 = DateUtils.getTimeByStr(item + " 00:00:00").getTime();
                Long date_2 = DateUtils.getTimeByStr(item + " 23:59:59").getTime();
                count.add(memberInfoList.stream().filter(s -> DateUtils.getTimeByStr(s.getRegistertime()).getTime() >=
                        date_1 && DateUtils.getTimeByStr(s.getRegistertime()).getTime() <= date_2).count());
            }
        }

        model.setRegistercount(count);

        //endregion

        // region 统计激活

        if (agentInfo.getAgentlevel() > 0) {
            memberInfoList = memberInfoDao.findByAgentidAndActivetimeBetween(agentInfo.getAgentid(), start, end);
        } else {
            memberInfoList = memberInfoDao.findByActivetimeBetween(start, end);
        }

        count = new ArrayList();
        for (String item : date) {
            if (memberInfoList == null || memberInfoList.size() <= 0) {
                count.add(0L);
            } else {
                Long date_1 = DateUtils.getTimeByStr(item + " 00:00:00").getTime();
                Long date_2 = DateUtils.getTimeByStr(item + " 23:59:59").getTime();
                count.add(memberInfoList.stream().filter(s -> DateUtils.getTimeByStr(s.getActivetime()).getTime() >=
                        date_1 && DateUtils.getTimeByStr(s.getActivetime()).getTime() <= date_2).count());
            }
        }

        model.setActivecount(count);

        //endregion

        // region 统计登录

        if (agentInfo.getAgentlevel() > 0) {
            memberInfoList = memberInfoDao.findByAgentidAndLastlogintimeBetween(agentInfo.getAgentid(), start, end);
        } else {
            memberInfoList = memberInfoDao.findByLastlogintimeBetween(start, end);
        }

        count = new ArrayList();
        for (String item : date) {
            if (memberInfoList == null || memberInfoList.size() <= 0) {
                count.add(0L);
            } else {
                Long date_1 = DateUtils.getTimeByStr(item + " 00:00:00").getTime();
                Long date_2 = DateUtils.getTimeByStr(item + " 23:59:59").getTime();
                count.add(memberInfoList.stream().filter(s -> DateUtils.getTimeByStr(s.getLastlogintime()).getTime() >=
                        date_1 && DateUtils.getTimeByStr(s.getLastlogintime()).getTime() <= date_2).count());
            }
        }

        model.setLogincount(count);

        //endregion

        return model;
    }
}
