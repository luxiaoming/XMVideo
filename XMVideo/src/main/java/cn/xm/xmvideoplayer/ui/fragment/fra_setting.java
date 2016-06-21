package cn.xm.xmvideoplayer.ui.fragment;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import cn.xm.xmvideoplayer.R;
import cn.xm.xmvideoplayer.core.BaseFragment;

/**
 * homefra
 */
public class fra_setting extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    @Bind(R.id.tv_title)
    TextView tvTitle;

    public static fra_setting newInstance(String param1, String param2) {
        fra_setting fragment = new fra_setting();
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
        return R.layout.fra_setting;
    }

    @Override
    public void initViews() {
        //
        tvTitle.setText(getString(R.string.tabsetting));
        //

    }
}
