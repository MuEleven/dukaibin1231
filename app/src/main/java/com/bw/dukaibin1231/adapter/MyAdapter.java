package com.bw.dukaibin1231.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bw.dukaibin1231.R;
import com.bw.dukaibin1231.bean.MyBean;

import java.util.List;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHodel> {
    private List<MyBean.RankingBean> list;
    public MyAdapter(List<MyBean.RankingBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.iteam, null);
        return new MyViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHodel holder, int i) {
        holder.text.setText(list.get(i).getName());
        Glide.with(holder.image).load(list.get(i).getAvatar())
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                //占位图
                .placeholder(R.drawable.ic_launcher_background)
                //错位图
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (onItemClickLintLner != null) {
                            onItemClickLintLner.OnItemClick(i);
                        }
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHodel extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.text)
        TextView text;

        public MyViewHodel(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    OnItemClickLintLner onItemClickLintLner;

    public void setOnItemClickLintLner(OnItemClickLintLner onItemClickLintLner) {
        this.onItemClickLintLner = onItemClickLintLner;
    }

    public interface OnItemClickLintLner {
        void OnItemClick(int i);
    }
}
