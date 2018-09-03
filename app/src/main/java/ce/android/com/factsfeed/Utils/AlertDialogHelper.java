package ce.android.com.factsfeed.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;

public class AlertDialogHelper {

    Context context;
    AlertDialog alertDialog = null;
    Activity current_activity;

    public AlertDialogHelper(Context context) {
        this.context = context;
        this.current_activity = (Activity) context;
    }

    /**
     * Displays the AlertDialog with positive action button only
     * <p>
     * cancelable property is false (Default)
     *
     * @param title
     * @param message
     * @param positive
     */
    public void showAlertDialog(String title, String message, String positive) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(current_activity);

        if (!TextUtils.isEmpty(title))
            alertDialogBuilder.setTitle(title);
        if (!TextUtils.isEmpty(message))
            alertDialogBuilder.setMessage(message);

        if (!TextUtils.isEmpty(positive)) {
            alertDialogBuilder.setPositiveButton(positive,
                    (arg0, arg1) -> {
                        alertDialog.dismiss();
                    });
        }

        alertDialogBuilder.setCancelable(false);


        alertDialog = alertDialogBuilder.create();
        alertDialog.show();

        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setEnabled(false);
    }

}
