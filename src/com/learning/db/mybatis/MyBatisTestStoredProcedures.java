package com.learning.db.mybatis;

/**
 * 파일 이름: MyBatisTestStoredProcedures.java
 */
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learning.spring.db.mybatis.PetDAO;

public class MyBatisTestStoredProcedures {
	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
					new String[] { "applicationContext-myBatis.xml" });
			PetDAO petDAOImpl = (PetDAO) appContext.getBean("petDaoImpl");
			petDAOImpl.callReadPet();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}