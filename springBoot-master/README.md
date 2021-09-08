## 简介<br/> 
SpringBoot系列Demo代码<br/>

SpringBoot用的是2.1.0.RELEASE，Demo代码主要参照官方文档，以及百度、google写的，每一个子工程就是一个小案例，简单明了<br/>
<br/>

父项目是一个maven项目，继承spring-boot-starter-parent，同时引入了部分公用依赖<br/>
```xml
    <!--  父类继承spring-boot-starter-parent  -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.0.RELEASE</version>
        <relativePath/>
    </parent>

    <!-- 在父类引入一下通用的依赖 -->
    <dependencies>
        <!-- spring-boot-starter -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <!-- springboot web(MVC)-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- springboot -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!--lombok插件 -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>

        <!--热部署工具dev-tools-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
            <scope>runtime</scope>
        </dependency>
    </dependencies>
```
<br/>

每个子项目都是一个独立的SpringBoot项目，子项目直接继承父类<br/>
```xml
    <!--继承父类-->
    <parent>
        <groupId>cn.huanzi.qch</groupId>
        <artifactId>parent</artifactId>
        <version>1.0.0</version>
    </parent>
```
<br/>

每个子项目都是SpringBoot的一个知识点或者说技能点，具体见名思意！
