package edu.cnm.deepdive.wakeup.controller.ui.todo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.wakeup.R;
import edu.cnm.deepdive.wakeup.controller.MainActivity;
import edu.cnm.deepdive.wakeup.databinding.FragmentTodoBinding;

/**
 * Fragment class for the todo.
 */
public class TodoFragment extends Fragment {

  private TodoViewModel todoViewModel;
  private FragmentTodoBinding binding;
  private Button addTask;
  private EditText taskName;
  private EditText taskDescription;
  private EditText taskDate;
  private RecyclerView taskItemList;

  /**
   * Constructor that creates the binding and view model.
   * @param inflater Layout inflater
   * @param container View group container
   * @param savedInstanceState The Bundle instance
   * @return The inflated binding root.
   */
  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentTodoBinding.inflate(inflater);
    todoViewModel = new ViewModelProvider(this).get(TodoViewModel.class);
    return binding.getRoot();
  }
//
//  @Override
//  public void onCreate(@Nullable Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    addTask = getActivity().findViewById(R.id.add_button);
//    taskName = getActivity().findViewById(R.id.task_name);
//    taskDescription = getActivity().findViewById(R.id.task_description);
//    taskDate = getActivity().findViewById(R.id.task_date);
//    taskItemList = getActivity().findViewById(R.id.task_list_item);
//
//    addTask.setOnClickListener(new OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        if (!taskName.getText().toString().isEmpty() && !taskDescription.getText().toString()
//            .isEmpty() && !taskDate.getText().toString().isEmpty()) {
//
//          Intent intent = new Intent(Intent.ACTION_INSERT);
//
//        } else {
//          Toast.makeText(v, "Fill all fields.", Toast.LENGTH_LONG).show();
//        }
//      }
//    });
//  }
}