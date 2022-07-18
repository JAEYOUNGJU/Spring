package kr.ac.kopo.ctc.spring.board.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@Controller
@RequestMapping(value = "/boardItem") //공통적인 URL은 class에 @RequestMapping으로 설정
public class HelloController {
		

	@RequestMapping(value = "")
	public String helloSpringBoot (Model model) {
		model.addAttribute("name", "주재영");
		return "hello";
	}
	
	@RequestMapping(value = "/getParameter") // URL부분에 /boardItem/get.Parameter 입력할 경우 
	public String getParameter(Model model,HttpServletRequest req) {
		String author = req.getParameter("name");// 객체 req에 저장된 name 데이터를 꺼냄
		model.addAttribute("name", author); //해당 메서드를 이용해 view에 전달할 데이터를 name, author 으로 묶어 전달 
		return "hello";
	}
	@RequestMapping(value = "/requestParam")
	public String requestParam(Model model,@RequestParam(value="name") String name) {
		model.addAttribute("name", name);
		return "hello";
	}
	@RequestMapping(value = "/pathVariable/{name}")
	public String pathVariable(Model model, @PathVariable("name") String name) {
		model.addAttribute("name", name);
		return "hello";
	}
	@RequestMapping(value = "/modelAttribute")
	public String modelAttribute(Model model, @ModelAttribute BoardItem boardItem) {
		model.addAttribute("name", boardItem.getAuthor());
		return "hello";
	}
	
	//스프링에서 비동기 처리를 하는 경우 RequestBody
	@RequestMapping(value = "/requestBody1")
	public String requestBody1(Model model, @RequestBody Map<String, Object> obj) {
		model.addAttribute("name", obj.get("name"));
		return "hello";
	}
	@RequestMapping(value = "/requestBody2")
	public String requestBody2(Model model, @RequestBody BoardItem boardItem) {
		model.addAttribute("name", boardItem.getAuthor());
		return "hello";
	}
}

