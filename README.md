# week4Task

A：java文件夹中
  1. Common下有是统一的返回类型类restful
  2. config下是mybatisPlus的分页配置
  3. controller下是所有的controller类，包括用户，新闻，广告和评论
  4. exception下是自定义的exception，以及exceptionhandler，防止异常对外暴露并且按照统一格式输出，同时输入进日志中，枚举类中枚举了异常类型
  5. filter中是Spring Aop类，用于按特定格式输出日志，针对所有的controller类
  6. model中dao是mapper映射（repository层），pojo包含了用户，新闻，评论，广告的所有字段，且同时进行@valid验证
  7. service类负责数据库的交互，且对特定的异常进行处理
B：resource中
  1. 配置类中（application.properities）,配置数据源，配置服务器端口，配置mybatisPlus（可配置数据库用户名密码）
  2. log4j2.xml配置对不同级别的日志信息进行处理（其中可配置日志文件的目录地址）
