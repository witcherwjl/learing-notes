# URL使用

## 直接使用URL

```java
URL url = new URL("https://www.nowcoder.com/?page=1&size=30");
url.toString();
```

| 序号 | 方法描述                                                     |
| :--: | :----------------------------------------------------------- |
|  1   | **public URL(String protocol, String host, int port, String file) throws MalformedURLException.** 通过给定的参数(协议、主机名、端口号、文件名)创建URL。 |
|  2   | **public URL(String protocol, String host, String file) throws MalformedURLException** 使用指定的协议、主机名、文件名创建URL，端口使用协议的默认端口。 |
|  3   | **public URL(String url) throws MalformedURLException** 通过给定的URL字符串创建URL |
|  4   | **public URL(URL context, String url) throws MalformedURLException** 使用基地址和相对URL创建 |

**具体方法**

| 序号 | 方法描述                                                     |
| :--: | :----------------------------------------------------------- |
|  1   | **public String getPath()** 返回URL路径部分。                |
|  2   | **public String getQuery()** 返回URL查询部分。               |
|  3   | **public String getAuthority()** 获取此 URL 的授权部分。     |
|  4   | **public int getPort()** 返回URL端口部分                     |
|  5   | **public int getDefaultPort()** 返回协议的默认端口号。       |
|  6   | **public String getProtocol()** 返回URL的协议                |
|  7   | **public String getHost()** 返回URL的主机                    |
|  8   | **public String getFile()** 返回URL文件名部分                |
|  9   | **public String getRef()** 获取此 URL 的锚点（也称为"引用"）。 |
|  10  | **public URLConnection openConnection() throws IOException** 打开一个URL连接，并运行客户端访问资源。 |

## URLConnections类方法

openConnection() 返回一个 java.net.URLConnection。

例如：

- 如果你连接HTTP协议的URL, openConnection() 方法返回 HttpURLConnection 对象。
- 如果你连接的URL为一个 JAR 文件, openConnection() 方法将返回 JarURLConnection 对象。
- 等等...

```java
URL url = new URL("https://www.nowcoder.com");
URLConnection urlConnection = url.openConnection(); // 在此建立URLConnection
HttpURLConnection connection = null; // 建立Http接受对象，如果是Http协议的URL则赋值
if(urlConnection instanceof HttpURLConnection) {
    connection = (HttpURLConnection) urlConnection;
}
else {
    System.out.println("请输入URL地址");
    return;
}

// 建立getInputStream接收HTTP返回值
BufferedReader in = new BufferedReader(
    new InputStreamReader(connection.getInputStream())); 

String urlString = "";
String current;
while((current = in.readLine())!=null) { // 接收HTTP返回
    System.out.println(current);
    System.out.println("\n");
}
```

