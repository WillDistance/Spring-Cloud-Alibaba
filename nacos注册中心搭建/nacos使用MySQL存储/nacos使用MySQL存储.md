**1、确认Nacos版本：** 确保你的Nacos版本是2.2或更高，因为从2.2版本开始，Nacos才开始支持除MySQL和Derby之外的更多数据库类型通过插件的方式。如果版本低于2.2，请先升级Nacos。

**2、下载与配置MySQL：** 确保你已经安装并配置好了MySQL服务器，且版本兼容MySQL5.6及以上协议。

**3、获取或开发数据库插件：** 访问Nacos插件仓库，检查是否已有适用于MySQL的现成插件。对于MySQL而言，实际上并不需要额外的插件，因为Nacos原生支持MySQL。

**4、修改配置文件：**

打开Nacos配置文件conf/application.properties，进行以下配置更改：

```properties
spring.datasource.platform=mysql
db.num=1
db.url.0=jdbc:mysql://127.0.0.1:3306/nacos243?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC
db.user.0=root
db.password.0=123456
```

注意：根据实际情况替换你的数据库地址、端口、nacos（数据库名）、你的数据库用户名和你的数据库密码。

![1734536678531](D:\AllWorkspace\idea_github\Spring-Cloud-Alibaba\nacos注册中心搭建\nacos使用MySQL存储\nacos使用MySQL存储.assets\1734536678531.png)

**5、初始化数据库：**

从Nacos的conf目录下找到mysql-schema.sql（针对Nacos 2.x版本），并使用该SQL脚本在你的MySQL数据库中创建所需的表结构。执行脚本前，请确保你连接的是正确的数据库实例。
**6、启动Nacos服务：** 完成上述配置后，重新启动Nacos服务。Nacos将使用配置的MySQL数据库作为其数据存储。