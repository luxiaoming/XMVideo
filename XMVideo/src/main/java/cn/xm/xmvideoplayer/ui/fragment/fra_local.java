package cn.xm.xmvideoplayer.ui.fragment;

import android.os.Bundle;

import cn.xm.xmvideoplayer.R;
import cn.xm.xmvideoplayer.core.BaseFragment;

/**
 * homefra
 */
public class fra_local extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public static fra_local newInstance(String param1, String param2) {
        fra_local fragment = new fra_local();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public int getLayoutId() {
        return R.layout.fra_local;
    }

    @Override
    public void initViews() {

    }
}
