package kr.ac.kopo.ctc.spring.board.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import kr.ac.kopo.ctc.spring.board.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@RunWith(SpringRunner.class)
@SpringBootTest // 스프링부트에서 테스트를 작성하기 위한 어노테이션
public class BoardGroupRepositoryTest {

	@Autowired // 스프링에서 빈 인스턴스가 생성된 이후 @Autowired를 설정한 메서드가 자동 호출되고 인스턴스가 자동으로 주입됨
	// 즉, 해당 변수 및 메서드에서 스프링이 관리하는 Bean 을 자동으로 매핑해줌
	BoardGroupRepository boardGroupRepository;

	@Autowired
	BoardItemRepository boardItemRepository;

	@Test
	void selectOne() {
		BoardGroup boardGroup = new BoardGroup();
		boardGroup.setName("학생");
		boardGroupRepository.save(boardGroup);

		BoardItem boardItem1 = new BoardItem();
		boardItem1.setAuthor("이지민");
		boardItem1.setNo(7);
		boardItem1.setTitle("intj");
		boardItem1.setView(0);
		boardItem1.setCreated(new Date());
		boardItem1.setBoardGroup(boardGroup);
		boardItemRepository.save(boardItem1);

		BoardItem boardItem2 = new BoardItem();
		boardItem2.setAuthor("정지훈");
		boardItem2.setNo(5);
		boardItem2.setTitle("istj");
		boardItem2.setView(0);
		boardItem2.setCreated(new Date());
		boardItem2.setBoardGroup(boardGroup);
		boardItemRepository.save(boardItem2);

		BoardItem boardItem3 = new BoardItem();
		boardItem3.setAuthor("주재영");
		boardItem3.setNo(5);
		boardItem3.setTitle("infp");
		boardItem3.setView(0);
		boardItem3.setCreated(new Date());
		boardItem3.setBoardGroup(boardGroup);
		boardItemRepository.save(boardItem3);

		BoardItem boardItem4 = new BoardItem();
		boardItem4.setAuthor("안재형");
		boardItem4.setNo(5);
		boardItem4.setTitle("esfj");
		boardItem4.setView(0);
		boardItem4.setCreated(new Date());
		boardItem4.setBoardGroup(boardGroup);
		boardItemRepository.save(boardItem4);

	}

}

