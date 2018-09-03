package ce.android.com.factsfeed.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import ce.android.com.factsfeed.R;
import ce.android.com.factsfeed.databinding.ItemDataBinding;
import ce.android.com.factsfeed.model.FeedModel;
import ce.android.com.factsfeed.viewmodel.DataListViewModel;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    private List<FeedModel> feed_list = new ArrayList<>();

    public DataAdapter() {

    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data,
                new FrameLayout(parent.getContext()), false);
        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        FeedModel dataModel = feed_list.get(position);
        holder.setViewModel(new DataListViewModel(dataModel));
    }

    @Override
    public int getItemCount() {
        return this.feed_list.size();
    }

    @Override
    public void onViewAttachedToWindow(DataViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(DataViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    public void updateData(@Nullable ArrayList<FeedModel> data) {
        if (data == null || data.isEmpty()) {
            this.feed_list.clear();
        } else {
            this.feed_list.addAll(data);
        }
        notifyDataSetChanged();
    }

    static class DataViewHolder extends RecyclerView.ViewHolder {
        ItemDataBinding binding;

        DataViewHolder(View itemView) {
            super(itemView);
            bind();
        }

        void bind() {
            if (binding == null) {
                binding = DataBindingUtil.bind(itemView);
            }
        }

        void unbind() {
            if (binding != null) {
                binding.unbind();
            }
        }

        void setViewModel(DataListViewModel viewModel) {
            if (binding != null) {
                binding.setViewmodel(viewModel);
            }
        }
    }
}
