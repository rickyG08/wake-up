package edu.cnm.deepdive.wakeup.controller.ui.settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * View model class for fragment
 */
public class SettingsViewModel extends ViewModel {

  private MutableLiveData<String> mText;

  public SettingsViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("This is the settings fragment");
  }

  public LiveData<String> getText() {
    return mText;
  }

}
