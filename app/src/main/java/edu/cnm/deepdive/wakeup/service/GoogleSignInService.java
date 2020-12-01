package edu.cnm.deepdive.wakeup.service;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import edu.cnm.deepdive.wakeup.BuildConfig;
import io.reactivex.Single;

/**
 * Creates the Google Sign-in for the application. The user uses their Google credentials to sign-in
 * to the app.
 */
public class GoogleSignInService {

  private static Application context;

  private final GoogleSignInClient client;

  private GoogleSignInAccount account;

  private GoogleSignInService() {
    GoogleSignInOptions options = new GoogleSignInOptions.Builder()
        .requestEmail()
        .requestId()
        .requestProfile()
//        .requestIdToken(BuildConfig.CLIENT_ID)
        .build();
    client = GoogleSignIn.getClient(context, options);
  }

  /**
   * Sets the context to use for the sign in service.
   * @param context The app context.
   */
  public static void setContext(Application context) {
    GoogleSignInService.context = context;
  }

  /**
   * Returns the instance of the Google sign-in service
   */
  public static GoogleSignInService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * Returns the users Google account.
   */
  public GoogleSignInAccount getAccount() {
    return account;
  }

  /**
   * Allows the app to refresh the users credentials to stay signed in.
   */
  public Single<GoogleSignInAccount> refresh() {
    return Single.create((emitter) ->
        client.silentSignIn()
            .addOnSuccessListener((account) -> {
              setAccount(account);
              emitter.onSuccess(account);
            })
            .addOnFailureListener(emitter::onError)
    );
  }

  /**
   * Starts the Google sign-in.
   * @param activity  The activity of the sign-in.
   * @param requestCode The request code of the sign-in.
   */
  public void startSignIn(Activity activity, int requestCode) {
    account = null;
    Intent intent = client.getSignInIntent();
    activity.startActivityForResult(intent, requestCode);
  }

  /**
   * Completes the Google sign-in.
   * @param data  The intent data if the task to sign-in.
   * @return  A Task that signs in the user.
   */
  public Task<GoogleSignInAccount> completeSignIn(Intent data) {
    Task<GoogleSignInAccount> task = null;
    try {
      task = GoogleSignIn.getSignedInAccountFromIntent(data);
      setAccount(task.getResult(ApiException.class));
    } catch (ApiException e) {
      // Exception will be passed automatically to onFailureListener.
    }
    return task;
  }

  /**
   * Signs the user out of there Google account on the app.
   */
  public Task<Void> signOut() {
    return client.signOut()
        .addOnCompleteListener((ignored) -> setAccount(null));
  }

  private void setAccount(GoogleSignInAccount account) {
    this.account = account;
//    if (account != null) {
//      //noinspection ConstantConditions
//      Log.d(getClass().getSimpleName(), account.getIdToken());
//    }
  }

  private static class InstanceHolder {

    private static final GoogleSignInService INSTANCE = new GoogleSignInService();
  }
}
