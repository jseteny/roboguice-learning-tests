package de.cas.learning.roboguice;

import com.google.inject.name.Named;

import javax.inject.Inject;

import static de.cas.learning.roboguice.Constants.DB_CONNECTION_STRING;

/**
 * @author janos.seteny
 * @since 2012.12.07.
 */
public class A {

    private @Inject
    @Named(DB_CONNECTION_STRING) String externalResourceInfo;

    public String getExternalResourceInfo() {
        return externalResourceInfo;
    }
}
