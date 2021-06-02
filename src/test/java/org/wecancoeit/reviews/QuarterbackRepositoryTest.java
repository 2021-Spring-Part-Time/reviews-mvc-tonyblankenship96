package org.wecancoeit.reviews;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuarterbackRepositoryTest {

    private QuarterbackRepository underTest;
    private Quarterback quarterbackOne = new Quarterback(1L, "Name","image" ,"Years active", "superBowl Wins", "Passer Rating", "TD to Int");
    private Quarterback quarterbackTwo = new Quarterback(2L, "Name", "image","Years active", "SuperBowl Wins", "Passer Rating", "TD to Int");

    @Test
    public void shouldFindOneQuarterBack() {
        underTest = new QuarterbackRepository(quarterbackOne);
        Quarterback foundQuarterback = underTest.findOne(1L);
        assertEquals(quarterbackOne, foundQuarterback);
    }

    @Test
    public void shouldFindTwoQuarterbacks() {
        underTest = new QuarterbackRepository(quarterbackOne, quarterbackTwo);
        Collection<Quarterback> foundQuarterbacks = underTest.findAll();
        assertThat(foundQuarterbacks).contains(quarterbackOne, quarterbackTwo);
    }

}
