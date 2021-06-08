# R1

#### 介绍
Revolution：从Go等语言函数多返回值的特性获取的灵感，用于针对异常的特殊处理


#### 安装教程

1. 

#### 使用说明
```java
public static R<Integer, IllegalArgumentException> divide(int a, int b) {
    if (b == 0) {
        return R.error(new IllegalArgumentException("You can't divide by 0"));
    }
    return R.ok(a / b);
}
public static void main(String[] args) {
    // returning R with error
    R<Integer, IllegalArgumentException> r1 = divide(2, 0);
    // returning R without error
    R<Integer, IllegalArgumentException> r2 = divide(2, 1);
    // handle error when R contains error
    r1.handleError(Throwable::printStackTrace);
    r2.handleError(Throwable::printStackTrace);
    // get result
    System.out.println(r1.get()); // null
    System.out.println(r2.get()); // 2

    // shorthand
    System.out.println(r1.handleError(Throwable::printStackTrace).orElse(Integer.MAX_VALUE)); // 2147483647
    System.out.println(r2.handleError(Throwable::printStackTrace).orElse(Integer.MAX_VALUE)); // 2
}
```

#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
