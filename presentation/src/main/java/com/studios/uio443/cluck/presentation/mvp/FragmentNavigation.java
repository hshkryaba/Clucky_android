package com.studios.uio443.cluck.presentation.mvp;

import com.studios.uio443.cluck.presentation.view.fragment.BaseFragment;

/**
 * Created by zundarik
 */

public interface FragmentNavigation {
    interface View {
        void attachPresenter(Presenter presenter);
    }

    interface Presenter {
        void addFragment(BaseFragment fragment);
    }
}
