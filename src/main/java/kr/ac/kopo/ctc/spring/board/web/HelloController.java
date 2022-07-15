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
@RequestMapping(value = "/boardItem")
public class HelloController {
		
	@RequestMapping(value = "") //boardItem 이후에 나올 아래의 url 지정
	public String helloSpringBoot (Model model) {
		model.addAttribute("name", "주재영");
		return "hello";
	}
	
	@RequestMapping(value = "/getParameter")
	public String getParameter(Model model,HttpServletRequest req) {
		String author = req.getParameter("name");
		model.addAttribute("name", author);
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

