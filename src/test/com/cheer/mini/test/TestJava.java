package com.cheer.mini.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cheer.mini.ums.model.User;

public class TestJava {
	
	
	public static void main(String[] args){
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		if(set != null && set.isEmpty()){
			list.iterator().next();
		}
		
		Object o = new Object();
		if ( o!= null){
			
		}
		String s = "";
		
		if(s != null  && !"".equals(s)){
			
			
		}
		
		User user = null;
		//if(user!= null){
			user.getId();
			user.setId("1212");
		//}
		String a="abc";  // & 100
		String b="def";  // & 200
		String temp = null;
		temp = a;
		a = b;
		b = temp;
			
		int aa = 100 + 100000;
		int bb = 101;
		aa = (aa+ bb);
		bb = (aa-bb);
		aa = (aa - bb);
		
		
		//init 
		
		
	}
	
}
