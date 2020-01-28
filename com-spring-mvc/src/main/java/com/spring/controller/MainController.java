package com.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.entities.Book;
import com.spring.entities.FileUploadBean;
import com.spring.entities.Users;
import com.spring.excelreportgeneration.GenerateExcelReport;
import com.spring.serviceapi.ServiceApi;
import com.spring.serviceimpl.CustomSecurity;

@Controller
public class MainController {

	private static final Log log = LogFactory.getLog(MainController.class);
	@Autowired
	ServiceApi service;

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/homePage")
	public String homePage() {
		return "homePage";
	}

	@GetMapping("/success")
	public String successPage() {
		return "success";
	}

	@GetMapping("/signUp")
	public String getSignUpPage() {
		return "signUp";
	}

	@PostMapping("/signup")
	public String signUp(@ModelAttribute Users users) {

		System.out.println(users.getUserName());
		if (service.signUpUser(users)) {

			return "login";
		}
		return "signUp";

	}

	@PostMapping("/uploadfile")
	public String submit(@RequestParam MultipartFile file, Model model, int id) throws IOException {
		Users users = new Users();
		if (file != null) {
			System.out.println("if1");
			users.setFile(file.getBytes());
		}

		System.out.println(file.getInputStream());
		System.out.println(users.getFile());
		System.out.println("inside submit");
		users.setUserId(id);
		if (service.saveFile(users)) {
			System.out.println("inside save");
			return "success";
		}
		return "failure";
	}

	@GetMapping("/generateReport")
	public ModelAndView excelReport() {
		List<Users> UserList = service.getUser();

		return new ModelAndView(new GenerateExcelReport(), "userList", UserList);

	}

	@GetMapping("/ReportPage")
	public ModelAndView loadReportsPage() {
		ModelAndView mv = new ModelAndView("ReportPage");
		return mv;
	}

	@GetMapping("/AddBooks")
	public String addBookPage() {
		return "AddBooks";
	}

	@PostMapping("/addBook")
	public ModelAndView addBook(@ModelAttribute Book book) {
		ModelMap model = new ModelMap();

		boolean b = service.addBook(book);
		model.addAttribute(book);
		if (b) {
			return new ModelAndView("view", model);
		}
		return new ModelAndView("AddBooks");
	}
}
