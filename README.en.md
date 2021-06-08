# R1

#### Description
Revolution: Inspired by the multi-return nature of language functions such as Go, it is used for special handling of exceptions


#### Installation

1.  
#### Instructions

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


#### Gitee Feature

1.  You can use Readme\_XXX.md to support different languages, such as Readme\_en.md, Readme\_zh.md
2.  Gitee blog [blog.gitee.com](https://blog.gitee.com)
3.  Explore open source project [https://gitee.com/explore](https://gitee.com/explore)
4.  The most valuable open source project [GVP](https://gitee.com/gvp)
5.  The manual of Gitee [https://gitee.com/help](https://gitee.com/help)
6.  The most popular members  [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
