package kr.ac.kopo.ctc.spring.board.service;

import org.springframework.stereotype.Service;

@Service
public interface BoardItemService {

	void test();

	void testAopBefore();

	void testAopAfter();

	String testAopAfterReturning();

	void testAopAfterThrowing();

	void testAopAround();

//	//aop
//	String testNoAop();
//	String testAop();
	
	//transactional
	String testNoTransactional();
	String testTransactional();

}

