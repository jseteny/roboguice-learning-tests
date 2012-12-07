package de.cas.learning.roboguice;

import android.content.Context;
import android.content.XRMBrowser;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

/*
* @author janos.seteny
* @since 2012.12.07.
*/
public class GettingStarted {

    private Injector injector;

    @Before
    public void setUp() throws Exception {
        injector = Guice.createInjector(new SimpleModule());
    }

    @Test
    public void injectAbstractContext(){
        DashboardAdapter dashboardAdapter = injector.getInstance(DashboardAdapter.class);

        assertNotNull(dashboardAdapter);
        assertNotNull(dashboardAdapter.getContext());
    }


    private class SimpleModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(Context.class).to(XRMBrowser.class);
        }
    }
}
