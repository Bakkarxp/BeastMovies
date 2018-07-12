package aboubakr.beastmovies.inmemory;

import com.aboubakr.beastmainbroject.entities.Brother;
import com.aboubakr.beastmainbroject.infrastructure.BeastApplication;
import com.aboubakr.beastmainbroject.services.BrotherServices;
import com.aboubakr.beastmovies.infrastructure.BeastMoviesApplication;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class InMemoryBrotherService extends BaseInMemory {

    public InMemoryBrotherService(BeastMoviesApplication application) {
        super(application);
    }

    @Subscribe
    public void getBrothers(BrotherServices.BrotherSearchRequest request) {
        BrotherServices.BrotherSearchResponse response = new BrotherServices.BrotherSearchResponse();
        response.brothers = new ArrayList<>();
        for (int i = 0; i < 48; i++) {
            String name = "brother" + i;
            String whyJoined = i + " joined for this reason";
            String url = "http://www.gravatar.com/avatar/"+i+"?d=identicon";
            String major = "Computer Science " + i;
            String crossSemester = "Spring 2013";
            String funFact = "I love to code";
            response.brothers.add(new Brother(i, name, whyJoined, url, major, crossSemester, funFact));
        }
        // data are put inside bus
        bus.post(response);
    }
}
