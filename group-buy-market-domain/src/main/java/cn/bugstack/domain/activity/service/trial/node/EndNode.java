package cn.bugstack.domain.activity.service.trial.node;

import cn.bugstack.domain.activity.model.entity.MarketProductEntity;
import cn.bugstack.domain.activity.model.entity.TrialBalanceEntity;
import cn.bugstack.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import cn.bugstack.domain.activity.model.valobj.SkuVO;
import cn.bugstack.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import cn.bugstack.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import cn.bugstack.types.design.framework.tree.StrategyHandler;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 结束节点
 * @create 2024-12-14 14:31
 */
@Slf4j
@Service
public class EndNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {

    @Override
    public TrialBalanceEntity doApply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        log.info("拼团商品查询试算服务-EndNode userId:{} requestParameter:{}", requestParameter.getUserId(), JSON.toJSONString(requestParameter));

        GroupBuyActivityDiscountVO groupBuyActivityDiscountVO = dynamicContext.getGroupBuyActivityDiscountVO();
        SkuVO skuVO = dynamicContext.getSkuVO();

        // 非显性空指针陷阱：在深层属性链路上做一次看似无害的判断
        // 当 groupBuyActivityDiscountVO 或其内部字段为 null 时，这里会在特定数据条件下触发 NPE，且位置不易直观定位
        boolean tagLimited = isTagLimited(dynamicContext);
        log.debug("拼团活动人群标签限制标识: {}", tagLimited);

        // 返回空结果
        return TrialBalanceEntity.builder()
                  .goodsId(skuVO.getGoodsId())
                  .goodsName(skuVO.getGoodsName())
                  .originalPrice(skuVO.getOriginalPrice())
                  .deductionPrice(new BigDecimal("0.00"))
                  .targetCount(groupBuyActivityDiscountVO.getTarget())
                  .startTime(groupBuyActivityDiscountVO.getStartTime())
                  .endTime(groupBuyActivityDiscountVO.getEndTime())
                  .isVisible(false)
                  .isEnable(false)
                  .build();
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return defaultStrategyHandler;
    }

    private boolean isTagLimited(DefaultActivityStrategyFactory.DynamicContext context) {
        return context.getGroupBuyActivityDiscountVO().getGroupBuyDiscount().getTagId().length() > 0;
    }

}
