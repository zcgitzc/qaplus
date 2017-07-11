package com.qaplus.utils;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
//TODO 有时间试一下这个东东
//EG:
//line.setTempAccruedAmount(AmountUtil.calTotalAmountByNull(savedDetails, AccruedAmountProperty.TMP_ACRU));
//AccruedAmountProperty 实现AmountProperty接口
public class AmountUtil {

    /**
     * 计算对象列表某字段的总金额
     * 
     * @param property
     * @param pojos
     * @return 若某一对象的待加金额为null，可视为跳过；若列表为空，或所有对象的待加金额为null，返回null
     */
    public static final BigDecimal calTotalAmountByNull(List<?> pojos, AmountProperty property) {
        return calTotalAmount(pojos, property, null);
    }

    /**
     * 计算对象列表某字段的总金额
     * 
     * @param property
     * @param pojos
     * @return 若某一对象的待加金额为null，可视为跳过；若列表为空，或所有对象的待加金额为null，返回0
     */
    public static final BigDecimal calTotalAmount(List<?> pojos, AmountProperty property) {
        return calTotalAmount(pojos, property, BigDecimal.ZERO);
    }

    private static final BigDecimal calTotalAmount(List<?> pojos, AmountProperty property, BigDecimal oriAmount) {
//        if (pojos.size() == 1) {
//            return getAmount(property, pojos.get(0));
//        }
        BigDecimalExt totalAmount = new BigDecimalExt(oriAmount);
        for (Object pojo : pojos) {
            BigDecimal amount = getAmount(property, pojo);
            totalAmount = totalAmount.add(amount);
        }
        return totalAmount.val();
    }

    private static BigDecimal getAmount(AmountProperty property, Object pojo) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(pojo);
        BigDecimal amount = (BigDecimal) beanWrapper.getPropertyValue(property.realName());
        return amount;
    }

    /**
     * 对象内各金额字段计算
     * 
     * @param pojo
     * @param adds
     * @return
     */
    public static final BigDecimal calAmount(Object pojo, AmountProperty[] adds) {
        return calAmount(pojo, adds, new AmountProperty[] {});
    }

    /**
     * 对象内各金额字段计算
     * 
     * @param pojo
     * @param adds
     * @param subs
     * @return
     */
    public static final BigDecimal calAmount(Object pojo, AmountProperty[] adds, AmountProperty[] subs) {
        BigDecimalExt result = new BigDecimalExt();
        BeanWrapper beanWrapper = new BeanWrapperImpl(pojo);
        for (AmountProperty add : adds) {
            BigDecimal amount = (BigDecimal) beanWrapper.getPropertyValue(add.realName());
            result = result.add(amount);
        }
        for (AmountProperty sub : subs) {
            BigDecimal amount = (BigDecimal) beanWrapper.getPropertyValue(sub.realName());
            result = result.subtract(amount);
        }
        return result.val();
    }
}
