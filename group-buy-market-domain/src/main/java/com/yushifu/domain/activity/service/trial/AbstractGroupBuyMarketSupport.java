package com.yushifu.domain.activity.service.trial;

import com.yushifu.domain.activity.adapter.repository.IActivityRepository;
import com.yushifu.domain.activity.model.entity.MarketProductEntity;
import com.yushifu.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import com.yushifu.types.design.framework.tree.AbstractMultiThreadStrategyRouter;
import com.yushifu.types.design.framework.tree.AbstractStrategyRouter;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public abstract class AbstractGroupBuyMarketSupport<MarketProductEntity, DynamicContext, TrialBalanceEntity> extends AbstractMultiThreadStrategyRouter<com.yushifu.domain.activity.model.entity.MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, com.yushifu.domain.activity.model.entity.TrialBalanceEntity> {

    protected long timeout = 500;
    @Resource
    protected IActivityRepository repository;

    @Override
    protected void multiThread(com.yushifu.domain.activity.model.entity.MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws ExecutionException, InterruptedException, TimeoutException {
        // 缺省的方法
    }

}
