package com.learning.db.mybatis;

import com.learning.spring.db.PetDVO;
import com.learning.spring.db.mybatis.PetDAO;
import com.learning.spring.db.mybatis.PetDaoImpl;

public class AnnoMain {

	public static void main(String[] args) {
		try {
			AnnoMain main = new AnnoMain();
			main.callReadPet();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void callReadPet() throws Exception {
		PetDVO slower = new PetDVO();
		slower.setName("스륵이");
		PetDAO petDao = new PetDaoImpl();
		petDao.callReadPet(slower);
		System.out.println(slower);
	}
}
