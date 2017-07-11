package com.qaplus.utils;
/**
 *
 */
public interface SqlInValueProvider<T, V> {

    /**
     * sql in语句的value值获取
     * @param t 业务对象
     * @return 要放在in里面的值
     */
    V getInValue(T t);
}



