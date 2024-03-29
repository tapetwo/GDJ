package com.gdu.app11.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app11.service.EmpService;

@Controller // 나는 컨트롤러다~
public class EmpController {
	
	
	
	@Autowired
	private EmpService empService;
	
	
	@GetMapping("/")
	public String welcome() {
		return "index";
	}

	
	@GetMapping("/emp/list") // "emp/list" emp앞 슬래시는 있어도 그만 없어도 그만
	public String list(HttpServletRequest request, Model moodel) {
		empService.findAllEmployees(request, moodel);
		return "employee/list";
	}

	@GetMapping("/emp/search")
	public String search(HttpServletRequest request, Model model) {
		empService.findEmployees(request, model);
		return "employee/list";
	}
	
	@ResponseBody // ajax 처리시 필수
	@GetMapping(value="/emp/autoComplete", produces="application/json")
	public Map<String, Object> autoComplete(HttpServletRequest request) {
		return empService.findAutoCompleteList(request);
	}
	
}
