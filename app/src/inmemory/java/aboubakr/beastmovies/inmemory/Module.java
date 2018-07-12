package aboubakr.beastmovies.inmemory;

import com.aboubakr.beastmovies.infrastructure.BeastMoviesApplication;

public class Module {

    public static void Register(BeastMoviesApplication application) {
        new InMemoryBrotherService(application);
//        new InMemoryFraternityEventsService(application);
//        new InMemoryEventPictureService(application);
//        new InMemoryRushEventService(application);
    }
}
