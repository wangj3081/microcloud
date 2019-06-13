#### 关于使用 Zipkin 做链路跟踪请阅读

​	原本想自己折腾下，不用官方 Zipkin 的服务包来做链路跟踪的，折腾了两天没啥进展，无法创建 RabbitMQ 中的消费者，等过几天有空看看官方包是怎么做的！现在的处理方法是使用官方的包，[官方工程地址](https://github.com/apache/incubator-zipkin) 下载下来后需要通过 maven 命令将其打为一个 jar 包，具体操作流程，[官方地址](https://github.com/apache/incubator-zipkin) 中有很详细的介绍，当然由于是需要将链路数据存入到 MySql 数据库之中所以需要对应库表脚本，该脚本直接使用官方的即可，下载地址如下

 [MySql脚本下载地址](https://github.com/apache/incubator-zipkin/blob/master/zipkin-storage/mysql-v1/src/main/resources/mysql.sql)

- 启动使用

  打好 Jar 包，建好所需库表后，执行类似如下命令即可
  
- ZipKin To Mysql
~~~shell
java -jar zipkin-server.jar --zipkin.collector.rabbitmq.addresses=192.168.134.130:5672 --zipkin.collector.rabbitmq.password=rabbit --zipkin.collector.rabbitmq.username=admin --zipkin.storage.type=mysql --zipkin.storage.mysql.username=root --zipkin.storage.mysql.password=root --zipkin.storage.mysql.host=localhost --zipkin.storage.mysql.port=3306 --zipkin.storage.mysql.db=zipkin --zipkin.storage.mysql.max-active=10
~~~

> **zipkin-server.jar:** 是我打的 Jar 包名称
>
> **zipkin.collector.rabbitmq.*** rabbitMQ 对应的连接信息
>
> **zipkin.storage.type:** 使用的存储(此处使用的是 Mysql)
>
> **zipkin.storage.mysql.***： Mysql 的数据库连接信息

- ZipKin To ElasticSearch
~~~shell
java -jar zipkin-server.jar --RABBIT_URI=amqp://admin:rabbit@192.168.158.134:5672 --zipkin.storage.type=elasticsearch --ES_HOSTS=http://192.168.158.134:9200 --ES_HTTP_LOGGING=BASIC
~~~
> **RABBIT_URI：** rabbitmq 的完整连接地址
>
> **zipkin.storage.type：** 指定存储数据的数据源
>
> **ES_HOSTS:** ElasticSearch 的连接地址，端口使用 http 的端口
>
> **ES_HTTP_LOGGING：** ElasticSearch 的 HTTP 接口日志

更多配置可查看 [zipkin-server](https://mvnrepository.com/artifact/io.zipkin.zipkin2/zipkin) 中的 **zipkin-server-shared.yml** 配置就可以了

最后 **zipkin** 默认访问地址: http://localhost:9411/zipkin/