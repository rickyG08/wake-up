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
import edu.cnm.deepdive.wakeup.databinding.FragmentWeatherBinding;

public class WeatherFragment extends Fragment {

  private WeatherViewModel weatherViewModel;
  private FragmentWeatherBinding binding;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentWeatherBinding.inflate(inflater);
    weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
    return binding.getRoot();
  }

}