package com.lingjoin.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lingjoin.demo.NlpirMethod;

@Controller
@RequestMapping(value = "/paragraph")
public class GeneralController {

	@RequestMapping(value = "init.do", method = RequestMethod.GET)
	public String init() {
		return "index";
	}

	@RequestMapping(value = "get.do", method = RequestMethod.POST)
	public String get(HttpServletRequest request, HttpServletResponse response, Model model) {

		try {
			request.setCharacterEncoding("UTF-8");
			String content = request.getParameter("content");
			String result = NlpirMethod.NLPIR_ParagraphProcess(content, 1);
			model.addAttribute("liming", result);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "index";
	}
}
