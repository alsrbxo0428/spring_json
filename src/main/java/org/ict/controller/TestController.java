package org.ict.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ict.domain.MemberVO;
import org.ict.domain.TestVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello Hello";
	}//sayHello
	
	@RequestMapping("/sendVO")
	public TestVO sendTestVO() {
		TestVO testVO = new TestVO();
		
		testVO.setName("민규태");
		testVO.setAge(24);
		testVO.setMno(1);
		
		return testVO;
	}//sendTestVO
	
	@RequestMapping("/sendVOList")
	public List<TestVO> sendVoList(){
		List<TestVO> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			TestVO vo = new TestVO();
			vo.setMno(i);
			vo.setName(i + "규태");
			vo.setAge(i + 20);
			list.add(vo);
		}
		return list;
	}//sendVoList
	
	@RequestMapping("/self")
	public List<MemberVO> selfTest() {
		List<MemberVO> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			MemberVO vo = new MemberVO();
			vo.setMno(i);
			vo.setMid("mid" + i);
			vo.setPwd("pwd" + i);
			vo.setName("규태" + i);
			vo.setPcode("우편번호" + i);
			vo.setAddr1("주소" + i);
			vo.setAddr2("상세주소" + i);
			vo.setTel1("010");
			vo.setTel2("" + i);
			vo.setTel3("" + i);
			Date date = new Date(System.currentTimeMillis());
			vo.setRegdate(date);
			list.add(vo);
		}
		return list;
	}//selfTest
	
	@RequestMapping("/sendMap")
	public Map<Integer, TestVO> sendMap(){
		Map<Integer, TestVO> map = new HashMap<>();
		
		for(int i = 0; i < 10; i++) {
			TestVO vo = new TestVO();
			vo.setName("채종훈");
			vo.setMno(i);
			vo.setAge(50+i);
			map.put(i, vo);
		}
		return map;
	}//sendMap
	
	@RequestMapping("/sendErrorAuth")
	public ResponseEntity<Void> sendListAuth() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}//sendListAuth
	
	@RequestMapping("/sendErrorNot")
	public ResponseEntity<List<TestVO>> sendListNot() {
		List<TestVO> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			TestVO vo = new TestVO();
			vo.setMno(i);
			vo.setName(i + "규태");
			vo.setAge(i + 20);
			list.add(vo);
		}
		return new ResponseEntity<List<TestVO>>(list, HttpStatus.NOT_FOUND);
	}//sendListNot
}//class