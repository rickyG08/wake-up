package edu.cnm.deepdive.wakeup.controller.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.wakeup.R;

/**
 * Fragment class for the settings.
 */
public class SettingsFragment extends Fragment {

  private SettingsViewModel settingsViewModel;

  /**
   * Constructor that creates the binding and view model.
   * @param inflater Layout inflater
   * @param container View group container
   * @param savedInstanceState The Bundle instance
   * @return The inflated binding root.
   */
  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    settingsViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);
    View root = inflater.inflate(R.layout.fragment_settings, container, false);
    final TextView textView = root.findViewById(R.id.text_settings);
    settingsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
          @Override
          public void onChanged(String s) {
            textView.setText(s);
          }
        });
      return root;
  }

}
