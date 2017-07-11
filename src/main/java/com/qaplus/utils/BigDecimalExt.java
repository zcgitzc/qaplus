package com.qaplus.utils;

import java.math.BigDecimal;

/**
 * BigDecimal扩展类
 * 
 * @author yc 2014年12月18日 下午5:12:40
 */
public class BigDecimalExt {

    private BigDecimal val;

    public BigDecimalExt(){
        this(null);
    }

    public BigDecimalExt(BigDecimal val){
        this.val = val;
    }

    public BigDecimal val() {
        return val;
    }

    public BigDecimalExt add(BigDecimal addVal) {
        if (null == val) {
            if (null == addVal) {
                return new BigDecimalExt();
            } else {
                return new BigDecimalExt(BigDecimal.ZERO).add(addVal);
            }
        } else {
            if (null == addVal) {
                return new BigDecimalExt(val);
            } else {
                return new BigDecimalExt(val.add(addVal));
            }
        }
    }

    public BigDecimalExt subtract(BigDecimal subVal) {
        if (null == val) {
            if (null == subVal) {
                return new BigDecimalExt();
            } else {
                return new BigDecimalExt(BigDecimal.ZERO).subtract(subVal);
            }
        } else {
            if (null == subVal) {
                return new BigDecimalExt(val);
            } else {
                return new BigDecimalExt(val.subtract(subVal));
            }
        }
    }

    public boolean isValEqual(BigDecimal number) {
        if (null == number && null == val) {
            return true;
        }
        if (null == number || null == val) {
            return false;
        }
        return val.compareTo(number) == 0;
    }
}
