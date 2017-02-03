quick start 

	mvn clean package
	
	mvn spring-boot:run
	
	浏览器浏览：
	模拟生成流水号：		http://localhost:8080/f/gen
	模拟用户注册：			http://localhost:8080/f/reg/{userName}
	模拟异常处理：			http://localhost:8080/f/exhandler
	
	更多，见 *Controller.java

参考：

[spring-mvc-quickstart](https://www.tianmaying.com/tutorial/spring-mvc-quickstart)
[rest-service](https://spring.io/guides/gs/rest-service)