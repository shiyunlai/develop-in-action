package org.syl.inaction.springboot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * Hello world!
 * Demo for Spring Boot
 * ref: https://www.tianmaying.com/tutorial/spring-mvc-quickstart
 * ref: https://spring.io/guides/gs/rest-service/
 * 
 * </pre>
 *
 */
@SpringBootApplication   //@SpringBootApplication 只需要使用一次,建议在主启动类上
@RestController()
@RequestMapping("/f")
public class SpringBootApplicationDemo
{
	
	/**
	 * 模拟提供流水号
	 * @return
	 */
	@RequestMapping("/gen")
	public String genSerialNo(){
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS") ;
		return df.format(new Date()) ;
	}

	/*
	 * 以下三种写法等价
	 * @RequestMapping("/reg/{userName}")
	 * @RequestMapping(value="/reg/{userName}",method=RequestMethod.GET)
	 * @GetMapping("/reg/{userName}")
	 */
	/**
	 * 模拟提供注册服务
	 * @param name
	 * @return
	 */
	@GetMapping("/reg/{userName}")
	public String register(@PathVariable("userName") String name){
		return "你注册成功:" + name;
	}
	
	@GetMapping("/exhandler") 
	public void testExceptionHandler(){
		int a = 1/0 ;
	}
	
	/*
	 * 启动：
	 * 方式一：eclipse中运行本java类
	 * 方式二：mvn spring-boot:run
	 * 方式三：java -jar target/in-action-springboot-0.0.1-SNAPSHOT.jar
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplicationDemo.class, args) ;
	}
}
