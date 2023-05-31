package com.fashion.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fashion.base.BaseService;
import com.fashion.entity.PaymentEntity;

@Controller
@RequestMapping(value = "/payment")
public class PaymentController {

	@GetMapping(value = "/list")
	public String list(Model model,Map<String, String> param) {
		int sotrang = Integer.parseInt(param.getOrDefault("page", "1"));
		List<PaymentEntity> paymentEntities = BaseService.payments(sotrang);
		model.addAttribute("sl",BaseService.countPayment());
		model.addAttribute("payments",paymentEntities);
		return "payment/list";
	}
}
