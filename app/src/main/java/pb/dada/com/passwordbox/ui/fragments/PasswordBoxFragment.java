package pb.dada.com.passwordbox.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import pb.dada.com.passwordbox.R;
import pb.dada.com.passwordbox.ui.common.BaseFragment;

/**
 * Created by Administrator on 2015/9/24.
 */
public class PasswordBoxFragment extends BaseFragment {

    private Context context;

    @ViewInject(R.id.lv_password_boxs)
    private ListView lv_password_boxs;
    @ViewInject(R.id.create_acount)
    private ImageView create_acount;

    public PasswordBoxFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_passwordbox, null);
        ViewUtils.inject(this, view);
        initListener();
        return view;
    }

    @Override
    public void initListener() {
        create_acount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //创建密码
        if (v == create_acount) {
            CreateAcountFragment passwordBoxFragment = new CreateAcountFragment(context);
            getActivity().getSupportFragmentManager().beginTransaction().
                    replace(R.id.frg_password_box_container, passwordBoxFragment)
                    .addToBackStack(CreateAcountFragment.class.getSimpleName()).commit();
        }
    }
}
