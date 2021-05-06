package com.learning.db.mybatis;

import java.util.List;

import com.learning.spring.db.PetDVO;
import com.learning.spring.db.mybatis.PetDAO;
import com.learning.spring.db.mybatis.PetDaoImpl;

public class AnnoCursorMain {

	public static void main(String[] args) {
		try {
			AnnoCursorMain main = new AnnoCursorMain();
			main.callReadAllPets();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void callReadAllPets() throws Exception {
		PetDAO petDAO = new PetDaoImpl();
		System.out.println("-- 애완 목록 --");

		List<PetDVO> petList = petDAO.callReadAllPets();
		petList.forEach(System.out::println);
	}
}
