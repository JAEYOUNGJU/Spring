package kr.ac.kopo.ctc.spring.board.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class BoardGroup {

	@Id
	// 기본키를 자동으로 생성할 때 @GeneratedValue 어노테이션이 함께 사용됨
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "boardGroup")
	// mappedBy 양방향 관계 설정시 관계의 주체가 되는 쪽에서 정의함
	// 부모입장에서 fetch = FetchType.LAZY 은 기본값
	// CascadeType.ALL 이 설정이 되어있으면 boardgroup 이 지울 때 그 안에 있는 boardItem들도 지워지게 되는 것

	private List<BoardItem> boardItems; // BoardItem 호출

	public List<BoardItem> getBoardItems() {
		if (boardItems == null) {
			boardItems = new ArrayList<BoardItem>();
		}
		return boardItems;
	}

	public void setBoardItems(List<BoardItem> boardItems) {
		this.boardItems = boardItems;
	}

	public void addBoardItem(BoardItem b) {
		List<BoardItem> boardItems = getBoardItems();
		boardItems.add(b);
	}

	@Override
	public String toString() {
		String result = "[" + id + "] " + name;
		for (BoardItem b : getBoardItems()) {
			result += "\n" + b.toString();
		}
		return result;
	}
}
