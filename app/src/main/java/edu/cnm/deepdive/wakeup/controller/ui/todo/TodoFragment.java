package edu.cnm.deepdive.wakeup.controller.ui.todo;

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
import edu.cnm.deepdive.wakeup.databinding.FragmentTodoBinding;

public class TodoFragment extends Fragment {

  private TodoViewModel todoViewModel;
  private FragmentTodoBinding binding;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentTodoBinding.inflate(inflater);
    todoViewModel = new ViewModelProvider(this).get(TodoViewModel.class);
    return binding.getRoot();
  }
}