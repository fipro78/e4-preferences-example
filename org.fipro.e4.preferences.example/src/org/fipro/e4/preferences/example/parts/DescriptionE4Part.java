package org.fipro.e4.preferences.example.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.osgi.service.prefs.BackingStoreException;

public class DescriptionE4Part {

	Text description;
	
	@Inject
	@Preference(nodePath="org.fipro.e4.preferences.example")
	IEclipsePreferences prefs;
	
	@PostConstruct
	public void createPartControl(Composite parent, 
			@Preference(nodePath="org.fipro.e4.preferences.example", value="description_color") String color) {
		parent.setLayout(new FillLayout(SWT.VERTICAL));
		description = new Text(parent, SWT.MULTI | SWT.WRAP | SWT.READ_ONLY);
		description.setText("This is a simple text message!");
		description.setForeground(ColorHelper.getColor(color));
		
		Composite panel = new Composite(parent, SWT.NONE);
		panel.setLayout(new RowLayout());
		Button button = new Button(panel, SWT.PUSH);
		button.setText("RED");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				prefs.put("description_color", "red");
				try {
					prefs.flush();
				} catch (BackingStoreException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	@Inject
	@Optional
	void setTextColor(
			@Preference(nodePath="org.fipro.e4.preferences.example", value="description_color") String color) {

		System.out.println("Platform: " + color);
		
		if (description != null && !description.isDisposed()) {
			description.setForeground(ColorHelper.getColor(color));
		}
	}

}