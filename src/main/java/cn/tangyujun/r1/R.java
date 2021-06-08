package cn.tangyujun.r1;

import java.util.Objects;
import java.util.function.Function;

/**
 * Function: <br/>
 * Date: 2021/6/8 0:37<br/>
 *
 * @since jdk1.8.0_92
 */
public class R<T, E extends Throwable> {

	private final T value;
	private final E error;

	private R(T value, E error) {
		this.value = value;
		this.error = error;
	}

	public T getValue(){
		return value;
	}

	public E getError(){
		return error;
	}

	public static <T, E extends Throwable> R<T, E> ok(T value) {
		return new R<T, E>(value, null);
	}

	public static <T, E extends Throwable> R<T, E> error(E error) {
		return new R<T, E>(null, error);
	}

	public T orElse(T orElse) {
		return value != null ? value : orElse;
	}

	public T orElse(T orElse, RPredicate<T, E> predicate) {
		return Objects.requireNonNull(predicate).test(value, error) ? orElse : value;
	}

	public T get() {
		return value;
	}

	public T getOrThrow() throws E {
		if (error != null) {
			throw error;
		}
		return value;
	}

	public R<T, E> handleError(RErrorHandler<E> errorHandler) {
		if (error != null) {
			Objects.requireNonNull(errorHandler).handleError(error);
		}
		return this;
	}

	public R<T, E> handleValue(RValueHandler<T, E> valueHandler) {
		Objects.requireNonNull(valueHandler).handleValue(value, error);
		return this;
	}

	public <T1, E1 extends Throwable> R<T1, E1> map(Function<T, T1> valueMapper, Function<E, E1> errorMapper) {
		return new R<>(Objects.requireNonNull(valueMapper).apply(value),
				Objects.requireNonNull(errorMapper).apply(error));
	}

	public <T1> R<T1, E> mapValue(Function<T, T1> valueMapper) {
		return new R<>(Objects.requireNonNull(valueMapper).apply(value), error);
	}

	public <E1 extends Throwable> R<T, E1> mapError(Function<E, E1> errorMapper) {
		return new R<>(value, Objects.requireNonNull(errorMapper).apply(error));
	}
}
