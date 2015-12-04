package com.example.administrator.recyletext;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smallnew on 2015/12/2.
 * 瀑布流
 */
public class RecyleFragment3 extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button mBtnDel;
    private Button mBtnAdd;
    List<String> data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_recyle_3, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.recycler_view3);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
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
        mAdapter = new RecAdapter3(data);
        recyclerView.setAdapter(mAdapter);
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
                int index = data.size() / 5;
                data.add(index, "YOU ADD");
                mAdapter.notifyItemInserted(index);
            }
        });
        return layout;
    }

    public class RecAdapter3 extends RecyclerView.Adapter<RecAdapter3.RecViewHodler> {

        List<String> data = new ArrayList<String>();
        int[] colors = new int[]{};
        int[] ress = new int[]{R.mipmap.image11, R.mipmap.image12, R.mipmap.image13, R.mipmap.image14};

        public RecAdapter3(List<String> list) {
            data = list;
        }

        @Override
        public RecViewHodler onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_recyle3, null);
            TextView tv = (TextView) view.findViewById(R.id.tv_recyle3_title);
            tv.setTextColor(Color.BLACK);
            view.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            return new RecViewHodler(view);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        @Override
        public void onBindViewHolder(RecViewHodler recViewHodler, int i) {
            recViewHodler.mTv.setText(data.get(i));
            recViewHodler.mIv.setImageResource(ress[i % 4]);
        }

        public class RecViewHodler extends RecyclerView.ViewHolder {
            TextView mTv;
            ImageView mIv;

            public RecViewHodler(View itemView) {
                super(itemView);
                mTv = (TextView) itemView.findViewById(R.id.tv_recyle3_title);
                mIv = (ImageView) itemView.findViewById(R.id.iv_recyle3);
            }
        }
    }

}
