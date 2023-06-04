package com.fashion.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fashion.base.BaseService;
import com.fashion.entity.PaymentEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping(value = "/payment")
public class PaymentController {

	@GetMapping(value = "/list")
	public String list(Model model, Map<String, String> param) {
		int sotrang = Integer.parseInt(param.getOrDefault("page", "1"));
		List<PaymentEntity> paymentEntities = BaseService.payments(sotrang);
		model.addAttribute("sl", BaseService.countPayment());
		model.addAttribute("payments", paymentEntities);
		return "payment/list";
	}


	@GetMapping(value = "/successfully")
	public String successfully(HttpServletRequest request, Model model) throws ParseException {
		HttpSession session =  request.getSession(true);
		String amount = request.getParameter("vnp_Amount");
		String bankCode = request.getParameter("vnp_BankCode");
		String curentCode = request.getParameter("vnp_Locale");
		String vndCardType = request.getParameter("vnp_CardType");
		String codeOrder = request.getParameter("vnp_TxnRef");// Ma giao dich
		String dateString = request.getParameter("vnp_PayDate");

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		Date utilDate = formatter.parse(dateString);
		Date date = new Date(utilDate.getTime());

		String responseCode = request.getParameter("vnp_ResponseCode");

		PaymentEntity paymentEntity = new PaymentEntity();

		Long amoutMoney = (Long.valueOf(amount) / 100);
		paymentEntity.setAmount(amoutMoney);
		paymentEntity.setBankCode(bankCode);
		paymentEntity.setCardType(vndCardType);
		paymentEntity.setCurrency(curentCode);
		paymentEntity.setResponse(responseCode);
		paymentEntity.setDatePayment(date);
		paymentEntity.setIdhd(Integer.valueOf(codeOrder));
		Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String data = gs.toJson(paymentEntity);
		int idOk = BaseService.savePayment(data);
		if (idOk != 1) {
			model.addAttribute("paymentError", "Thanh toán thất bại");
		}
		
		int id = (Integer) session.getAttribute("billId");

		return "redirect:/xem-chi-tiet/" + id;
	}

}
