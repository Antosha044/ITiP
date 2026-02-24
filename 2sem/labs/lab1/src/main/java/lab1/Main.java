package lab1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Application started");

        Person person = new Person("Ivan", 25);
        logger.debug("Created person object: {}", person);

        String json = JsonUtil.toJson(person);
        logger.info("Serialized to JSON: {}", json);

        Person p2 = JsonUtil.fromJson(json);
        logger.info("Deserialized person: {}", p2);

        logger.info("Application finished");
    }
}