package com.fashion.base;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.fashion.entity.CalculateEntity;
import com.fashion.entity.CartDetailEntity;

public class MySessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
        List<CartDetailEntity> lokk = (List<CartDetailEntity>) session.getAttribute("listct");
        if (lokk != null) {
          //Khi mà sesion chết thì xóa bảng calculidate 
          String tc =  BaseService.deleteAllCalculate();
          System.out.println(tc);
        }
		
	}

}
