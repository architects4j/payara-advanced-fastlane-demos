package my.compary.cdi.demo;

import my.company.cdi.api.CDIExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@CDIExtension
class ItemTest {

    @Inject
    private Item item;

    @Test
    public void shouldNotNull() {
        Assertions.assertNotNull(item);
    }

}