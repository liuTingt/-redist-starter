# -redist-starter
创建自定义redist starter

自定义starter，使用spring-boot-autoconfigure，自动化配置。 用来处理redis。 底层为Jedis。仅做starter参考示例。

总结：自定义starter时
1.首先需要在pom中引入spring-boot-autoconfigure
2.新建XXXAutoConfiguration，然后引入需要注入的类。
3.配置spring.factories。
org.springframework.boot.autoconfigure.EnableAutoConfiguration=XXXAutoConfiguration类全路径
//当有多个时
org.springframework.boot.autoconfigure.EnableAutoConfiguration=/
A,/
B,/
C
