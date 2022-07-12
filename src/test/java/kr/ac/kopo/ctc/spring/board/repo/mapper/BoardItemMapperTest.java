package kr.ac.kopo.ctc.spring.board.repo.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@SpringBootTest
@WebAppConfiguration
public class BoardItemMapperTest {

	@Autowired
	BoardItemMapper boardItemMapper;

//selectAll
	@Test
	public void findAll() {
		List<BoardItem> boardItems = boardItemMapper.findAll();
		for (BoardItem boardItem : boardItems) {
			System.out.println(boardItem.getTitle());
		}
	}

//selectAll(search + page)
	@Test
	public void findAllByCondition() {

		BoardItemCondition boardItemCondition = new BoardItemCondition();
		boardItemCondition.setAuthor("주재영");

		RowBounds rowBounds = new RowBounds(0, 10);

		List<BoardItem> boardItems = boardItemMapper.findAllByCondition(boardItemCondition, rowBounds);
		for (BoardItem boardItem : boardItems) {
			System.out.println(boardItem.getAuthor());

		}
	}

//create
	@Test
	public void insertContent() {
		BoardItem boardItem = new BoardItem();
		boardItem.setId(10L);
		boardItem.setAuthor("이효리");
		boardItem.setTitle("모름");
		boardItem.setNo(5);
		boardItem.setCreated(new Date());
		boardItem.setView(0);
		boardItemMapper.insertContent(boardItem);
	}

// update
	@Test
	public void update() {
		BoardItem boardItem = new BoardItem();
		boardItem.setId(6L);
		boardItem.setAuthor("수정이");
		boardItem.setCreated(new Date());
		boardItem.setNo(3);
		boardItem.setTitle("mbti");
		boardItemMapper.update(boardItem);
	}

//selectOne
	@Test
	void selectOne() {
		Optional<BoardItem> boardItem = boardItemMapper.selectOne(7L);
	}

//pagination
	@Test
	public void pagination() {
		Pageable page = PageRequest.of(0, 3);
		List<BoardItem> boardItemPage = boardItemMapper.findAll(page);
	}

//search
	@Test
	public void findByTitle() {
		List<BoardItem> boardItemPage = boardItemMapper.findByTitle("istj");

	}

// delete
	@Test
	void deleteContent() {
		boardItemMapper.deleteContent(1);
	}

}
