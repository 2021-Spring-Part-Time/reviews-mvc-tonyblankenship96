package org.wecancoeit.reviews;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class QuarterbackRepository {

    Map<Long, Quarterback> quarterbacksList = new HashMap<>();

    public QuarterbackRepository(){
        Quarterback aaronRodgers = new Quarterback(1L, "Aaron Rodgers", "/images/AaronRodgers.jpg" ,"2005-current", "1", "103.9", "412-89");
        Quarterback brettFavre = new Quarterback(2L, "Brett Favre","/images/BrettFavre.jpg" ,"1991-2010", "1", "86.0", "508-336");
        Quarterback bartStarr = new Quarterback(3L, "Bart Starr", "/images/BartStarr.jpg" ,"1956-1971", "2", "80.5", "152-138");

        quarterbacksList.put(aaronRodgers.getId(), aaronRodgers);
        quarterbacksList.put(brettFavre.getId(), brettFavre);
        quarterbacksList.put(bartStarr.getId(), bartStarr);
    }

    public QuarterbackRepository(Quarterback ...quarterbacksToAdd) {
        for (Quarterback quarterback: quarterbacksToAdd){
            quarterbacksList.put(quarterback.getId(), quarterback);
        }
    }

    public Quarterback findOne(long id) {
        return quarterbacksList.get(id);
    }

    public Collection<Quarterback> findAll() {
        return quarterbacksList.values();
    }
}
