package de.cas.learning.roboguice;

import android.widget.DashboardFragment;
import com.google.inject.*;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import org.junit.Test;

import static de.cas.learning.roboguice.Constants.DISPLAY_COCKPIT;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 * @author janos.seteny
 * @since 2012.12.07.
 */
public class Advanced {

    @Test
    public void dashboardFragmentOnPhone(){
        Injector injector = Guice.createInjector(new PhoneModule(), new CommonModule());
        DashboardFragment dashboardFragment = injector.getInstance(DashboardFragment.class);
        assertNotNull(dashboardFragment);
        assertTrue("displayCockpit must be true on phone", dashboardFragment.getDisplayCockpit());
    }

    @Test
    public void dashboardFragmentOnTablet(){
        Injector injector = Guice.createInjector(new TabletModule(), new CommonModule());
        DashboardFragment dashboardFragment = injector.getInstance(DashboardFragment.class);
        assertNotNull(dashboardFragment);
        assertFalse("displayCockpit must be false on tablet", dashboardFragment.getDisplayCockpit());
    }

    private class PhoneModule extends AbstractModule {
        @Override
        protected void configure() {
            bindConstant().annotatedWith(Names.named(DISPLAY_COCKPIT)).to(true);
        }
    }

    private class TabletModule extends AbstractModule {

        @Override
        protected void configure() {
            bindConstant().annotatedWith(Names.named(DISPLAY_COCKPIT)).to(false);
        }
    }

    private class CommonModule implements Module {
        @Override
        public void configure(Binder binder) {

        }

        @Provides
        DashboardFragment provideDashboardFragment(
                @Named(DISPLAY_COCKPIT) boolean displayCockpit){

            return DashboardFragment.newInstance(displayCockpit);
        }
    }
}
