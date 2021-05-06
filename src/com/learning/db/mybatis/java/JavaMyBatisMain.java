//JavaMyBatisMain.java 
package com.learning.db.mybatis.java;

import java.util.Date;
import java.util.List;

import com.learning.spring.db.PetDVO;

public class JavaMyBatisMain {

	public static void main(String[] args) {
		try {
			JavaMyBatisMain main = new JavaMyBatisMain();
			/**
			 * 모든 애완 동물을 추출한다.
			 */
			main.selectAllPets();
			main.insertPet();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void getPetObject() throws Exception {
		PetDAOImpl petDAOImpl = new PetDAOImpl();
		PetDVO pet = petDAOImpl.getPetObject("누리");
		System.out.println("----- pet ------" + pet);
	}

	private void getAllPetsData() throws Exception {
		PetDAOImpl petDAOImpl = new PetDAOImpl();
		List<PetDVO> allPets = petDAOImpl.getAllPetsData();
		System.out.println("----- size ------" + allPets.size());
	}

	private void selectPets() throws Exception {
		PetDAOImpl petDAOImpl = new PetDAOImpl();
		List<PetDVO> allPetsData = petDAOImpl.selectPets("f");
		System.out.println("----- size ------" + allPetsData.size());
	}

	private void selectAllPets() throws Exception {
		PetDAOImpl petDAOImpl = new PetDAOImpl();
		List<PetDVO> allPetsData = petDAOImpl.selectAllPets();
		System.out.println("----- size ------" + allPetsData.size());
	}

	private void updatePetData() throws Exception {
		PetDAOImpl petDAOImpl = new PetDAOImpl();
		PetDVO petDataObj = new PetDVO();
		petDataObj.setName("스륵이");
		petDataObj.setSex("m");
		petDataObj.setBirth(new Date());
		petDAOImpl.updatePetData(petDataObj);
	}

	private void updateData() throws Exception {
		PetDAOImpl petDAOImpl = new PetDAOImpl();
		PetDVO petDataObj = new PetDVO();
		petDataObj.setName("스륵이");
		petDataObj.setSex("m");
		petDataObj.setBirth(new Date());
		petDAOImpl.updateData(new Date(), "m", "Slim");
	}

	private void deletePet() throws Exception {
		PetDAOImpl petDAOImpl = new PetDAOImpl();
		PetDVO petDVO = new PetDVO();
		petDVO.setName("스륵이1");
		petDVO.setSpecies("snake");
		petDAOImpl.deletePet(petDVO);
	}

	private void insertPet() throws Exception {
		PetDAOImpl petDAOImpl = new PetDAOImpl();
		PetDVO petObj = new PetDVO();
		petObj.setName("알록달록4");
		petObj.setOwner("땅군");
		petObj.setSpecies("뱀");
		petObj.setSex("f");
		petObj.setBirth(new Date());
		petDAOImpl.insertPet(petObj);
		/**
		 * 생성된 행의 ID 채취하여 콘솔 출력
		 */
		System.out.println("--- " + petObj.getName() + " ID : " 
				+ petObj.getId());		
	}
}
