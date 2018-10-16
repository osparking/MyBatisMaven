package com.learning.spring.db.mybatis;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learning.spring.db.PetDVO;

public class MyBatisMain {

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
					new String[] { "applicationContext-myBatis.xml" });

			PetDAO petDaoImpl = (PetDAO) appContext.getBean("petDaoImpl");
			/**
			 * 애완동물 목록 출력
			 */
//			List <PetDVO> pets = petDaoImpl.getAllPetsData();

			/**
			 * 애완동물 이름으로 찾아 출력
			 */
//			PetDVO pet = petDaoImpl.getPetObject("누리");
//			System.out.println("--- 애완동물 ---");
//			System.out.println(pet);

			/**
			 * 모든 애완 동물 정보 출력
			 */
//			List <PetDVO> pets = petDaoImpl.getAllPetsData();
//			for (PetDVO aPet : pets) {
//				System.out.println(aPet);
//			}

			/**
			 * 모든 애완 동물 종류를 출력
			 */
//			List <String> species = petDaoImpl.getAllSpecies();
//			for (String animal : species) {
//				System.out.println(animal);
//			}
			/**
			 * 모든 애완 동물 암수 구별 목록 채취
			 */
//			List<PetDVO> pets = petDaoImpl.selectByGender("f");
//			for (PetDVO pet : pets) {
//				System.out.println(pet);
//			}

			/**
			 * 애완동물 객체 생성
			 */
//			PetDVO petObj = new PetDVO();
//			petObj.setName("투캅스");
//			petObj.setOwner("피터팬");
//			petObj.setSpecies("파충류");
//			petObj.setSex("m");
//			Calendar cal = Calendar.getInstance();
//			Date today = cal.getTime();
//			petObj.setBirth(today);
//			cal.add(Calendar.YEAR, 20);
//			petObj.setDeath(cal.getTime());
//			int petId = petDaoImpl.createPet(petObj);
//			System.out.println("ID: " + petId);
			
			/**
			 * 투캅스 정보를 일부 수정한다. 투캅스 두 마리 청와대 입양 반영
			 * 수정(갱신) 후, 그 동물의 정보를 출력
			 */
//			PetDVO petDataObj = new PetDVO();
//			String name = "투캅스";
//
//			petDataObj.setOwner("청와대");
//			petDataObj.setName(name);
//			petDataObj.setDeath(null);;
//
//			petDaoImpl.updatePetData(petDataObj);	
//			PetDVO pet = petDaoImpl.getPetObject(name);
//			System.out.println("--- 애완동물 ---");
//			System.out.println(pet);			
			
			/**
			 * 특정 종(species)과 이름이 주어졌을 때 애완동물을 삭제하기
			 */
			HashMap<String, String> inputMap = new HashMap<String, String>();
			int delCnt = petDaoImpl.deletePet("파충류", "투캅스");
			System.out.println("삭제된 애완 동물 수: " + delCnt);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
