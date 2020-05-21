# Java 网络编程

java.net.Socket 类代表一个套接字，并且 java.net.ServerSocket 类为服务器程序提供了一种来监听客户端，并与他们建立连接的机制。

建立TCP连接：

- 服务器实例化一个 ServerSocket 对象，表示通过服务器上的端口通信。
- 服务器调用 ServerSocket 类的 accept() 方法，该方法将一直等待，直到客户端连接到服务器上给定的端口。
- 服务器正在等待时，一个客户端实例化一个 Socket 对象，指定服务器名称和端口号来请求连接。
- Socket 类的构造函数试图将客户端连接到指定的服务器和端口号。如果通信被建立，则在客户端创建一个 Socket 对象能够与服务器进行通信。
- 在服务器端，accept() 方法返回服务器上一个新的 socket 引用，该 socket 连接到客户端的 socket。

## ServerSocket 类的方法（服务端）

```java
serverSocket = new ServerSocket(port); // 绑定本地IP，给定port
Socket server = serverSocket.accept();

```

| **序号** | **方法描述**                                                 |
| :------: | :----------------------------------------------------------- |
|    1     | public **ServerSocket(int port)** throws IOException 创建绑定到特定端口的服务器套接字。 |
|    2     | public **ServerSocket(int port, int backlog)** throws IOException 利用指定的 backlog 创建服务器套接字并将其绑定到指定的本地端口号。 |
|    3     | public **ServerSocket(int port, int backlog, InetAddress address)** throws IOException 使用指定的端口、侦听 backlog 和要绑定到的本地 IP 地址创建服务器。 |
|    4     | public **ServerSocket()** throws IOException 创建非绑定服务器套接字。 |

| **序号** | **方法描述**                                                 |
| :------: | ------------------------------------------------------------ |
|    1     | **public int getLocalPort()** 返回此套接字在其上侦听的端口。 |
|    2     | **public Socket accept() throws IOException** 侦听并接受到此套接字的连接。 |
|    3     | **public void setSoTimeout(int timeout)** 通过指定超时值启用/禁用 SO_TIMEOUT，以毫秒为单位。 |
|    4     | **public void bind(SocketAddress host, int backlog)** 将 ServerSocket 绑定到特定地址（IP 地址和端口号）。 |

## Socket 类的方法（客户端）

```java
Socket client = new Socket(serverName, port); // 给定IP地址和port
```

| **序号** | **方法描述**                                                 |
| :------: | :----------------------------------------------------------- |
|    1     | **public Socket(String host, int port) throws UnknownHostException, IOException.** 创建一个流套接字并将其连接到指定主机上的指定端口号。 |
|    2     | **public Socket(InetAddress host, int port) throws IOException** 创建一个流套接字并将其连接到指定 IP 地址的指定端口号。 |
|    3     | **public Socket(String host, int port, InetAddress localAddress, int localPort) throws IOException.** 创建一个套接字并将其连接到指定远程主机上的指定远程端口。 |
|    4     | **public Socket(InetAddress host, int port, InetAddress localAddress, int localPort) throws IOException.** 创建一个套接字并将其连接到指定远程地址上的指定远程端口。 |
|    5     | **public Socket()** 通过系统默认类型的 SocketImpl 创建未连接套接字 |

# UDP