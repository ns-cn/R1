package cn.tangyujun.r1.test;

import cn.tangyujun.r1.R;

/**
 * Function: common-test <br/>
 * Date: 2021/6/8 0:42<br/>
 *
 * @since jdk1.8.0_92
 */
public class RTest {

	public static void main(String[] args) {
		// returning R without error
		R<Integer, IllegalArgumentException> r2 = divide(2, 1);
		// returning R with error
		R<Integer, IllegalArgumentException> r1 = divide(2, 0);
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

	/**
	 * Method: simple function : devide <br/>
	 * Create at: 2021/6/8 21:53 <br/>
	 *
	 * @param a
	 * @param b
	 * @return {@link R< Integer, IllegalArgumentException>}
	 */
	public static R<Integer, IllegalArgumentException> divide(int a, int b) {
		if (b == 0) {
			return R.error(new IllegalArgumentException("You can't divide by 0"));
		}
		return R.ok(a / b);
	}
}
