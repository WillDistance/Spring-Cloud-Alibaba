# nacos-config模块说明

## 模块功能介绍
>主要演示该如何使用nacos作为配置中心，并通过@RefreshScope动态刷新配置



## 软件目录说明



## nacos配置项说明

| 配置                                         |           默认值           | 描述                                                         |
| :------------------------------------------- | :------------------------: | :----------------------------------------------------------- |
| spring.cloud.nacos.discovery.server-addr     |                            | 注册中心服务器地址                                           |
| spring.cloud.nacos.discovery.service         | ${spring.application.name} | 命名当前服务名称                                             |
| spring.cloud.nacos.discovery.weight          |             1              | 权重, 1到100,值越大,权重越大                                 |
| spring.cloud.nacos.discovery.ip              |                            | 注册ip , 当前服务注册到nacos的IP,最高优先级                  |
| spring.cloud.nacos.discovery.port            |             -1             | 注册端口 , 当前服务注册到nacos的端口,默认情况下将自动检测,不需要配置 |
| spring.cloud.nacos.discovery.namespace       |                            | 命名空间                                                     |
| spring.cloud.nacos.discovery.access-key      |                            | 阿里云账户访问秘钥                                           |
| spring.cloud.nacos.discovery.secret-key      |                            | 阿里云账户秘钥                                               |
| spring.cloud,nacos.discovery.metadata        |                            | 元数据  , 可以使用key-value格式定义一些元数据                |
| spring.cloud.nacos.discovery.cluster-name    |          Default           | 集群名称                                                     |
| ribbon.nacos.enabled                         |            true            | 是否集成ribbon                                               |
| spring.cloud.nacos.config.server.addr        |                            | 配置中心地址                                                 |
| spring.cloud.nacos.config.name               |                            | 首先使用配置的前缀,然后再使用名称,最后使用spring.application.name |
| spring.cloud.nacos.config.prefix             |                            | 首先使用配置的前缀,然后再使用名称,最后使用spring.application.name |
| spring.cloud.nacos.config.group              |       DEFAULT_GROUP        | nacos的组配置                                                |
| spring.cloud.nacos.config.file-extension     |         properties         | data id的后缀                                                |
| spring.cloud.nacos.config.timeout            |            3000            | 从nacos获取配置超时时间                                      |
| spring.cloud.nacos.config.namespace          |                            | 命名空间                                                     |
| spring.cloud.nacos.config.contentPath        |                            | Nacos server的上下文路径                                     |
| spring.cloud.nacos.config.sharedDataids      |                            | 共享配置的dataid , 共享配置的数据标记,用","分隔              |
| spring.cloud.nacos.config.refreshableDataids |                            | 共享配置的动态刷新dataid , 共享配置的动态刷新数据标记, 用","分隔 |





## nacos三种配置方式

nacos 一共有3个维度去区分不同环境的配置：dataId、Group、namespace。当然这3者可以任意的组合使用

**1、根据不同的dataId区分**
dataId的组成格式：${spring.application.name}-${spring.profile.active}.${spring.cloud.nacos.config.file-extension}
主要是通过控制dataId组成部分中的【spring.profile.active】部分的改变来区分：dev环境-开发环境 test环境-测试环境  prod环境-生产环境

**2、根据不同的Group区分**
spring.cloud.nacos.config.group: PROD_GROUP

**3、根据不同的namespace区分**
spring.cloud.nacos.config.namespace: 707815d9-0750-4643-99d0-30b5104d7356 #命名空间：prod

**4、多配置文件加载**
在一些情况下需要加载多个配置文件。
假如现在info名称空间下有两个配置文件：config-Info.yaml、config-Info2.yaml

```yaml
ext-config:
- data-id: config-Info.yaml
  group: DEV_GROUP
  refresh: true
- data-id: config-Info2.yaml
  group: DEV_GROUP
  refresh: true

```



## Nacos对配置的默认理念

- `namespace`区分环境：开发环境、测试环境、预发布环境、⽣产环境。
- `group`区分不同应⽤：同⼀个环境内，不同应⽤的配置，通过`group`来区分。


![1704376539161](D:\AllWorkspace\Idea_workspace\Spring-Cloud-Alibaba\nacos-config\README\assets\1704376539161.png)

## 优秀参考文章：
spring cloud alibaba nacos 配置详解 https://blog.csdn.net/weixin_42214548/article/details/107284429

[达到]: https://blog.csdn.net/weixin_42214548/article/details/107284429

Nacos共享配置(shared-configs)和扩展配(extension-config)：https://www.jianshu.com/p/8715072d3f4c

## 部署说明
1.  xxxx
2.  xxxx
3.  xxxx

