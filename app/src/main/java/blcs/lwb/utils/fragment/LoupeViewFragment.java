package blcs.lwb.utils.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import blcs.lwb.lwbtool.base.BasePresenter;
import blcs.lwb.utils.R;

public class LoupeViewFragment extends BaseFragment {
    @Override
    protected int bindLayout() {
        return R.layout.fragment_loupe_view;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void setMiddleTitle(Toolbar title) {

    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @Override
    public void popBackListener(int returnCode, Bundle bundle) {

    }
}
