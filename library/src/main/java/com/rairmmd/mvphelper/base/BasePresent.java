package com.rairmmd.mvphelper.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author Rair
 * @date 2017/10/25
 * <p>
 * desc:BasePresent
 */
public class BasePresent<V extends IView> implements IPresent<V> {

    private V v;
    private CompositeDisposable mCompositeDisposable;

    @Override
    public void attachV(V view) {
        v = view;
    }

    @Override
    public void detachV() {
        v = null;
        dispose();
    }

    protected V getV() {
        if (v == null) {
            throw new IllegalStateException("V不能为空");
        }
        return v;
    }

    public void addDisposable(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    /**
     * 取消订阅
     */
    private void dispose() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }
}
