package android.widget;

import de.cas.learning.roboguice.DashboardAdapter;
import de.cas.learning.roboguice.Product;

/**
 * @author janos.seteny
 * @since 2012.12.07.
 */
public class DashboardFragment {
    private DashboardAdapter mAdapter;
    private GridView gridview;
    private Product product;
    private boolean displayCockpit;

    public DashboardFragment() {
    }

    public static DashboardFragment newInstance(boolean displayCockpit) {
        DashboardFragment dashboardFragment = new DashboardFragment();
        dashboardFragment.displayCockpit = displayCockpit;
        return dashboardFragment;
    }

    public DashboardAdapter getAdapter() {
        return mAdapter;
    }

    public GridView getGridview() {
        return gridview;
    }

    public Product getProduct() {
        return product;
    }

    public boolean getDisplayCockpit() {
        return displayCockpit;
    }
}
