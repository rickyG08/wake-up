package edu.cnm.deepdive.wakeup.controller.ui.calendar;

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
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.wakeup.R;
import edu.cnm.deepdive.wakeup.databinding.FragmentCalendarBinding;

public class CalendarFragment extends Fragment {

  private CalendarViewModel calendarViewModel;
  private FragmentCalendarBinding binding;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
   binding = FragmentCalendarBinding.inflate(inflater);
   calendarViewModel = new ViewModelProvider(this).get(CalendarViewModel.class);
   return binding.getRoot();
  }
}