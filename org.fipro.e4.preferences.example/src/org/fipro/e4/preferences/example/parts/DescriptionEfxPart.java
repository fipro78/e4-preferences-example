package org.fipro.e4.preferences.example.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.fx.core.preferences.Preference;
import org.eclipse.fx.core.preferences.Value;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class DescriptionEfxPart {
	
	@Inject
	@Preference(nodePath="org.fipro.e4.preferences.example", key="description_color")
	Value<String> descriptionColorPreference;

	Text description;
	
	@PostConstruct
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout(SWT.VERTICAL));
		description = new Text(parent, SWT.MULTI | SWT.WRAP | SWT.READ_ONLY);
		description.setText("This is a simple text message!");
		description.setForeground(ColorHelper.getColor(descriptionColorPreference.getValue()));
		
		Composite panel = new Composite(parent, SWT.NONE);
		panel.setLayout(new RowLayout());
		Button button = new Button(panel, SWT.PUSH);
		button.setText("GREEN");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				descriptionColorPreference.publish("green");
			}
		});

	}

	@Inject
	@Optional
	void setTextColor(
			@Preference(nodePath="org.fipro.e4.preferences.example", key="description_color") String color) {

		System.out.println("e(fx)clipse: " + color);

		if (description != null && !description.isDisposed()) {
			description.setForeground(ColorHelper.getColor(color));
		}
	}

}