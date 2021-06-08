package cn.tangyujun.r1;

/**
 * Function: the handler to deal with error <br/>
 * Date: 2021/6/8 20:22<br/>
 *
 * @since jdk1.8.0_92
 */
@FunctionalInterface
public interface RErrorHandler<E extends Throwable> {
	void handleError(E e);
}
