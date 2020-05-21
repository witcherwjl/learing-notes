# 字符排序

1. 按空格分开

```java
String s = "91 27 47 32 45";
String[] strArray = s.split(" ");
int[] arr = new int[strArray.length];
for(int i=0;i<arr.length;i++) {
    arr[i] = Integer.parseInt(strArray[i]);
}
Arrays.sort(arr);
System.out.println(Arrays.toString(arr));
```

