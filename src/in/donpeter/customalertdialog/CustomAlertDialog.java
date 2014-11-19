package in.donpeter.customalertdialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class CustomAlertDialog {
	private Activity activity;
	private Dialog dialog;
	private Boolean cancellable = true,dismiss = true;
	private Boolean singleButton = false;
	private Boolean doubleButton = true;
	private Boolean tripleButton = false;
	private String positiveButtonValue="Ok" ,neutralbuttonValue="Skip",negativeButtonValue="Cancel";
	private String titleHolder = "Title goes here"; 
	private String messageHolder = "Message goes here"; 
	private String title = titleHolder;
	private String message = messageHolder;
	private String TAG = "CustomDialog/TAG";
	
	public void setTitle(String title){
		this.title = title;
	}
	public void setMessage(String message){
		this.message = message;
	}
	public void setPositiveButton(String value){
		this.positiveButtonValue = value;
	}
	public void setNegativeButton(String value){
		this.negativeButtonValue = value;
	}
	public void setNeutralButton(String value){
		this.neutralbuttonValue = value;
	}
	public void setDialogCancellable(Boolean cancellable){
		this.cancellable = cancellable;
	}
	public void dismissOnButtonClick(Boolean dismiss){
		this.dismiss = dismiss;
	}
	public void setPositiveButtonOnly(){
		singleButton = true;
		doubleButton = false;
		tripleButton = false;
	}
	
	public void setDoubleButton(){
		singleButton = false;
		doubleButton = true;
		tripleButton = false;
	}
	public void setTripleButton(){
		singleButton = false;
		doubleButton = false;
		tripleButton = true;
	}
	public void setDefaultButtonCount(){
		setDoubleButton();
	}
	
	public CustomAlertDialog(Activity activity,Context context) {
		this.activity = activity;
	}

	public void showDialog(){
		dialog = new Dialog(activity);
		dialog.setCancelable(cancellable);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		dialog.setContentView(R.layout.custom_alert_view);
		TextView titleView = (TextView) dialog.findViewById(R.id.customAlertDialogTitle);
		titleView.setText(title);
		if(title.equals(titleHolder)){
			Log.w(TAG ,"Title for the dialog not set");
		}
		TextView messageView = (TextView) dialog.findViewById(R.id.customAlertDialogMessage);
		messageView.setText(message);
		if(message.equals(messageHolder)){
			Log.w(TAG ,"Title for the dialog not set");
		}
		Button negativeButton = (Button) dialog.findViewById(R.id.customAlertDialogNegativeButton);
		Button positiveButton = (Button) dialog.findViewById(R.id.customAlertDialogPositiveButton);
		Button neutralButton = (Button) dialog.findViewById(R.id.customAlertDialogNeutralButton);
		View positveButtonDivider = (View) dialog.findViewById(R.id.customAlertDialogPositiveBorder);
		View neutralButtonDivider = (View) dialog.findViewById(R.id.customAlertDialogNeutralBorder);
		if(singleButton){
			positiveButton.setVisibility(View.VISIBLE);
			positiveButton.setText(positiveButtonValue);
			positveButtonDivider.setVisibility(View.GONE);
			neutralButton.setVisibility(View.GONE);
			neutralButtonDivider.setVisibility(View.GONE);
			negativeButton.setVisibility(View.GONE);
		}else
			if(doubleButton){
				positiveButton.setVisibility(View.VISIBLE);
				positiveButton.setText(positiveButtonValue);
				positveButtonDivider.setVisibility(View.VISIBLE);
				neutralButton.setVisibility(View.GONE);
				neutralButtonDivider.setVisibility(View.GONE);
				negativeButton.setVisibility(View.VISIBLE);
				negativeButton.setText(negativeButtonValue);
			}else if (tripleButton) {
				positiveButton.setVisibility(View.VISIBLE);
				positiveButton.setText(positiveButtonValue);
				positveButtonDivider.setVisibility(View.VISIBLE);
				neutralButton.setVisibility(View.VISIBLE);
				neutralButton.setText(neutralbuttonValue);
				neutralButtonDivider.setVisibility(View.VISIBLE);
				negativeButton.setVisibility(View.VISIBLE);
				negativeButton.setText(negativeButtonValue);
			}
		
		negativeButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(dismiss){
					dialog.dismiss();
				}
				onNegativeButtonClick(v);
			}
		});
		neutralButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(dismiss){
					dialog.dismiss();
				}
				onNeutralButtonClick(v);
			}
		});
		positiveButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(dismiss){
					dialog.dismiss();
				}
				onPositiveButtonClick(v);
				onPositiveButtonClick(v, dialog);
			}
		});
		dialog.show();
	}
	/***
	 * interface functions.
	 * @param v
	 */
	public void onPositiveButtonClick(View v){
	}
	public void onPositiveButtonClick(View v,Dialog dialog){
	}
	public void onNegativeButtonClick(View v){
	}
	public void onNeutralButtonClick(View v){
	}

}
