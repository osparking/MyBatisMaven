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
			main.callReadAllPets();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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