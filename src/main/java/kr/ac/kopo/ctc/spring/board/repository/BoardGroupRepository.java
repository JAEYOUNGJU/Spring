package kr.ac.kopo.ctc.spring.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.ac.kopo.ctc.spring.board.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

public interface BoardGroupRepository extends JpaRepository<BoardGroup, Long> {

	List<BoardGroup> findByName(String name);

}

