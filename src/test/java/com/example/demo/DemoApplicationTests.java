package com.example.demo;

import com.alibaba.fastjson2.JSON;
import com.example.demo.controller.OrderController;
import com.example.demo.entity.TOrder;
import com.example.demo.es.BookIndex;
import com.example.demo.es.BookIndexRes;
import com.example.demo.es.BookService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Resource
	OrderController orderController;

	@Resource
	BookService bookService;


	@Test
	void createIndex(){
		int a= 4300;
		for(int i =0;i<100;i++) {
			BookIndex bookIndex = new BookIndex();
			bookIndex.setPrice(new BigDecimal("9.2").add(BigDecimal.valueOf(i)));
			bookIndex.setBookId(a+i);
			bookIndex.setId(a+i);
			bookIndex.setTitle("java devlop china"+i);
			bookIndex.setAuthor("jiker"+i);
			BookIndex bookIndex1 = bookService.doIndex(bookIndex);
			System.out.println("==========" + JSON.toJSON(bookIndex1));
		}
	}

	@Test
	void getIndexData(){
		List<BookIndex> list = bookService.getIndexData("java");
		System.out.println("--------------"+list.size());
		System.out.println(JSON.toJSONString(list));
	}

	@Test
	void contextLoads() {
		System.out.println("================="+orderController.getOrderInfo(1003704166184386561L,""));
	}

	@Test
	void installOrder(){
		for(int i=0,j=300;i<j;i++) {
			TOrder order = new TOrder();
			order.setOrderName("张三"+i);
			order.setPrice((long) i);
			order.setCreateTime(new Date());
			order.setUpdateTime(new Date());
			orderController.installOrder(order);
		}
	}

	public static void main(String [] arg){
		System.out.println(methon01());
	}
	public static int methon01(){
		try{
			return 1;
		}catch (Exception e){
			return 2;
		}finally {
			return 3;
		}
	}
}
