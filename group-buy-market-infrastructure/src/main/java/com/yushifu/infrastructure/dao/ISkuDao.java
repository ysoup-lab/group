package com.yushifu.infrastructure.dao;

import com.yushifu.infrastructure.dao.po.Sku;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ISkuDao {
    Sku querySkuByGoodsId(String goodsId);
}
