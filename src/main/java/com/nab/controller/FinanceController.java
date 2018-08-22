package com.nab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nab.entities.Finance;
import com.nab.service.FinanceService;

@Controller
@RequestMapping("/finance")
public class FinanceController {
	@Autowired
	private FinanceService financeService;

	@RequestMapping("/list-finance")
	public ModelAndView listFiance() {
		ModelAndView mav = new ModelAndView("list-finance");
		return mav;
	}

	@RequestMapping("/getAll")
	@ResponseBody
	public List<Finance> getAll() {
		try {
			List<Finance> list= financeService.getAll();
			return list;
		}catch(Exception e) {
			System.out.println("thanh");
			return null;
		}
		
	}

	@RequestMapping("/getFinances")
	@ResponseBody
	public List<Finance> getFinances(@RequestParam("key") String finance_type) {
		return financeService.getFinances(finance_type);
	}

}