package edu.cnm.deepdive.wakeup.controller.ui.calendar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * View model class for fragment
 */
public class CalendarViewModel extends ViewModel {

  private MutableLiveData<String> mText;

  public CalendarViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("This is calendar fragment");
  }

  public LiveData<String> getText() {
    return mText;
  }
}