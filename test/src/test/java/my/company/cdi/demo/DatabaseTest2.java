package my.company.cdi.demo;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseTest2 {


    @Test
    void test() {
        MySQLContainer container = MySQLInstance.INSTANCE.get();
        assertTrue(container.isRunning());
    }

}
