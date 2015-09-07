package org.fipro.e4.preferences.example.parts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class ColorHelper {

	private ColorHelper() {}
	
	public static Color getColor(String color) {
		if ("blue".equals(color)) {
			return Display.getDefault().getSystemColor(SWT.COLOR_BLUE);
		}
		else if ("red".equals(color)) {
			return Display.getDefault().getSystemColor(SWT.COLOR_RED);
		}
		else if ("green".equals(color)) {
			return Display.getDefault().getSystemColor(SWT.COLOR_GREEN);
		}
		
		return Display.getDefault().getSystemColor(SWT.COLOR_BLACK);
	}
}
