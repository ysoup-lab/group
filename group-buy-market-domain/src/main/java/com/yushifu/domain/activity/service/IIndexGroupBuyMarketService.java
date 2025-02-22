package com.yushifu.domain.activity.service;

import com.yushifu.domain.activity.model.entity.MarketProductEntity;
import com.yushifu.domain.activity.model.entity.TrialBalanceEntity;
import org.springframework.stereotype.Service;


public interface IIndexGroupBuyMarketService {
    TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity)throws Exception;
}
