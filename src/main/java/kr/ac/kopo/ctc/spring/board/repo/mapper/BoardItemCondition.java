package kr.ac.kopo.ctc.spring.board.repo.mapper;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BoardItemCondition implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	//serialVersionUID를 선언해야 하는 이유는 serialVersionUID값을 저장할 때 클래스 버전이 맞는지 확인하기 위한 용도
	//직렬화 대상
	private Long id;
	private int no;
	private String title;
	private String author;
	private Date created;
	private int view;

	//메서드는 직렬화 대상이 아님
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {

	}
	
}

