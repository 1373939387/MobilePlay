package com.haoruigang.cniao5play.di.module;

import android.app.ProgressDialog;

import com.haoruigang.cniao5play.data.AppInfoModel;
import com.haoruigang.cniao5play.data.http.ApiService;
import com.haoruigang.cniao5play.presenter.contract.AppInfoContract;
import com.haoruigang.cniao5play.ui.fragment.RecommendFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class RecommendModule {

    private AppInfoContract.View mView;

    public RecommendModule(AppInfoContract.View view) {
        this.mView = view;
    }

    @Provides
    public AppInfoContract.View provideView() {
        return mView;
    }

    @Provides
    public AppInfoModel provideModule(ApiService mApiService) {
        return new AppInfoModel(mApiService);
    }

    @Provides
    public ProgressDialog provideProgressDialog(AppInfoContract.View view) {
        return new ProgressDialog(((RecommendFragment) view).getActivity());
    }

}
