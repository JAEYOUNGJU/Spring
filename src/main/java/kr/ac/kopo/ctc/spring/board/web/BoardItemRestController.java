package kr.ac.kopo.ctc.spring.board.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.ctc.spring.board.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.board.domain.BoardItem;
import kr.ac.kopo.ctc.spring.board.repository.BoardGroupRepository;
import kr.ac.kopo.ctc.spring.board.repository.BoardItemRepository;

@RestController
@RequestMapping(value = "/rest")
//@Service
public class BoardItemRestController {

	@Autowired
	BoardGroupRepository boardGroupRepository;

	@Autowired
	BoardItemRepository boardItemRepository;
	
	@RequestMapping(value = "/boardItem2")
	public BoardGroup boardgroup() {
		BoardGroup boardgroup = boardGroupRepository.findById(1L).get();
		return boardgroup;
	}

	@Test
	@RequestMapping(value = "/boardItems2")
	public List<BoardItem> boardItem2() {
		BoardItem boardItem1 = boardItemRepository.findById(1L).get();

		BoardItem boardItem2 = boardItemRepository.findById(2L).get();
		List<BoardItem> boardItems = new ArrayList<BoardItem>();

		BoardItem boardItem3 = boardItemRepository.findById(3L).get();
		List<BoardItem> boardItemss = new ArrayList<BoardItem>();
		
		BoardItem boardItem4 = boardItemRepository.findById(3L).get();
		List<BoardItem> boardItemsss = new ArrayList<BoardItem>();
		
		boardItems.add(boardItem1);
		boardItems.add(boardItem2);
		boardItems.add(boardItem3);
		boardItems.add(boardItem4);
		return boardItems;
	}

}

