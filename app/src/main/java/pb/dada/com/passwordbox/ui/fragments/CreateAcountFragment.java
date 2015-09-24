package pb.dada.com.passwordbox.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lidroid.xutils.ViewUtils;

import pb.dada.com.passwordbox.R;
import pb.dada.com.passwordbox.ui.common.BaseFragment;

/**
 * Created by Administrator on 2015/9/24.
 */
public class CreateAcountFragment extends BaseFragment {
    private Context context;

    public CreateAcountFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_acount, null);
        ViewUtils.inject(this, view);
        return view;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
