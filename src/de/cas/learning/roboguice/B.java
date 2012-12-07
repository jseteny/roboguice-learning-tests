package de.cas.learning.roboguice;

import com.google.inject.name.Named;

import javax.inject.Inject;

/**
 * @author janos.seteny
 * @since 2012.12.07.
 */
public class B {

    private String phoneType;

    @Inject
    public B(@Named("phoneType") String phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneType() {
        return phoneType;
    }
}
