package com.qaplus.utils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.qaplus.entity.QaUser;

/**
 * sql工具
 */
public class SqlUtils {

    /**
     * 将迭代器元素中的特定字段值,按照1000为一组值,分批组装到list集合中
     * 每1000个值放在一个set中(oracle in语句的值不能超过1000个)
     *
     * @param tIterator          通用业集合迭代器
     * @param sqlInValueProvider 获取元素的字段值
     *
     *
     * ################## mybatis.mapper.sql-in条件拼接模板 start[可直接拷贝使用] ##################
        and
        (
            <choose>
                <when test="ids != null and ids.size > 0 and ids.get(0).size > 0">
                    <foreach collection="ids" item="set" separator="or">
                        pd.pd_no in
                        <foreach collection="set" open="(" separator="," close=")" item="id">
                            #{id}
                        </foreach>
                    </foreach>
                </when>
            <otherwise>
                    pd.pd_no in (NULL) --仅在pd_no为非null类型时使用in(NULL),其他视情况而定
            </otherwise>
            </choose>
        )
     * #################### mybatis.mapper.sql-in条件拼接模板 end[可直接拷贝使用] ##################
     *
     * @return
     */
    public static <T, V> List<Set> getSqlInList(Iterator<T> tIterator, SqlInValueProvider<T, V> sqlInValueProvider) {
        List<Set> setList = new ArrayList<Set>();

        int i = 0;
        Set set = new HashSet();
        while (tIterator.hasNext()) {
            if (i % 1000 == 0) {
                set = new HashSet();
                setList.add(set);
            }
            T t = tIterator.next();

            if(t == null){
                continue;
            }

            V v = sqlInValueProvider.getInValue(t);
            if(v != null){
                set.add(v);
            }
            i++;
        }
        return setList;
    }


    /**
     * 根据给定迭代器, 组装key列表
     * @param tIterator 迭代器
     * @param sqlInValueProvider key提供者
     * @param <T> 迭代器元素
     * @param <V> key类型
     * @return key列表
     */
    public static <T, V> Set<V> getKeySet(Iterator<T> tIterator, SqlInValueProvider<T, V> sqlInValueProvider) {
        Set<V> set = new HashSet<V>();
        while (tIterator.hasNext()) {
            T t = tIterator.next();

            if (t == null) {
                continue;
            }

            V v = sqlInValueProvider.getInValue(t);
            if (v != null) {
                set.add(v);
            }
        }
        return set;
    }

    /**
     * 根据给定迭代器, 组装key列表
     * @param tIterator 迭代器
     * @param sqlInValueProvider key提供者
     * @param <T> 迭代器元素
     * @param <V> key类型
     * @return key列表
     */
    public static <T, V> List<V> getKeyList(Iterator<T> tIterator, SqlInValueProvider<T, V> sqlInValueProvider) {
        List<V> arrayList = new ArrayList<V>();
        while (tIterator.hasNext()) {
            T t = tIterator.next();

            if (t == null) {
                continue;
            }

            V v = sqlInValueProvider.getInValue(t);
            if (v != null) {
                arrayList.add(v);
            }
        }
        return arrayList;
    }
    
    public static void main(String[] args) {
    	List<QaUser> users=new ArrayList<QaUser>();
    	QaUser u1=new QaUser();
    	u1.setAge(1);
    	
    	QaUser u2=new QaUser();
    	u2.setAge(2);
    	
    	QaUser u3=new QaUser();
    	u3.setAge(3);
    	
    	
    	users.add(u3);
    	users.add(u2);
    	users.add(u1);
    	
    	
    	List<Integer> result=SqlUtils.getKeyList(users.iterator(), new SqlInValueProvider<QaUser, Integer>() {

			@Override
			public Integer getInValue(QaUser t) {
				return t.getAge();
			}
		});
    	
    	System.out.println(result);
    	
	}
}


