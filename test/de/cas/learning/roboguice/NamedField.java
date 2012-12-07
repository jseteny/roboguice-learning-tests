package de.cas.learning.roboguice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import org.junit.Test;

import static de.cas.learning.roboguice.Constants.DB_CONNECTION_STRING;
import static junit.framework.TestCase.assertEquals;

/**
 * @author janos.seteny
 * @since 2012.12.07.
 */
public class NamedField {

    @Test
    public void field() {
        Injector injector = Guice.createInjector(new MyModule());
        A a = injector.getInstance(A.class);
        assertEquals("jdbc:mysql:cas.de", a.getExternalResourceInfo());
    }

    @Test
    public void constructorParameter() {
        Injector injector = Guice.createInjector(new MyModule());
        B b = injector.getInstance(B.class);
        assertEquals("Samsung", b.getPhoneType());
    }

    private class MyModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(String.class).annotatedWith(Names.named(DB_CONNECTION_STRING)).toInstance("jdbc:mysql:cas.de");
            // This would have the same effect right now:
            //bindConstant().annotatedWith(Names.named(DB_CONNECTION_STRING)).to("jdbc:mysql:cas.de");

            bind(String.class).annotatedWith(Names.named("phoneType")).toInstance("Samsung");
        }
    }
}
