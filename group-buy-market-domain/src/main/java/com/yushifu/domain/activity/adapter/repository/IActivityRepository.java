package com.yushifu.domain.activity.adapter.repository;

import com.yushifu.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import com.yushifu.domain.activity.model.valobj.SkuVO;

public interface IActivityRepository {
    GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(String source, String channel);

    SkuVO querySkuByGoodsId(String goodsId);

}
