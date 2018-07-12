package aboubakr.beastmovies.inmemory;

import com.aboubakr.beastmovies.infrastructure.BeastMoviesApplication;
import com.squareup.otto.Bus;

public class BaseInMemory {
    protected final BeastMoviesApplication application;
    protected final Bus bus;

    public BaseInMemory(BeastMoviesApplication application) {
        this.application = application;
        bus = application.getBus();
        bus.register(this);
    }
}
