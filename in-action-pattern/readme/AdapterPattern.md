## 适配器模式（Adapter Pattern）

	参考： http://www.cnblogs.com/java-my-life/archive/2012/04/13/2442795.html

	模式定义：适配器模式把一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作。

	类适配器模式 UML：
![适配器模式UML](../img/AdapterClassPattern.png "适配类")

	对象适配器模式 UML：
![适配器模式UML](../img/AdapterInstancePattern.png "适配对象")

### 类适配器 与 对象适配器 模式的比较

	类适配器使用对象继承的方式，是静态的定义方式；而对象适配器使用对象组合的方式，是动态组合的方式。

### 适配器模式的缺点(新功能的开发不使用适配器模式，老系统扩展升级才使用)

	过多的使用适配器，会让系统非常零乱，不易整体进行把握。比如，明明看到调用的是A接口，其实内部被适配成了B接口的实现，一个系统如果太多出现这种情况，无异于一场灾难。因此如果不是很有必要，可以不使用适配器，而是直接对系统进行重构。

### 我在什么场景下使用过适配器模式！？

	场景1:tools-maven-plugin中，将ERMaster模型适配为BizModel，自动生成dao代码；
	场景2:TIS项目版本轻量化改造中，TWS端增加
