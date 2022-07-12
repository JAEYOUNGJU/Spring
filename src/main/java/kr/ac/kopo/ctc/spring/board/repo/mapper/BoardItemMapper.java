package kr.ac.kopo.ctc.spring.board.repo.mapper;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@Mapper
@Repository
public interface BoardItemMapper {
	//to do -> create(insert), selectOne, selectAll, selectAll(search), selectAll(page)
	// selectAll(search + page), update, delete 
	
	//selectAll
	List<BoardItem> findAll();
	
	//selectAll(search + page)
	List<BoardItem> findAllByCondition(BoardItemCondition condition, RowBounds rowBounds);
	
	//selectAll(search)
	List<BoardItem> findByTitle(String title);
	
	//selectAll(page)
	List<BoardItem> findAll(Pageable pageable);
		
	//selectOne
	Optional<BoardItem> selectOne(Long id);
	
	//create(insert)
	int insertContent(BoardItem boardItem);
	
	//update
	int update(BoardItem boardItem);
	
	//delete
	void deleteContent(int no);

}

