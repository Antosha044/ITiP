package lab1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("start");

        Person person = new Person("kolyan", 67);
        logger.info("created object: {}", person);

        String json = JsonUtil.toJson(person);
        logger.info("serialized to json: {}", json);

        Person p2 = JsonUtil.fromJson(json);
        logger.info("deserialized object: {}", p2);

        logger.info("finish");
    }
}