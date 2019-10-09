package cn.lmh.examples.grpc;

import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

public class CallableStreamObserver<T> implements StreamObserver<T> {
	List<T> values = new ArrayList<T>();
	boolean isCompleted = false;
	Throwable t = null;

	@Override
	public void onNext(T value) {
		this.values.add(value);
	}

	@Override
	public void onError(Throwable t) {
		this.isCompleted = true;
		notifyAll();
	}

	@Override
	public synchronized void onCompleted() {
		this.isCompleted = true;
		notifyAll();
	}

	public List<T> get() throws Throwable {
		if (!this.isCompleted) {
			synchronized (this) {
				this.wait(60 * 1000);
			}
		}
		if (null != t) {
			throw this.t;
		} else {
			return this.values;
		}
	}
}
