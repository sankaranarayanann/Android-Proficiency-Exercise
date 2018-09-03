package ce.android.com.factsfeed.view.fragment;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import ce.android.com.factsfeed.R;
import ce.android.com.factsfeed.Utils.Utils;
import ce.android.com.factsfeed.adapter.DataAdapter;
import ce.android.com.factsfeed.model.FactsModel;
import ce.android.com.factsfeed.viewmodel.MainViewModel;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

public class MainFragment extends Fragment {

    MainViewModel viewModel;
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;

    public MainFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        recyclerView = view.findViewById(R.id.data_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), VERTICAL));

        swipeRefreshLayout.setRefreshing(true);
        refreshList();

        // Refresh listener
        swipeRefreshLayout.setOnRefreshListener(this::refreshList);
    }

    private void refreshList() {

        // Adapter for recycler view
        final DataAdapter data = new DataAdapter();
        recyclerView.setAdapter(data);

        if (Utils.isInternetConnected(getContext())) {
            viewModel.GetFacts().observe(this, (FactsModel facts) -> {
                if (facts != null) {
                    getActivity().setTitle(facts.getTitle());
                    data.updateData(facts.getRows());
                } else {
                    Toast.makeText(getContext(), R.string.failure_text, Toast.LENGTH_LONG).show();
                }
                swipeRefreshLayout.setRefreshing(false);
            });
        } else {
            swipeRefreshLayout.setRefreshing(false);
            Toast.makeText(getContext(), R.string.nointernetconnection_msg, Toast.LENGTH_LONG).show();
        }
    }

}
