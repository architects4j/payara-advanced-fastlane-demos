package my.company.cdi.demo;

import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.function.Supplier;

public enum MySQLInstance implements Supplier<MySQLContainer> {

    INSTANCE;

    private final  MySQLContainer container;

    MySQLInstance() {
        DockerImageName mysql = DockerImageName.parse("mysql");
        String tag = "5.7.34";
        this.container = new MySQLContainer(mysql.withTag(tag));
        this.container.start();
    }

    @Override
    public MySQLContainer get() {
        return container;
    }
}
