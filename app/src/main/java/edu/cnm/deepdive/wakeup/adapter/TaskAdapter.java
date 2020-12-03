package edu.cnm.deepdive.wakeup.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.wakeup.adapter.TaskAdapter.Holder;
import edu.cnm.deepdive.wakeup.databinding.FragmentTodoBinding;
import edu.cnm.deepdive.wakeup.model.entity.Todo;
import java.util.ArrayList;
import java.util.List;

/**
 * Adapter for the list of tasks.
 */
public class TaskAdapter extends RecyclerView.Adapter<Holder> {

  private final Context context;
  private final LayoutInflater inflater;
  private final List<Todo> tasks;
  private final OnClickListener listener;

  /**
   * Constructor for adapter
   * @param context The context of the adapter
   * @param listener The on click listener for the button
   */
  public TaskAdapter(Context context,
      OnClickListener listener) {
    this.context = context;
    tasks = new ArrayList<>();
    inflater = LayoutInflater.from(context);
    this.listener = listener;
  }


  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    FragmentTodoBinding binding = FragmentTodoBinding.inflate(inflater, parent, false);
    return new Holder(binding);
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);

  }

  @Override
  public int getItemCount() {
    return 0;
  }

  /**
   * Holder class to get the binding and the task list.
   */
  public class Holder extends RecyclerView.ViewHolder {

    private final FragmentTodoBinding binding;

    public Holder(FragmentTodoBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    private void bind(int position) {
      Todo todo = tasks.get(position);
      binding.taskName.setText(position + 1);
    }
  }

}
