package edu.cnm.deepdive.wakeup.controller.ui.weather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.wakeup.R;

public class WeatherFragment extends Fragment {

  private WeatherViewModel weatherViewModel;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    weatherViewModel =
        new ViewModelProvider(this).get(WeatherViewModel.class);
    View root = inflater.inflate(R.layout.fragment_weather, container, false);
    final TextView textView = root.findViewById(R.id.text_weather);
    weatherViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    return root;
  }
}