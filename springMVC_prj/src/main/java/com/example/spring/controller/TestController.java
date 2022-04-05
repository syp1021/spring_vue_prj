package com.example.spring.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.spring.vo.TestVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TestController {
	
	@Autowired(required = false)
	private JdbcTemplate jt;
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		String query = "select AUTHOR_NM from comtnauthorinfo";
		
		List<TestVO> list = null;
		
		list = jt.query(query, new RowMapper<TestVO>(){

			@Override
			public TestVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				TestVO vo = new TestVO();
				vo.setData(rs.getString("AUTHOR_NM"));
				System.out.println(vo.getData());
				return vo;
			}
		});
		return "home";
	}
	
}
