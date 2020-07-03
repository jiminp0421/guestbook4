package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.BookDao;
import com.javaex.vo.GuestVo;


@Controller
@RequestMapping("/guest")
public class GuestController {

	
	@RequestMapping(value="/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		//System.out.println("listtest");
		BookDao bookDao = new BookDao();
		List<GuestVo> gList = bookDao.select();
		
		model.addAttribute("gList",gList);
		
		
		return "/WEB-INF/views/addList.jsp";
	}
	
	@RequestMapping(value="/insert", method = {RequestMethod.GET, RequestMethod.POST})
	public String insert(@ModelAttribute GuestVo guest) {
		System.out.println("/insert");
		System.out.println(guest.toString());
		
		BookDao bookDao = new BookDao();
		bookDao.insert(guest);
		
	
		return "redirect:/guest/list";
	}
	
	@RequestMapping(value = "deleteForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm() {
		
		return "/WEB-INF/views/deleteForm.jsp";
	}
	
	@RequestMapping(value="delete", method = {RequestMethod.GET})
	public String delete(@RequestParam("no") int no, @RequestParam("pw") String pw ) {
		
		BookDao bookDao = new BookDao();
		bookDao.delete(no, pw);
		
		return "redirect:/guest/list";
	}
	


}
