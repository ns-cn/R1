package cn.tangyujun.r1;

/**
 * Function: the handler to deal the value<br/>
 * Date: 2021/6/8 20:18<br/>
 *
 * @author tangyujun
 * @since jdk1.8.0_92
 */
@FunctionalInterface
public interface RValueHandler<T,E extends Throwable> {

	void handleValue(T v,E e);
}
