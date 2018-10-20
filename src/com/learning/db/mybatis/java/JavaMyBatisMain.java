/** 
 * JavaMyBatisMain.java 
 */
package com.learning.db.mybatis.java;

import java.util.List;

import com.learning.spring.db.PetDVO;

public class JavaMyBatisMain {
	public static void main(String[] args) {
		try {
			JavaMyBatisMain main = new JavaMyBatisMain();
//			main.callReadAllPets();
			main.callReadPet();			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void callReadPet() throws Exception {
		PetDAOAnno petDAOImpl = new PetDAOAnno();
		PetDVO petDVO = new PetDVO();
		petDVO.setName("스륵이");
		petDAOImpl.callReadPet(petDVO);
		System.out.println("찾은 동물 :" + petDVO);
	} 	
	
	private void callReadAllPets() throws Exception {
		PetDAOAnno petDAOImpl = new PetDAOAnno();
		System.out.println("-- 애완동물 목록 ---");
		List<PetDVO> petList = petDAOImpl.callReadAllPets();
		for (PetDVO pet : petList) {
			System.out.println("\t" + pet);
		}
	}
	
}