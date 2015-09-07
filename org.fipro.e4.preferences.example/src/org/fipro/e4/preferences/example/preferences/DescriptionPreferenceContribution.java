package org.fipro.e4.preferences.example.preferences;

import org.fipro.e4.service.preferences.PreferenceNodeContribution;

public class DescriptionPreferenceContribution extends PreferenceNodeContribution {

	public DescriptionPreferenceContribution() {
		super("description", "Description", null, DescriptionPreferencePage.class, null, null);
	}
}
