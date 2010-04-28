package com.evancharlton.mileage.views;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class FormattedNumberView extends TextView {
	private static final NumberFormat FORMAT = DecimalFormat.getNumberInstance();

	public FormattedNumberView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public void setText(CharSequence text, BufferType type) {
		try {
			double value = Double.parseDouble(text.toString());
			super.setText(FORMAT.format(value), type);
		} catch (Exception e) {
			super.setText(text, type);
		}
	}
}
