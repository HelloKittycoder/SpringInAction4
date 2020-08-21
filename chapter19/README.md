- **第19章** [使用Spring发送Email]()  
chapter19 使用Spring发送Email（简单邮件、带附件、富文本）  
说明：  
要运行SpitterMailServiceImplTest#sendSimpleSpittleEmail这个单元测试，需要：  
1. 更换测试方法里Spitter对象里email属性（这个是收件箱地址）  
2. 添加邮件发送服务器的username（就是邮箱地址）和password（邮箱密码，qq邮箱这里填的是授权码），见mail.properties文件  
（我用的是qq邮箱，如果用的别的邮件服务器，还需要修改下mailserver.host、mailserver.port这两个属性）  
