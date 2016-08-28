package com.cheer.mini.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cheer.mini.ums.model.Order;
import com.cheer.mini.ums.model.OrderItem;
import com.cheer.mini.ums.model.User;
import com.cheer.mini.ums.service.OrderService;
import com.cheer.mini.ums.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring-dao.xml","classpath:config/spring-service.xml"})
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;
    
    //private Logger logger = Logger.getLogger(this.getClass().getName()); 
    
    
    @Test
    public void testSave() {
    	for(int i=0;i<10;i++){
    		saveOrder(i);
    	}
    }
    
    private void saveOrder(int i){	
    	Order orderInfo = new Order();
    	
    	orderInfo.setTitle("Uter"+i+" 's Order");
    	orderInfo.setAmount(new BigDecimal("180.00").
    			setScale(2, BigDecimal.ROUND_HALF_UP));
        
    	List<OrderItem> items = new ArrayList<OrderItem>();
    	
    	{
	    	OrderItem item = new OrderItem();
	    	item.setProductName("苹果");
	    	item.setNumber(3);
	    	item.setPrice(new BigDecimal("10"));
	    	items.add(item);
    	}
    	
    	{
	    	OrderItem item = new OrderItem();
	    	item.setProductName("香蕉");
	    	item.setNumber(5);
	    	item.setPrice(new BigDecimal("20"));
	    	items.add(item);
    	}
    	
    	{
	    	OrderItem item = new OrderItem();
	    	item.setProductName("西瓜");
	    	item.setNumber(2);
	    	item.setPrice(new BigDecimal("30"));
	    	items.add(item);
    	}
    	
    	orderInfo.setItems(items);
    	
    	orderService.save(orderInfo);
    }
    
    
    
}
