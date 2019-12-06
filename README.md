# springboot-demo
springboot集成

## 一、2019-12-02 21:11:56 springboot-helloworld 热部署  
访问路径： http://localhost:8001/helloworld/hello
```
# 热部署
#（1）File-Settings-Compiler-Build Project automatically
#（2）ctrl + shift + alt + /,选择Registry,勾上 Compiler autoMake allow when app running
spring:
  devtools:
    restart:
      enabled: true #热部署生效
      additional-paths: src/main/java #设置修改重启的目录
```

## 二、2019-12-02 23:21:22 springboot-mysql druid连接池监控 (准备多数据源) 
访问路径： http://localhost:8001/mysql/findUserList  
Druid Monitor监控路径：http://127.0.0.1:8002/mysql/druid/
```
 # 数据库基本配置
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource # 连接池类型
    driver-class-name: com.mysql.cj.jdbc.Driver # 数据库驱动类型
    url: jdbc:mysql://localhost:3306/springboot_mysql?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC # 数据库地址
    username: root # 用户名
    password: 123456 # 数据库密码
    # 连接池配置信息
    ## 初始化大小，最小，最大
    initialSize: 5
    minIdle: 5
    maxActive: 20
    ## 配置获取连接等待超时的时间
    maxWait: 60000
    ## 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
    timeBetweenEvictionRunsMillis: 60000
    ## 配置一个连接在池中最小生存的时间，单位是毫秒
    minEvictableIdleTimeMillis: 300000
    ## 测试连接
    validationQuery: SELECT 1 FROM DUAL
    testWhileIdle: true # 建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效
    testOnBorrow: false # 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
    testOnReturn: false # 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能

    poolPreparedStatements: true # 是否开启缓存PreparedStatement
    maxPoolPreparedStatementPerConnectionSize: 20 # 要启用PSCache，必须配置大于0，当大于0时，poolPreparedStatements自动触发修改为true。在Druid中，不会存在Oracle下PSCache占用内存过多的问题，可以把这个数值配置大一些，比如说100
    #   配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
    filters: stat,wall,log4j
    useGlobalDataSourceStat: true # 合并多个DruidDataSource的监控数据
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500 # 通过connectProperties属性来打开mergeSql功能；慢SQL记录
```
```
package cn.java68.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Druid配置类
 *
 * @author lemon
 */
@Configuration
public class DruidConfiguration {

    /**
     * 配置监控服务器
     *
     * @return 返回监控注册的servlet对象
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // 添加IP白名单
        servletRegistrationBean.addInitParameter("allow", "192.168.1.7,127.0.0.1");
        // 添加IP黑名单，当白名单和黑名单重复时，黑名单优先级更高
        servletRegistrationBean.addInitParameter("deny", "192.168.25.123");
        // 添加控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", "root");
        servletRegistrationBean.addInitParameter("loginPassword", "123456");
        // 是否能够重置数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    /**
     * 配置服务过滤器
     *
     * @return 返回过滤器配置对象
     */
    @Bean
    public FilterRegistrationBean statFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        // 添加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        // 忽略过滤格式
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*,");
        return filterRegistrationBean;
    }
}
```
## 三、2019-12-03 22:43:44 springboot-jdbc Swagger2接口文档和多环境配置和banner（模糊查询，分页查询）
运行命令：java -jar 生成的jar包 --spring.profiles.active=prod 
application.yml
```
server:
  port: 8003
  servlet:
    context-path: /jdbc
# 指定当前环境
spring:
  profiles:
    active: dev
``` 
application-dev.yml
```
spring:
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/springboot_mysql?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai
    username: root
    password: 123456
    initialSize: 5
    minIdle: 5
    maxActive: 20
    maxWait: 60000
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    validationQuery: SELECT 1 FROM DUAL
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true
    maxPoolPreparedStatementPerConnectionSize: 20
    filters: stat,wall,log4j
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
``` 
接口文档地址：http://localhost:8003/jdbc/swagger-ui.html
```
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class Swagger2Configuration {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.java68.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("使用jdbcTemplate的增删该查")
                .description("jdbcTemplate写接口")
                .termsOfServiceUrl("http://www.java68.cn/")
                .contact("wtyicy")
                .version("1.0")
                .build();
    }
}
```
## 四、2019-12-04 01:05:11 springboot-jpa 角色的增删改查
```
  jpa:
    show-sql: true # 是否显示sql
    hibernate:
      ddl-auto: update # create每次重新建表 update每次更新
```
## 五、2019-12-05 22:07:44 springboot-mybatis 部门管理（日志）
```
mybatis:
  config-location: classpath:/mybatis/mybatis-config.xml # 指定mybatis配置文件
  mapper-locations: classpath*:/mappers/*.xml # 指定mapper文件
  type-aliases-package: cn.java68 # 指定pojo
```
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

	<!-- 全局参数 -->
	<settings>
		<!-- 使全局的映射器启用或禁用缓存。 -->
		<setting name="cacheEnabled" value="true"/>
		
		<!-- 全局启用或禁用延迟加载。当禁用时，所有关联对象都会即时加载。 -->
		<setting name="lazyLoadingEnabled" value="true"/>
		
		<!-- 当启用时，有延迟加载属性的对象在被调用时将会完全加载任意属性。否则，每种属性将会按需要加载。 -->
		<setting name="aggressiveLazyLoading" value="true"/>
		
		<!-- 是否允许单条sql 返回多个数据集  (取决于驱动的兼容性) default:true -->
		<setting name="multipleResultSetsEnabled" value="true"/>
		
		<!-- 是否可以使用列的别名 (取决于驱动的兼容性) default:true -->
		<setting name="useColumnLabel" value="true"/>
		
		<!-- 允许JDBC 生成主键。需要驱动器支持。如果设为了true，这个设置将强制使用被生成的主键，有一些驱动器不兼容不过仍然可以执行。  default:false  -->
		<setting name="useGeneratedKeys" value="false"/>
		
		<!-- 指定 MyBatis 如何自动映射 数据基表的列 NONE：不隐射　PARTIAL:部分  FULL:全部  -->  
		<setting name="autoMappingBehavior" value="PARTIAL"/>
		
		<!-- 这是默认的执行类型  （SIMPLE: 简单； REUSE: 执行器可能重复使用prepared statements语句；BATCH: 执行器可以重复执行语句和批量更新）  -->
		<setting name="defaultExecutorType" value="SIMPLE"/>
		
		<!-- 使用驼峰命名法转换字段。 -->
		<setting name="mapUnderscoreToCamelCase" value="true"/>
		
		<!-- 设置本地缓存范围 session:就会有数据的共享  statement:语句范围 (这样就不会有数据的共享 ) defalut:session -->
        <setting name="localCacheScope" value="SESSION"/>
		
        <!-- 设置但JDBC类型为空时,某些驱动程序 要指定值,default:OTHER，插入空值时不需要指定类型 -->
        <setting name="jdbcTypeForNull" value="NULL"/>
		
	</settings>
	
	<!-- 类型别名 -->
<!--	<typeAliases>-->
<!--		<typeAlias alias="Page" type="com.jeespring.common.persistence.Page" />&lt;!&ndash;分页  &ndash;&gt;-->
<!--	</typeAliases>-->
	
	<!-- 插件配置 -->
<!--	<plugins>-->
<!--		<plugin interceptor="com.jeespring.common.persistence.interceptor.PaginationInterceptor" />-->
<!--    </plugins>-->
	
</configuration>
```
```
logging:
  level:
    root: INFO
    #WARN、DEBUG、INFO;DEBUG: 设置为DEBUG会打印SQL语句
    cn.java68: DEBUG
#    org.springframework.web: DEBUG
#    org.hibernate: DEBUG
  file:
    path: D:\springboot-mybaitslog
```
## 2019-12-06 11:32:12 springboot-redis 集成redis和集成测试
```
  redis:
    database: 0 # Redis数据库索引
    host: 127.0.0.1 # 服务器地址
    port: 6379 # 服务器连接端口
    password:  # 服务器连接密码
    timeout: 1000 # 连接超时时间
    jedis:
      pool:
        max-active: 200 # 连接池最大连接数
        max-idle: 10 # 连接池最大的空闲连接
        max-wait: -1 # 连接池最大阻塞等待时间
        min-idle: 0 # 连接池最小空闲连接

```



