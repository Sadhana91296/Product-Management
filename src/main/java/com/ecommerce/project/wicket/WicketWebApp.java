package com.ecommerce.project.wicket;

import org.apache.wicket.application.IComponentInitializationListener;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

public class WicketWebApp extends WebApplication {

    @Override
    public Class<CategoryPage> getHomePage() {
        return CategoryPage.class;
    }
    @Override
    public void init()
    {
        super.init();
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));

    }
}
