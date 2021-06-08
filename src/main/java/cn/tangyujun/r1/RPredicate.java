package cn.tangyujun.r1;

/**
 * Function:  <br/>
 * Date: 2021/6/8 20:53<br/>
 *
 * @since jdk1.8.0_92
 */
@FunctionalInterface
public interface RPredicate<T,E extends Throwable> {
	boolean test(T v,E e);
}
