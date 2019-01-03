package blcs.lwb.utils.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;

import blcs.lwb.lwbtool.utils.IntentUtils;
import blcs.lwb.lwbtool.utils.RxToast;
import blcs.lwb.utils.Constants;
import blcs.lwb.utils.PublicFragmentActivity;
import blcs.lwb.utils.R;
import blcs.lwb.utils.adapter.HomeTabAdapter;
import blcs.lwb.utils.manager.FramentManages;
import blcs.lwb.utils.mvp.presenter.HomeTabPresenter;
import blcs.lwb.utils.mvp.view.IHomeTabView;
import blcs.lwb.utils.utils.MyUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * RecyclerView
 */
public class HomeViewFragment extends Fragment implements IHomeTabView{

    @BindView(R.id.tool_recyclerView)
    RecyclerView recycler;
    private Unbinder bind;
    private View mView=null;
    private HomeTabAdapter adapter;
    private HomeTabPresenter presenter;
    private FragmentActivity activity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mView == null) {
            activity = getActivity();
            mView = inflater.inflate(R.layout.tool_recyclerview, container, false);
            bind = ButterKnife.bind(this, mView);
            presenter = new HomeTabPresenter(this);
            presenter.init();
        }
        return mView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDetch();
        if(bind != null){
            mView=null;
            bind.unbind();
            bind = null;
        }
    }

    @Override
    public void Recycler_init() {
        LinearLayoutManager manager = new LinearLayoutManager(activity);
        recycler.setLayoutManager(manager);
        manager.setOrientation(OrientationHelper.VERTICAL);
        recycler.addItemDecoration(new DividerItemDecoration(activity, OrientationHelper.VERTICAL));
        adapter = new HomeTabAdapter(MyUtils.getArray(activity, R.array.View) );
        recycler.setAdapter(adapter);
    }

    @Override
    public void Recycler_click() {
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String item = (String) adapter.getItem(position);
                Bundle bundle = new Bundle();
                bundle.putString(Constants.Item_Name,item);
                switch (item){
                    case FramentManages.Demo:
                        MyUtils.toDemo(activity,bundle);
                        break;
                    case FramentManages.RxToast:
                        MyUtils.toFragment(activity,bundle,FramentManages.RxToast);
                        break;
                    case FramentManages.BottomNavigation:
                        MyUtils.toFragment(activity,bundle,FramentManages.BottomNavigation);
                        break;
                    case FramentManages.RecyclerView:
                        MyUtils.toFragment(activity,bundle,FramentManages.RecyclerView);
                        break;
                    case FramentManages.Toolbar:
                        MyUtils.toFragment(activity,bundle,FramentManages.Toolbar);
                        break;
                    case FramentManages.TurnTableView:
                        MyUtils.toFragment(activity,bundle,FramentManages.TurnTableView);
                        break;
                    case FramentManages.MarqueeView:
                        MyUtils.toFragment(activity,bundle,FramentManages.MarqueeView);
                        break;
                    case FramentManages.DrawerLayout:
                        MyUtils.toFragment(activity,bundle,FramentManages.DrawerLayout);
                        break;
                    default:
                        RxToast.warning(activity,getString(R.string.function_unopen));
                        break;
                }
            }
        });
    }


}
