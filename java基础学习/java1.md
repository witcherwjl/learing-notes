[Eclipse简明使用教程(java集成开发环境）](https://blog.csdn.net/qq_36243942/article/details/81607906#2.Eclipse%E5%88%9B%E5%BB%BAJava%E6%96%87%E4%BB%B6)
[牛客JAVA教程](https://www.nowcoder.com/tutorial/10001/5fc0c07cd9d44e66b3baafd76f1f5b9f)

# 基本数据类型
## 内置数据类型
| |btyte|short|int|long|float|double|char|boolean|String
--|--|--|--|--|--|--|--|--|--
位数|8位|16位|32位|64位|32位|64位|16位|1位|字符串
最小值|$-128(-2^7)$|$-32768(-2^{15})$|$-2,147,483,648(-2^{31})$|$-9,223,372,036,854,775,808(-2^{63})$| | | \u0000|true
最大值|$2^7-1$|$2^{15}-1$|$2^{31}-1$|$2^{63}-1$| | | \uffff|false
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
## 运算符
### 逻辑运算符
|&| \| |!|^
|--|--|--|--
|与|或|非|异或
### 短路逻辑运算符（常用）
| &&     | \|\|   |
| ------ | ------ |
| 短路与 | 短路或 |
前头短路的情况下，后头不运行
### 三元运算符
关系表达式?表达式1:表达式2
`c = a>b?a:b //获取数据中较大值
`
### 数据输入/输出

```java
import java.util.Scanner
Scanner s = new Scanner(System.in);
```
### 条件判断
- if else
```java
if(){
	语句;
}else if(){
	语句;
}else{
	语句;
}
```
- switch case
```java
switch(){
	case 值1:
			语句;
			break;
	case 值2:
			语句;
			break;
}
```
## 修饰符
| 修饰符    | 介绍                             | 使用对象                                | 当前类 | 同一包内 | 子孙类(同一包) | 子孙类(不同包) | 其他包 |      |
| --------- | -------------------------------- | --------------------------------------- | ------ | -------- | -------------- | -------------- | ------ | ---- |
| public    | 在同一包内可见，不使用任何修饰符 | 使用对象：类、接口、变量、方法。        | Y      | Y        | Y              | Y              | Y      |      |
| protected | 在同一类内可见                   | 变量、方法。 注意：不能修饰类（外部类） | Y      | Y        | Y              | Y/N            | N      |      |
| default   | 对所有类可见                     | 类、接口、变量、方法                    | Y      | Y        | Y              | N              | N      | N    |
| private   | 对同一包内的类和所有子类可见     | 变量、方法。 注意：不能修饰类（外部类） | Y      | N        | N              | N              | N      |      |

