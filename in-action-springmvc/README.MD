＃ 资料博客地址： 
	
	[Spring MVC 入门](http://www.cnblogs.com/fangjian0423/p/springMVC-introduction.html)

＃ 涉及知识：
	
	* 1、Spring MVC
	* 2、Hibernate
	* 3、freemark
	* 4、jetty （maven 插件，运行项目所需）
	* 5、maven（基本的maven命令）

quick start
	
	* 1、git clone https://github.com/shiyunlai/develop-in-action.git
	
	* 2、进入 in-action-springmvc 目录
	
	* 3、mvn eclipse:eclipse
	
	* 4、mvn clean install
	
	* 5、mvn jetty:run
	
	* 6、浏览器访问 http://localhost:8888/springmvc/employee
		执行验证
	
	以上quick start的前提：
	
	* 本地安装了mysql数据库，否者在执行5之前先修改数据库连接配置(in-action-springmvc/src/main/resources/springConfig/applicationContext.xml)：
		
		<property name="jdbcUrl" value="jdbc:mysql://127.0.0.1:3306/springmvc"></property>
        <property name="user" value="root"></property>
        <property name="password" value="root123"></property>
    
    * 确保端口8888没有被占用，否者修改启动端口:
    	
    	<port>8888</port>
    
    
＃ 更多关于Spring MVC知识参考：
	
	* [Spring MVC各种参数绑定](http://www.cnblogs.com/HD/p/4107674.html)
	* [史上最全Spring MVC学习资料整理](http://www.imooc.com/wap/article?article_id=1392)
	
	
	
	
