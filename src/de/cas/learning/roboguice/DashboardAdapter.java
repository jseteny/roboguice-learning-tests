package de.cas.learning.roboguice;

import android.content.Context;

import javax.inject.Inject;

/**
 * @author janos.seteny
 * @since 2012.12.07.
 */
public class DashboardAdapter {

    private final Context context;
    private final Product product;

    @Inject
    public DashboardAdapter(Context context, Product product) {
        this.context = context;
        this.product = product;
    }

    public Context getContext() {
        return context;
    }

    public Product getProduct() {
        return product;
    }
}