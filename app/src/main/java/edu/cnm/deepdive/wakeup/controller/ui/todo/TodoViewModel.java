package edu.cnm.deepdive.wakeup.controller.ui.todo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * View model class for fragment
 */
public class TodoViewModel extends ViewModel {

  private MutableLiveData<String> mText;

  public TodoViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("This is todo fragment");
  }

  public LiveData<String> getText() {
    return mText;
  }
}