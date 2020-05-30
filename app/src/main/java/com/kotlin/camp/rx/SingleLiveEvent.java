package com.kotlin.camp.rx;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.concurrent.atomic.AtomicBoolean;

public class SingleLiveEvent<T> extends MutableLiveData<T> {

    private final AtomicBoolean mPending = new AtomicBoolean(false);

    private boolean emitOnChangedOnly;

    public SingleLiveEvent() {
    }

    public SingleLiveEvent(boolean emitOnChangeOnly) {
        this.emitOnChangedOnly = emitOnChangeOnly;
    }

    @MainThread
    public void observe(LifecycleOwner owner, final Observer<? super T> observer) {

        // Observe the internal MutableLiveData
        super.observe(owner, t -> {
            if (mPending.compareAndSet(true, false)) {
                observer.onChanged(t);
            }
        });
    }

    @MainThread
    public void setValue(@Nullable T t) {
        mPending.set(!emitOnChangedOnly || !((t == null ? getValue() == null : t.equals(getValue()))));
        super.setValue(t);
    }


    @MainThread
    public void call() {
        setValue(null);
    }

}
