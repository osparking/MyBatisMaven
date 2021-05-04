package com.learning.spring.db.mybatis.core;

import java.io.InputStream;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.learning.spring.db.PetDVO;

public class CoreMyBatisMain {

	public static void main(String[] args) {
		try {
			CoreMyBatisMain main = new CoreMyBatisMain();
			// Case 1. 하나의 영역 객체 읽기
//			String name = "스륵이";
//			PetDVO aPet = main.getPetObject(name);
//			System.out.println("이름: " + name);
//			System.out.println("\t종류: " + aPet.getSpecies());
//			System.out.println("\t주인: " + aPet.getOwner());

			// Case 2. 애완동물 마리수 출력
//			List<PetDVO> allPets = main.getAllPetsData();
//			System.out.println("--- 애완동물 숫자 ----" + allPets.size());

			// Case 3. 애완동물 종류 목록 출력
//			System.out.println(main.getAllSpecies());

			/**
			 * Case 4. 애완동물 암수별 목록 력
			 */
//			System.out.println("암놈 목록");
//			for (PetDVO pet : main.selectByGender("f")) {
//				System.out.println(pet);
//			}
//			System.out.println("숫놈 목록");
//			for (PetDVO pet : main.selectByGender("m")) {
//				System.out.println(pet);
//			}

			/**
			 * 애완동물 객체 생성
			 */
//			PetDVO petObj = new PetDVO();
//			petObj.setName("따래쟁이");
//			petObj.setOwner("정숙자");
//			petObj.setSpecies("앵무새");
//			petObj.setSex("m");
//			Date today = new Date();
//			petObj.setBirth(today);
			/**
			 * 생성된 애완동물을 DB pet 테이블에 삽입
			 */
//			int id = main.createPet(petObj);
//			System.out.println("새 애완동물 ID : " + id);

//				inputMap.put("owner", petDVO.getBirth());
//				inputMap.put("species", petDVO. );
//				inputMap.put("sex", petDVO.getSex());		
//				inputMap.put("birth", petDVO.getBirth());
//				inputMap.put("death", petDVO.getDeath());
//				inputMap.put("name", petDVO.getName());
//				
			/**
			 * Slimmmy 정보를 일부 수정한다. ID, 이름, 출생일 제외
			 */
//			PetDVO petDataObj = new PetDVO();
//			String name = "Slimmmy";
//
//			petDataObj.setOwner("이면");
//			petDataObj.setSpecies("고양이");
//			petDataObj.setSex("m");
//			petDataObj.setDeath(getDate("1592-10-15"));
//			petDataObj.setName(name);

			/**
			 * 테이블 자료 갱신
			 */
//			main.updatePetData(petDataObj);

			/**
			 * 갱신된 행 채취하여 내용 출력
			 */
//			System.out.println(main.getPetObject(name));

			/**
			 * 애완 동물 삭제 코드 시험
			 */
//			String catName = "나비";
//			PetDVO pet = main.getPetObject(catName);
//
//			System.out.println("삭제 전: " + ((pet == null) ? "그런 동물 없습니다." : pet));
//			main.deletePet("고양이", catName);
//
//			pet = main.getPetObject(catName);
//			System.out.println("삭제 후: " + ((pet == null) ? "그런 동물 없습니다." : pet));

			/**
			 * 모든 뱀 애완 동물을 찾아서 출력
			 */
//			List<PetDVO> allSnakes = main.findSomePets();
//			System.out.println("--- 뱀 애완 동물들 ---");
//			System.out.println(allSnakes);

//			List<PetDVO> snakePets = main.findSnakePets();
//			System.out.println("--- 뱀 애완 동물 2 ---");
//			System.out.println(snakePets);

//			List<PetDVO> selectedPets = main.selectPetsIn();
//			System.out.println("--- 선택 종에 포함되는 애완 동물들 ---");
//			for (PetDVO pet : selectedPets)
//				System.out.println(pet);

			/**
			 * 자료를 갱신한다.
			 */
			/**
			 * 뱀의 생일을 만든다.
			 */
			PetDVO petDVO = new PetDVO();
			petDVO.setName("스륵이");
			petDVO.setSex("M");
			petDVO.setBirth(LocalDate.of(1999, 9, 9));
			petDVO.setDeath(LocalDate.of(2022, 12, 12));
			main.updatePetDynamically(petDVO);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static Date getDate(String dateString) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date diedOn = null;
		try {
			diedOn = df.parse(dateString);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return diedOn;
	}

	private static SqlSession getSqlSession() throws Exception {
		String resource = "core-mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory.openSession();
	}

	public PetDVO getPetObject(String petName) throws Exception {
		HashMap<String, String> inputMap = new HashMap<String, String>();
		inputMap.put("name", petName);
		return (PetDVO) getSqlSession().selectOne("getPetObject", inputMap);
	}

	public List<PetDVO> getAllPetsData() throws Exception {
		return getSqlSession().selectList("getAllPets");
	}

	public List<PetDVO> findSomePets() throws Exception {
		HashMap<String, String> inputMap = new HashMap<String, String>();
		inputMap.put("species", "뱀");
		inputMap.put("sex", "m");
//		inputMap.put("owner", "남%");
		return getSqlSession().selectList("findSomePets", inputMap);
	}

	public List<PetDVO> findSnakePets() throws Exception {
		HashMap<String, String> inputMap = new HashMap<String, String>();
		inputMap.put("species", "뱀");
		inputMap.put("sex", "m");
		inputMap.put("owner", "종%");
		return getSqlSession().selectList("findSnakePets", inputMap);
	}

	public List<PetDVO> selectPetsIn() throws Exception {
		HashMap<String, Object> inputMap = new HashMap<String, Object>();
		List<String> speciesList = new ArrayList<String>();
		speciesList.add("강아지");
		speciesList.add("고양이");
		speciesList.add("뱀");
		inputMap.put("speciesList", speciesList);
		return getSqlSession().selectList("selectPetsIn", inputMap);
	}

public void updatePetDynamically(PetDVO petDVO) throws Exception {
	HashMap<String, Object> inputMap = new HashMap<String, Object>();
	inputMap.put("birth", petDVO.getBirth());
	inputMap.put("death", petDVO.getDeath());
	inputMap.put("sex", petDVO.getSex());
	inputMap.put("name", petDVO.getName());
	System.out.println("--- 갱신 정보 지도 ---" + inputMap);
	SqlSession sqlSession = getSqlSession();
	sqlSession.update("updatePetDynamically", inputMap);
	sqlSession.commit();
}

	public List<String> getAllSpecies() throws Exception {
		return getSqlSession().selectList("getAllSpecies");
	}

	public List<PetDVO> selectByGender(String sex) throws Exception {
		HashMap<String, String> inputMap = new HashMap<String, String>();
		inputMap.put("sex", sex);
		return getSqlSession().selectList("selectByGender", inputMap);
	}

	public int createPet(PetDVO petDVO) throws Exception {
		HashMap<String, Object> inputMap = new HashMap<String, Object>();
		inputMap.put("name", petDVO.getName());
		inputMap.put("owner", petDVO.getOwner());
		inputMap.put("species", petDVO.getSpecies());
		inputMap.put("sex", petDVO.getSex());
		inputMap.put("birth", petDVO.getBirth());

		/**
		 * Get the sql session and commit the data
		 */
		SqlSession sqlSession = getSqlSession();
		sqlSession.insert("createPet", inputMap);
		sqlSession.commit();

		BigInteger newID = (BigInteger) inputMap.get("id");
		return newID.intValue();
	}

	public void updatePetData(PetDVO petDVO) throws Exception {
		HashMap<String, Object> inputMap = new HashMap<String, Object>();

		inputMap.put("owner", petDVO.getOwner());
		inputMap.put("species", petDVO.getSpecies());
		inputMap.put("sex", petDVO.getSex());
		inputMap.put("birth", petDVO.getBirth());
		inputMap.put("death", petDVO.getDeath());
		inputMap.put("name", petDVO.getName());

		SqlSession sqlSession = getSqlSession();
		sqlSession.update("updatePetData", inputMap);
		sqlSession.commit();
	}

	/**
	 * @param species 삭제할 동물의 종류(예, 고양이, 강아지, 등)
	 * @param name    애완동물 애칭(나비, 힌둥이, 등)
	 * @throws Exception
	 */
	public void deletePet(String species, String name) throws Exception {
		HashMap<String, String> inputMap = new HashMap<String, String>();
		inputMap.put("species", species);
		inputMap.put("name", name);
		System.out.println("--- 애완동물 삭제 ---" + inputMap);
		SqlSession sqlSession = getSqlSession();
		sqlSession.update("deletePet", inputMap);
		sqlSession.commit();
	}
}
