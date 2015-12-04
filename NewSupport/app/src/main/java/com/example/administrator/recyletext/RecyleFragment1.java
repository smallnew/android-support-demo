package com.example.administrator.recyletext;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/2.
 * 普通的recyleview
 */

public class RecyleFragment1 extends Fragment {
    private RecyclerView recyclerView;
    private SwipeRefreshLayout mSwipeRefresh;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button mBtnDel;
    private Button mBtnAdd;
    List<String> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.activity_recyle_main, container, false);
        mSwipeRefresh = (SwipeRefreshLayout) layout.findViewById(R.id.swipe_refresh_widget);
        recyclerView = (RecyclerView) layout.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        data = new ArrayList<String>();
        data.add("first");
        data.add("second");
        data.add("three");
        data.add("four");
        data.add("six");
        data.add("ten");
        data.add("nine");
        data.add("king");
        data.add("spring");
        data.add("bilibili");
        data.add("acfun");
        data.add("low");
        mAdapter = new RecAdapter(data);
        recyclerView.setAdapter(mAdapter);
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefresh.setRefreshing(false);
                    }
                }, 1000);
            }
        });
        mBtnAdd = (Button) layout.findViewById(R.id.btn_add);
        mBtnDel = (Button) layout.findViewById(R.id.btn_del);
        mBtnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.size() > 0) {
                    data.remove(0);
                    mAdapter.notifyItemRemoved(0);
                } else {

                }
            }
        });
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = data.size() / 3;
                data.add(index, "YOU ADD");
                mAdapter.notifyItemInserted(index);
            }
        });
        return layout;
    }

    public class RecAdapter extends RecyclerView.Adapter<RecAdapter.RecViewHodler> {

        List<String> data = new ArrayList<String>();
        int[] colors = new int[]{};

        public RecAdapter(List<String> list) {
            data = list;
        }

        @Override
        public RecViewHodler onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_recyle, null);
            TextView tv = (TextView) view.findViewById(R.id.tv_recyle_test);
            tv.setTextColor(Color.BLACK);
            return new RecViewHodler(view);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        @Override
        public void onBindViewHolder(RecViewHodler recViewHodler, int i) {
            recViewHodler.mTv.setText(data.get(i));
        }

        public class RecViewHodler extends RecyclerView.ViewHolder {
            TextView mTv;

            public RecViewHodler(View itemView) {
                super(itemView);
                mTv = (TextView) itemView.findViewById(R.id.tv_recyle_test);
            }
        }
    }

}
