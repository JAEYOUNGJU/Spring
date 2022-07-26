package kr.ac.kopo.ctc.spring.board.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;
import kr.ac.kopo.ctc.spring.board.repository.BoardItemRepository;

@Service
public class BoardItemServiceImpl implements BoardItemService {

	@Override
	public void test() {
		System.out.println("BoardItemServiceImpl.test() 메소드 호출");
		
	}

	@Override
	public void testAopBefore() {
		System.out.println("BoardItemServiceImpl.testAopBefore() 메소드 호출");
	}

	@Override
	public void testAopAfter() {
		System.out.println("BoardItemServiceImpl.testAopAfter() 메소드 호출");
	}

	@Override
	public String testAopAfterReturning() {
		System.out.println("BoardItemServiceImpl.testAopAfterReturning() 메소드 호출");
		return "Success";
	}

	@Override
	public void testAopAfterThrowing() {
		System.out.println("BoardItemServiceImpl.testAopAfterThrowing() 메소드 호출");
		throw new RuntimeException("runtime exception 발생");
	}

	@Override
	public void testAopAround() {
		System.out.println("BoardItemServiceImpl.testAopAround() 메소드 호출");
	}

	@Autowired
	BoardItemRepository boardItemRepository;

	@Override
	public String testNoTransactional() {
		BoardItem boardItem = boardItemRepository.findById(3L).get();
		boardItem.setTitle("update - no transactional");
		boardItemRepository.save(boardItem);

		throw new RuntimeException("Spring Boot No Transactional Test");

	}

	@Override
	@Transactional
	public String testTransactional() {
		BoardItem boardItem = boardItemRepository.findById(4L).get();
		boardItem.setTitle("update - transactional");
		boardItemRepository.save(boardItem);

		throw new RuntimeException("Spring Boot Transactional Test");
	}

}
