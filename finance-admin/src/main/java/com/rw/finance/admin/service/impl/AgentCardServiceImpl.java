package com.rw.finance.admin.service.impl;

import com.rw.finance.admin.dao.AgentCardDao;
import com.rw.finance.admin.dao.BankInfoDao;
import com.rw.finance.admin.service.AgentCardService;
import com.rw.finance.common.entity.AgentCard;
import com.rw.finance.common.entity.BankInfo;
import com.rw.finance.common.utils.BankUtils;
import com.rw.finance.common.utils.Result;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 代理卡片接口实现
 */
@Service
public class AgentCardServiceImpl implements AgentCardService {
    @Autowired
    private AgentCardDao agentCardDao;

    @Autowired
    private BankInfoDao bankInfoDao;

    @Override
    public AgentCard getAgentCard(Long cardid) {
        return agentCardDao.findOne(cardid);
    }

    @Override
    public List<AgentCard> getAgentCards(Long agentid) {
        return agentCardDao.findAllByAgentidAndIsdel(agentid, 0);
    }

    @Override
    public Result saveAgentCard(AgentCard model) {
        // 鉴权信息
        com.rw.finance.common.utils.BankUtils.BankInfo bankInfo = BankUtils.getBankInfo(model.getCardno());
        if (bankInfo == null && bankInfo.getResult() != null) {
            return new Result(202, "您的卡片信息错误", null);
        }

        model.setProvince(bankInfo.getResult().getProvince());
        model.setCity(bankInfo.getResult().getCity());

        // 重复验证
        if (model.getAgentcardid() <= 0) {
            AgentCard card = agentCardDao.findByCardno(model.getCardno().trim());
            if (card != null) {
                return new Result(202, "银行卡号已经存在", null);
            }

            model.setCreatetime(DateUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        } else {
            AgentCard card = agentCardDao.findOne(model.getAgentcardid());
            if (card == null) {
                return new Result(202, "银行卡信息不存在", null);
            }

            model.setCreatetime(card.getCreatetime());

            card = agentCardDao.findByCardno(model.getCardno().trim());
            if (card != null && card.getAgentcardid() != model.getAgentcardid()) {
                return new Result(202, "银行卡号已经存在", null);
            }
        }

        // 银行信息
        BankInfo info = this.bankInfoDao.findOne(model.getBankid());
        if (info == null) {
            return new Result(202, "银行信息有误", null);
        }

        model.setIsdel(0);
        model.setAbbreviation(info.getAbbreviation());
        model.setUpdatetime(DateUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        agentCardDao.save(model);
        return new Result(200, "保存成功", null);
    }

    @Override
    public void delAgentCard(Long cardid) {
        /*agentCardDao.delete(cardid);*/
        AgentCard card = agentCardDao.findOne(cardid);
        if (card != null) {
            card.setIsdel(1);
            card.setUpdatetime(DateUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
            agentCardDao.save(card);
        }
    }
}
