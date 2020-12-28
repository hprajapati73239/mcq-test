package com.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.Que;
import com.dao.QueDao;


@Controller
public class Actioncontroller {
	
	@RequestMapping("/add_que")
	public String add_que()
	{
		return "add_que";
	}
	
	@Autowired
	QueDao dao;
	
	@RequestMapping(value="/submit",method = RequestMethod.POST)
	public String enter(@ModelAttribute("q") Que q)
	{
		System.out.println(q.getOp1());
		dao.save(q);
		return "add_que";
	}
	
	@RequestMapping("/give_test")
	public String give_test(Model m)
	{
		List<Que> q=dao.getQuestion();
		int s=q.size();
		m.addAttribute("list",q);
		m.addAttribute("s", s);
		return "give_test";
	}
	
	@RequestMapping(value="/eval", method=RequestMethod.POST)
	public String eval(@RequestParam Map<String, String> queryMap,  HttpServletRequest req, HttpServletResponse res,Model m)
	{
		int count=0;
		int s=queryMap.size();
		System.out.println(s);
		for (Map.Entry<String, String> me : queryMap.entrySet()) { 
            Que q=dao.getElementById(Integer.parseInt(me.getKey()));
            System.out.println(q.getC_ans());
            s--;
            if(q.getC_ans().equalsIgnoreCase(me.getValue()))
            {
            	count++;
            }
            if(s==1)
            	break;
            //System.out.println(me.getValue());
            
        }
		Integer c=new Integer(count);
        m.addAttribute("c",c);
		return "score";
	}

}
