package com.yushifu.types.design.framework.tree;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public abstract class AbstractMultiThreadStrategyRouter<T,D,R> implements StrategyHandler<T,D,R>,StrategyMapper<T,D,R> {

    @Getter
    @Setter
    protected StrategyHandler<T,D,R> defaultStrategyHandler= DEFAULT;

    public R router(T requestParameter,D dynamicContext ) throws Exception{
        StrategyHandler<T,D,R> strategyHandler=get(requestParameter, dynamicContext);
        if(null!=strategyHandler) return  strategyHandler.apply(requestParameter,dynamicContext);
        return defaultStrategyHandler.apply(requestParameter, dynamicContext);
    }

    @Override
    public R apply(T requestParameter, D dynamicContext) throws Exception {
        multiThread(requestParameter,dynamicContext);
        return doApply(requestParameter,dynamicContext);
    }

    protected abstract R doApply(T requestParameter, D dynamicContext) throws ExecutionException, InterruptedException, TimeoutException, Exception;

    protected abstract void multiThread(T requestParameter, D dynamicContext) throws Exception;

    }
