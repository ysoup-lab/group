package com.yushifu.domain.activity.service.trial.node;

import com.yushifu.domain.activity.model.entity.MarketProductEntity;
import com.yushifu.domain.activity.model.entity.TrialBalanceEntity;
import com.yushifu.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import com.yushifu.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.yushifu.types.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 开关节点
 * @create 2024-12-14 14:27
 */
@Slf4j
@Service
public class SwitchRoot extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {
    @Resource
    private MarketNode marketNode;
    @Override
    public TrialBalanceEntity doApply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        log.info("switch node");
        return router(requestParameter, dynamicContext);
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return marketNode;
    }
}
