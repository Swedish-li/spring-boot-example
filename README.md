# spring-boot-example

Spring boot 示例项目,如果需要项目热部署，需要使用下面的命令启动项目

``` bash
$ mvn spring-boot:run

```

将项目打包为可运行jar

``` bash
$ mvn clean package -Dmaven.test.skip=true

```

文档

* [项目热部署](https://juejin.im/entry/586147681b69e675fcd159ed)
* [Spring boot的自动加载机制](https://juejin.im/post/585fcb048d6d810065ed7464)
* [springboot-action](https://github.com/lianggzone/springboot-action)
* [Spring Boot Maven Plugin](http://docs.spring.io/spring-boot/docs/1.5.4.RELEASE/maven-plugin/)