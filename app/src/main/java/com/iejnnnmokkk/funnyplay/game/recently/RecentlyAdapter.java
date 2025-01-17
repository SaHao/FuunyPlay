package com.iejnnnmokkk.funnyplay.game.recently;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.iejnnnmokkk.common.base.BaseAdapter;
import com.iejnnnmokkk.funnyplay.R;
import com.iejnnnmokkk.funnyplay.library.detail.GameDetailActivity;
import com.iejnnnmokkk.funnyplay.personal.PersonalBean;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecentlyAdapter extends BaseAdapter<PersonalBean.DataBean, RecentlyAdapter.ViewHolder> {

    public RecentlyAdapter(Context context) {
        super(context);
    }

    @Override
    protected ViewHolder onCreateHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.content_recently, parent, false));
    }

    @Override
    protected void onBindHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(getNull(data.get(position).getName()));
        holder.tvNum.setText(data.get(position).getReward() + "");
        Glide.with(context).load(getNull(data.get(position).getIcon())).into(holder.ivLogo);

        holder.itemView.setOnClickListener(v -> {
            if(data.get(position).getType() == 18) {
                context.startActivity(new Intent(context, GameDetailActivity.class).putExtra("id", getNull(data.get(position).getNo())));
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_logo)
        RoundedImageView ivLogo;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_num)
        TextView tvNum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
