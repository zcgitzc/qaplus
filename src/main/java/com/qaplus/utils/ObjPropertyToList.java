package com.qaplus.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.qaplus.entity.QaUser;
/**
 * 将某个对象数组的某个属性取出，封装成List
 * @author wb-zc189961
 *
 */
public class ObjPropertyToList {
	
	/**
	 * 获取对象数组中的某个属性的List
	 * @param property 属性名称
	 * @param list 对象数组
	 * @return 数组
	 * @throws Exception 异常
	 */
	public static <T> List<Object> getPropertyList(String property,
			List<T> list) throws Exception {
		List<Object> objList = new ArrayList<Object>();
		for (T t : list) {
			Class<? extends Object> clazz = t.getClass();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				if (property.equals(field.getName())) {
					PropertyDescriptor pd = new PropertyDescriptor(
							field.getName(), clazz);
					Method getMethod = pd.getReadMethod();// 获得get方法
					Object o = getMethod.invoke(t);
					objList.add(o);
				}
			}
		}
		return objList;
	}
	
	/**
	 * 直接通过Spring 提供的BeanWrapper处理 
	 * @param property 属性名称
	 * @param list 对象数组
	 * @return 数组
	 * @throws Exception 异常
	 */
	public static <T> List<Object> getPropertyList2(String property,
			List<T> pojos) throws Exception {
		List<Object> objList = new ArrayList<Object>();
		for (T t : pojos) {
			BeanWrapper wrapper=new BeanWrapperImpl(t);
			Object o=wrapper.getPropertyValue(property);
			objList.add(o);
		}
		return objList;
	}
	
	public static void main(String[] args) throws Exception {
		List<QaUser> users = new ArrayList<QaUser>();
		QaUser user1 = new QaUser();
		user1.setAge(1);
		QaUser user2 = new QaUser();
		user2.setAge(2);
		QaUser user3 = new QaUser();
		user3.setAge(3);
		QaUser user4 = new QaUser();
		user4.setAge(4);

		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		
		System.out.println(getPropertyList2("age", users));
	}
	
}
