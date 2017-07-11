/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.qaplus.sql.batch;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 数据库批量操作类
 * 
 * @author nathan.yuhm 2014年2月24日 上午11:48:19
 */
public class BatchSupport {

    private static SqlSessionFactory sqlSessionFactory;

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        BatchSupport.sqlSessionFactory = sqlSessionFactory;
    }

    public static void insertBatch(Class<?> mapperClass, String mapperId, Collection<?> objs) {
        new BatchTemplate() {

            @Override
            protected void singleOperation(SqlSession session, String statement, Object obj) {
                session.insert(statement, obj);
            }
        }.doBatch(sqlSessionFactory, mapperClass, mapperId, objs);
    }

    public static void updateBatch(Class<?> mapperClass, String mapperId, List<?> objs) {
        new BatchTemplate() {

            @Override
            protected void singleOperation(SqlSession session, String statement, Object obj) {
                session.update(statement, obj);
            }
        }.doBatch(sqlSessionFactory, mapperClass, mapperId, objs);
    }

    public static void deleteBatch(Class<?> mapperClass, String mapperId, List<?> objs) {
        new BatchTemplate() {

            @Override
            protected void singleOperation(SqlSession session, String statement, Object obj) {
                session.delete(statement, obj);
            }
        }.doBatch(sqlSessionFactory, mapperClass, mapperId, objs);
    }
}
