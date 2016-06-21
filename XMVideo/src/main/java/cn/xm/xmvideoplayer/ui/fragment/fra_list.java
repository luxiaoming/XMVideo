package cn.xm.xmvideoplayer.ui.fragment;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import cn.xm.xmvideoplayer.R;
import cn.xm.xmvideoplayer.core.BaseFragment;

/**
 * homefra
 */
public class fra_list extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @Bind(R.id.tv_title)
    TextView tvTitle;

    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fra_home.
     */
    // TODO: Rename and change types and number of parameters
    public static fra_list newInstance(String param1, String param2) {
        fra_list fragment = new fra_list();
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
        return R.layout.fra_list;
    }

    @Override
    public void initViews() {
        //
        tvTitle.setText(getString(R.string.tablist));
        //

    }

}
