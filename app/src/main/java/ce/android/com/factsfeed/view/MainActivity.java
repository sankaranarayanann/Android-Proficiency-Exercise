package ce.android.com.factsfeed.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ce.android.com.factsfeed.R;
import ce.android.com.factsfeed.model.FactsModel;
import ce.android.com.factsfeed.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.GetFacts().observe(this, (FactsModel facts) -> {
            if (facts != null) {
                setTitle(facts.getTitle());
            }
        });
    }
}
