package edu.cnm.deepdive.wakeup.controller.ui.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.wakeup.R;
import edu.cnm.deepdive.wakeup.databinding.FragmentActivitiesBinding;

public class ActivitiesFragment extends Fragment {

  private ActivitiesViewModel activitiesViewModel;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    activitiesViewModel =
        ViewModelProviders.of(this).get(ActivitiesViewModel.class);
    View root = inflater.inflate(R.layout.fragment_activities, container, false);
    final TextView textView = root.findViewById(R.id.activities_list_view);
    activitiesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    return root;
  }
}