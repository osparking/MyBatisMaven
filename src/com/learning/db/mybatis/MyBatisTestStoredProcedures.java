package com.learning.db.mybatis;

import java.util.List;

/**
 * 파일 이름: MyBatisTestStoredProcedures.java
 */
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learning.spring.db.PetDVO;
import com.learning.spring.db.mybatis.PetDAO;

public class MyBatisTestStoredProcedures {
	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
					new String[] { "applicationContext-myBatis.xml" });
			PetDAO petDAOImpl = (PetDAO) appContext.getBean("petDaoImpl");

			/**
			 * 예제 3
			 */
			petDAOImpl.callPetOwnerFunction();

			/**
			 * 예제 2
			 */
//			List<PetDVO> procResult = petDAOImpl.callReadAllPets();
//			/**
//			 * 애완동물 목록을 콘솔에 출력한다.
//			 */
//			System.out.println("--애완동물 수: " + procResult.size());
//
//			for (PetDVO petDVObj : procResult) {
//				System.out.println("----동물 이름: " + petDVObj.getName());
//			}

			/**
			 * 예제 1
			 */
//			petDAOImpl.callReadPet();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}