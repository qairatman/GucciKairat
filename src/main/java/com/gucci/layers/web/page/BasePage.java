package com.gucci.layers.web.page;

import com.gucci.data.FakeData;
import com.gucci.layers.web.manager.ElementManager;
import org.assertj.core.api.SoftAssertions;

public abstract class BasePage <T extends BasePage>{

    public abstract T waitForPageLoaded();
    protected final ElementManager elementManager = new ElementManager();


}
