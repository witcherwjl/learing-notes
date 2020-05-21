[Eclipse简明使用教程(java集成开发环境）](https://blog.csdn.net/qq_36243942/article/details/81607906#2.Eclipse%E5%88%9B%E5%BB%BAJava%E6%96%87%E4%BB%B6)
[牛客JAVA教程](https://www.nowcoder.com/tutorial/10001/5fc0c07cd9d44e66b3baafd76f1f5b9f)

[TOC]



# 基本数据类型

## 内置数据类型
符号|btyte|short|int|long|float|double|char|boolean|String
--|--|--|--|--|--|--|--|--|-- 
位数|8位|16位|32位|64位|32位|64位|16位|1位|字符串
最小值|$-128(-2^7)$|$-32768(-2^{15})$|$-2,147,483,648(-2^{31})$|$-9,223,372,036,854,775,808(-2^{63})$| | | \u0000|true|
最大值|$2^7-1$|$2^{15}-1$|$2^{31}-1$|$2^{63}-1$| | | \uffff|false|
默认值|0|0|0|0L|0.0f|0.0d|'u0000' |false|

## 应用数据类型
数组，对象的引用，就是引用数据类型(类似于C指针)
## Java常量
final 关键字修饰常量，不能修改
```java
final double PI = 3.14
```
## 定义变量
""双引号是字符串，''单引号是字符

```java
a = "sdag";
b = 'd';
c = 0x6A; //十六进制
d = 0144; //八进制
```
- 'a'-'z': 97-122
- 'A'-'Z':65-90
### 变量类型
1. 类变量：独立于方法之外的变量，用 static 修饰。
- 静态变量除了被声明为常量外很少使用。常量是指声明为public/private，final和static类型的变量。常量初始化后不可改变。
- 静态变量可以通过：ClassName.VariableName的方式访问。
- 类变量被声明为public static final类型时，类变量名称一般建议使用大写字母。如果静态变量不是public和final类型，其命名方式与实例变量以及局部变量的命名方式一致。
- 类变量也称为静态变量，在类中以 static 关键字声明，但必须在方法之外。

```java
public class Employee {
 
    //salary是静态的私有变量
    private static double salary;
    // DEPARTMENT是一个常量
    public static final String DEPARTMENT = "高中部";
 
    public static void main(String[] args){
           salary = 10000;
        System.out.println(DEPARTMENT+"平均工资:"+salary);
    }
}
```

2. 实例变量：独立于方法之外的变量，不过没有 static 修饰。
- 限制在类内，一般为私有，可以使用修饰符修改变量；
- 访问修饰符可以修饰实例变量；
- 类内方法、构造方法、语句块均可使用；
- 子类可以使用修饰符，使实例变量可见
- 可以有默认值
- 实例变量可以直接通过变量名访问。但在静态方法以及其他类中，就应该使用完全限定名：ObejectReference.VariableName。

```java
public class helloWorld {
	
	private double salary=1;
	
	public void get_salary() {
		System.out.println(salary);
	}
	
	public static void main(String[] args) {
	 	helloWorld emp = new helloWorld(); // 定义实例
	 	System.out.println(emp.salary);  // 在实例中直接实例变量
	 	emp.get_salary(); //或使用实例中的方法调用
	}
}

```

3. 局部变量：类的方法中的变量。
- 局部变量没有默认值，必须指定；
- 限制在方法内；
# 运算符

## 逻辑运算符

&| \| |!|^
--|--|--|--
与|或|非|异或

## 短路逻辑运算符（常用）

| &&     | \|\|   |
| ------ | ------ |
| 短路与 | 短路或 |
前头短路的情况下，后头不运行
## 三元运算符

关系表达式?表达式1:表达式2
`c = a>b?a:b //获取数据中较大值
`

# 数据输入/输出

```java
import java.util.Scanner
Scanner s = new Scanner(System.in);
// 判断是否还有输入
if (scan.hasNext()) {
    // next接收
    String str1 = scan.next();
    System.out.println("输入的数据为：" + str1);
}
if (scan.hasNextLine()) {
    String str2 = scan.nextLine();
    System.out.println("输入的数据为：" + str2);
}
```
## next() 与 nextLine() 区别

next():

- 1、一定要读取到有效字符后才可以结束输入。
- 2、对输入有效字符之前遇到的空白，next() 方法会自动将其去掉。
- 3、只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
- **next() 不能得到带有空格的字符串。**

nextLine()：

- 1、以**Enter为结束符**,也就是说 nextLine()方法返回的是输入回车之前的所有字符。
- 2、**可以获得空白。**

##  int / float 

- hasNextFloat() nextFloat()

- hasNextInt() nextInt()

- hasNextDouble(), nextDouble()

- ```java
  while (scan.hasNextDouble()) //循环输入
  ```

```java
import java.util.Scanner;
public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据
        int i = 0;
        float f = 0.0f;
        System.out.print("输入整数：");
        if (scan.hasNextInt()) {
            // 判断输入的是否是整数
            i = scan.nextInt();
            // 接收整数
            System.out.println("整数数据：" + i);
        } else {
            // 输入错误的信息
            System.out.println("输入的不是整数！");
        }
        System.out.print("输入小数：");
        if (scan.hasNextFloat()) {
            // 判断输入的是否是小数
            f = scan.nextFloat();
            // 接收小数
            System.out.println("小数数据：" + f);
        } else {
            // 输入错误的信息
            System.out.println("输入的不是小数！");
        }
        scan.close();
    }
}
```

# 条件判断

## if else

```java
if(){
	语句;
}else if(){
	语句;
}else{
	语句;
}
```
## switch case

1. 如果当前匹配成功的 case 语句块**没有 break** 语句，则从当前 case 开始，**后续所有 case** 的值都会输出，如果后续的 case 语句块有 break 语句则会跳出判断。

2. default 相当于 if 中的else

```java
switch(){
	case 值1:
			语句;
			break;
	case 值2:
			语句;
			break;
    default :
        语句;
}
```
# 循环结构

## while

## do..while

```java
do{
    //代码语句
} while(布尔表达式);
```

## for

```java
for(i=0; i<10; i++){
    //代码语句
}
```

### 加强for

增强的for循环是没有下标的，一般用于不需要下标时的操作，如查询

```java
for(声明语句 : 表达式) {
   //代码句子
}
```

- **声明语句：**声明新的局部变量，该变量的类型必须和数组元素的类型匹配。其作用域限定在循环语句块，其值与此时数组元素的值相等。

- **表达式：**表达式是要访问的数组名，或者是返回值为数组的方法。

eg:

```java
public class Test {
   public static void main(String args[]){
      int [] numbers = {10, 20, 30, 40, 50};
 
      for(int x : numbers ){
         System.out.print( x );
         System.out.print(",");
      }
      System.out.print("\n");
      String [] names ={"James", "Larry", "Tom", "Lacy"};
      for( String name : names ) {
         System.out.print( name );
         System.out.print(",");
      }
   }
}
```

得到

```java
10,20,30,40,50,
James,Larry,Tom,Lacy,
```



# 修饰符

| 修饰符    | 介绍                             | 使用对象                                | 当前类 | 同一包内 | 子孙类(同一包) | 子孙类(不同包) | 其他包 |      |
| --------- | -------------------------------- | --------------------------------------- | ------ | -------- | -------------- | -------------- | ------ | ---- |
| public    | 在同一包内可见，不使用任何修饰符 | 使用对象：类、接口、变量、方法。        | Y      | Y        | Y              | Y              | Y      |      |
| protected | 在同一类内可见                   | 变量、方法。 注意：不能修饰类（外部类） | Y      | Y        | Y              | Y/N            | N      |      |
| default   | 对所有类可见                     | 类、接口、变量、方法                    | Y      | Y        | Y              | N              | N      | N    |
| private   | 对同一包内的类和所有子类可见     | 变量、方法。 注意：不能修饰类（外部类） | Y      | N        | N              | N              | N      |      |

## 访问修饰符

### 默认修饰符

defalut

### 私有访问修饰符-private

- 声明为私有访问类型的变量只能通过类中公共的 getter 方法被外部类访问。
- 不能直接访问，必须通过调用类内的方法才能访问

### 公有访问修饰符-public

- 由于类的继承性，类所有的公有方法和变量都能被其子类继承。

### 受保护的访问修饰符-protected

- 保护层次在包内。类内和public一样，类外必须继承才能访问（导入不行）。

- **子类与基类在同一包中**：被声明为 protected 的变量、方法和构造器能被同一个包中的任何其他类访问；
- **子类与基类不在同一包中**：那么在子类中，子类实例可以访问其从基类继承而来的 protected 方法，而不能访问基类实例的protected方法。

protected 可以修饰数据成员，构造方法，方法成员，**不能修饰类（内部类除外）**。

### 访问控制和继承

请注意以下方法继承的规则：

- 父类中声明为 public 的方法在子类中也必须为 public。
- 父类中声明为 protected 的方法在子类中要么声明为 protected，要么声明为 public，不能声明为 private。
- 父类中声明为 private 的方法，不能够被继承。

## 非访问修饰符

static ，用来修饰**类方法和类变量**。

final ，用来修饰**类、方法和变量**，final 修饰的类**不能够被继承**，修饰的方法不能被继承类重新定义，修饰的变量为常量，是**不可修改**的。

- final 修饰符通常和 static 修饰符一起使用来创建类常量。

abstract ，用来创建**抽象类和抽象方法**。

- 抽象类不能用来实例化对象，声明抽象类的唯一目的是为了将来对该类进行扩充。
- 如果一个类包含抽象方法，那么该类一定要声明为抽象类，否则将出现编译错误。
- 抽象类可以包含抽象方法和非抽象方法。
- 抽象方法是一种没有任何实现的方法，该方法的的具体实现由子类提供。
- 任何继承抽象类的子类必须实现父类的所有抽象方法，除非该子类也是抽象类。
- 抽象方法的声明以分号结尾，例如：**public abstract sample();**。

synchronized 和 volatile ，主要用于线程的编程。

- synchronized 关键字声明的方法同一时间只能被一个线程访问。synchronized 修饰符可以应用于四个访问修饰符
- volatile 修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值。而且，当成员变量发生变化时，会强制线程将变化值回写到共享内存。这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。一个 volatile 对象引用可能是 null。

transient,序列化的对象包含被 transient 修饰的实例变量时，java 虚拟机(JVM)跳过该特定的变量。

- 该修饰符包含在定义变量的语句中，用来预处理类和变量的数据类型。

```java
public transient int limit = 55;   // 不会持久化
public int b; // 持久化
```

# 运算符

## instanceof 运算符

- 该运算符用于操作对象实例，检查该对象是否是一个特定类型（类类型或接口类型）。

instanceof运算符使用格式如下：

```java
a instanceof A; //判断a是否为A的一个实例
( Object reference variable ) instanceof (class/interface type)
```

如果运算符左侧变量所指的对象，是操作符右侧类或接口(class/interface)的一个对象，那么结果为真。

```java
String name = "James";
boolean result = name instanceof String;// 由于 name 是 String 类型，所以返回真
```

如果被比较的对象兼容于右侧类型,该运算符仍然返回true。

```java
class Vehicle {}
public class Car extend Vehicle{
    public static void main(Sring[] args){
        Vehicle a = new Car();
        boolean result = a instanceof Car;
        System.out.println(result);
    }
}
```

以上实例编译运行结果如下：

```
true
```

## Java运算符优先级

| 高     |   类别   |                   操作符                   |  关联性  |
| ------ | :------: | :----------------------------------------: | :------: |
|        |   后缀   |             () [] . (点操作符)             |  左到右  |
|        |   一元   |                 + + - ！〜                 | 从右到左 |
|        |   乘性   |                   * /％                    |  左到右  |
|        |   加性   |                    + -                     |  左到右  |
|        |   移位   |                 >> >>> <<                  |  左到右  |
|        |   关系   |                 >> = << =                  |  左到右  |
|        |   相等   |                   == !=                    |  左到右  |
|        |  按位与  |                     ＆                     |  左到右  |
|        | 按位异或 |                     ^                      |  左到右  |
|        |  按位或  |                     \|                     |  左到右  |
|        |  逻辑与  |                     &&                     |  左到右  |
|        |  逻辑或  |                   \| \|                    |  左到右  |
|        |   条件   |                    ？：                    | 从右到左 |
|        |   赋值   | = + = - = * = / =％= >> = << =＆= ^ = \| = | 从右到左 |
| **低** |   逗号   |                     ，                     |  左到右  |

# 数组

## 声明、初始化、使用、for-each

```java
dataType[] arrayRefVar;   // 首选的方法
dataType arrayRefVar[];  // 效果相同，但不是首选方法，c/c++的默认方法
double[] myList;         // 首选的方法
double myList[];         //  效果相同，但不是首选方法
double[] myList = {1.9, 2.9, 3.4, 3.5};
// myList.length 长度
// 打印所有数组元素
for (int i = 0; i < myList.length; i++) {
         System.out.println(myList[i] + " ");
      }
for (double element: myList) {
         System.out.println(element);
      }
```

## 多维数组

```java
//直接为每一维分配空间，格式如下：
String str[][] = new String[3][4];
//type[][] typeName = new type[typeLength1][typeLength2];
//从最高维开始，分别为每一维分配空间，例如：
String s[][] = new String[2][];
s[0] = new String[2];
s[1] = new String[3];
```

## Arrays 类（排序，插入，比较，查找）

- java.util.Arrays 类能方便地操作数组，它提供的所有方法都是静态的。

- 给数组赋值：通过 fill 方法。

```java
Arrays.fill(int[] a,int val) ;
Arrays.fill(int[] a,int fromIndex,int toIndex,int val); //用val值来填充数组a中所指定的范围
int[] a = new int[10];
Arrays.fill(a,1,9,10);
```

- 对数组排序：通过 sort 方法,按升序。

```java
import java.util.Arrays;
import java.util.Collections;
int[] a ={1,2,3,5};
Arrays.sort(a); //对数组a进行升序排序
//降序
//注意，要想改变默认的排列顺序，不能使用基本类型（int,double, char）,而要使用它们对应的类
Integer[] arr = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
Arrays.sort(arr, Collections.reverseOrder());
```

```java
// 或是自己指定，降序方法
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        //注意，要想改变默认的排列顺序，不能使用基本类型（int,double, char）,而要使用它们对应的类
        Integer[] arr = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
        //定义一个自定义类MyComparator的对象
        Comparator cmp = new MyComparator();
        Arrays.sort(arr, cmp);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
//实现Comparator接口
class MyComparator implements Comparator<Integer> {
    @Override //作用是检查下面的方法名是不是父类中所有的，也起到注释的作用
    public int compare(Integer a, Integer b) {
        return a > b ? -1 : 1;
    }
}
```

- 比较数组：通过 equals 方法比较数组中元素值是否相等。

```java
Ayyays.equals(int[] a, int aFromIndex, int aToIndex, int[] b, int bFromIndex, int bToIndex);//可以指定比较范围
Arrays.equals(a,1,10,b,2,11); //比较a中1~10和b中2~11是否相同
```

- 查找数组元素：通过 binarySearch 方法能对**排序好的数组**进行二分查找法操作。

```java
int[] a = {1,2,3,4,5};
Arrays.binarySearch(a,5);
```

# 方法

## 命名规则

- 方法的名字的第一个单词应以小写字母作为开头，后面的单词则用大写字母开头写，不使用连接符。例如：**addPerson**。
- 下划线可能出现在 JUnit 测试方法名称中用以分隔名称的逻辑组件。一个典型的模式是：`test_`，例如 `testPop_emptyStack`。

## 方法的定义

```java
修饰符 返回值类型 方法名(参数类型 参数名){
    ...
    方法体
    ...
    return 返回值;
}
```

## 方法重载

如果你调用max方法时传递的是int型参数，则 int型参数的max方法就会被调用；

如果传递的是double型参数，则double类型的max方法体会被调用，这叫做方法重载；

就是说一个类的两个方法拥有相同的名字，但是有不同的参数列表。

Java编译器根据方法签名判断哪个方法应该被调用。

方法重载可以让程序更清晰易读。执行密切相关任务的方法应该使用相同的名字。

重载的方法必须**拥有不同的参数列表**。你不能仅仅依据修饰符或者返回类型的不同来重载方法。

```java
public static double max(double num1, double num2) {
  if (num1 > num2)
    return num1;
  else
    return num2;
}
public static int max(int num1, int num2) {
    int result;
    if (num1 > num2)
        result = num1;
    else
        result = num2;

    return result;
}
```

## 构造方法

（与python中\_\_init\_\_方法相似）

构造方法和它所在类的名字相同，但构造方法没有返回值。构造方法类型也与类相同。

通常会使用构造方法给一个类的实例变量赋初值，或者执行其它必要的步骤来创建一个完整的对象。

```java
// 一个简单的构造函数
class MyClass {
  int x;
 
  // 以下是构造函数
  MyClass() {
    x = 10;
  }
}
```

## 可变参数

JDK 1.5 开始，Java支持传递同类型的可变参数给一个方法。

在方法声明中，在指定参数类型后加一个省略号(...) 。

一个方法中只能指定一个可变参数，它必须是方法的最后一个参数。任何普通的参数必须在它之前声明。

传进去之后成为数组，再运算

```java
//typeName... parameterName
public class VarargsDemo {
    public static void main(String args[]) {
        // 调用可变参数的方法
        printMax(34, 3, 3, 2, 56.5);
        printMax(new double[]{1, 2, 3});
    }
    public static void printMax( double... numbers) {
        double result = numbers[0];
        for (int i = 1; i <  numbers.length; i++){
            if (numbers[i] >  result) {
                result = numbers[i];
            }
        }
        System.out.println("The max value is " + result);
    }
}
```

## finalize() 方法(垃圾回收方法)

Java 允许定义这样的方法，它在对象被垃圾收集器析构(回收)之前调用，这个方法叫做 finalize( )，它用来清除回收对象。

在 finalize() 方法里，你必须指定在对象销毁时候要执行的操作。

```java
protected void finalize() {
   // 在这里终结代码
}
//关键字 protected 是一个限定符，它确保 finalize() 方法不会被该类以外的代码调用。
```

```java
public class FinalizationDemo { 
  public static void main(String[] args) { 
    Cake c1 = new Cake(1); 
    Cake c2 = new Cake(2); 
    Cake c3 = new Cake(3); 
 
    c2 = c3 = null; 
    System.gc(); //调用Java垃圾收集器，会把没用的回收，eg:null,[]
  } 
} 
 
class Cake extends Object { 
  private int id; 
  public Cake(int id) {  //构造
    this.id = id; 
    System.out.println("Cake Object " + id + "is created"); 
  } 
 
  protected void finalize() throws java.lang.Throwable {  //析构（回收）
    super.finalize(); 
    System.out.println("Cake Object " + id + "is disposed"); 
  } 
}
/*
$ javac FinalizationDemo.java
$ java FinalizationDemo
Cake Object 1is created
Cake Object 2is created
Cake Object 3is created
Cake Object 3is disposed
Cake Object 2is disposed
*/
```

