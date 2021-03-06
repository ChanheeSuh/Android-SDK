package com.wizturn.manager.dialog;

import com.wizturn.sample.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class DialogSettingMinor extends DialogFragment {
	private final String LOG_TAG = DialogSettingMinor.class.getSimpleName();
	public static final String FRAGMENT_TAG = "dialog_minor";
	
	private OnClickListener listener;
	private EditText edittext;
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View view = inflater.inflate(R.layout.dialog_one_edittext, null);
		edittext = (EditText)view.findViewById(R.id.edittext);
		
		edittext.setText(String.valueOf(getArguments().getInt("minor")));
		
		builder.setTitle(R.string.minor)
		.setView(view)
		.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if(listener != null) {
					listener.onOkayButtonClicked(
							DialogSettingMinor.this, edittext.getText().toString());
				}
			}
		})
		.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if(listener != null) {
					listener.onCancelButtonClicked(
							DialogSettingMinor.this, edittext.getText().toString());
				}
			}
		});
		
		return builder.create();
	}
	
	public void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}	
}
