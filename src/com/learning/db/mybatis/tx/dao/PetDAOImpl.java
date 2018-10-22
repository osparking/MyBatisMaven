package com.learning.db.mybatis.tx.dao;

import java.util.Date;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.learning.Util;
import com.learning.spring.db.PetDVO;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.*;
import java.sql.Types;

public class PetDAOImpl implements PetDAO {
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void doInsertAndUpdateInTx() {
		try {
			/**
			 * 행 삽입
			 */
			insertPet();
			/**
			 * Create an error to get the exception
			 */
			int i = 0;
			int j = 100 / i;
			/**
			 * 행 갱신
			 */
			updatePetData();
		} catch (Exception ex) {
			TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
			System.out.println("** 삽입&갱신 성공인가? : " + Util.inKoean(status.isCompleted()));
			status.setRollbackOnly();
		}
	}

	@Override
	public void insertPet() {
		// Data to be inserted
		PetDVO petDVO = new PetDVO();
		petDVO.setName("Slimmy");
		petDVO.setOwner("John");
		petDVO.setSpecies("Snake");
		petDVO.setSex("f");
		petDVO.setBirth(new Date());

		HashMap<String, Object> inputMap = new HashMap<String, Object>();
		inputMap.put("name", petDVO.getName());
		inputMap.put("owner", petDVO.getOwner());
		inputMap.put("species", petDVO.getSpecies());
		inputMap.put("sex", petDVO.getSex());
		inputMap.put("birth", petDVO.getBirth());
		sqlSessionTemplate.insert("createPet", inputMap);
	}

	@Override
	public void updatePetData() {
		/**
		 * 뱀 이름을 바꾼다.
		 */
		PetDVO petDVO = new PetDVO();
		petDVO.setName("Slimmy");
		petDVO.setSex("f");
		petDVO.setBirth(new Date());
		HashMap<String, Object> inputMap = new HashMap<String, Object>();
		inputMap.put("birth", petDVO.getBirth());
		inputMap.put("sex", petDVO.getSex());
		inputMap.put("name", petDVO.getName());
		sqlSessionTemplate.update("updatePetData", inputMap);
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
}
