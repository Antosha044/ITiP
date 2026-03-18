package org.example;
import org.example.utils.StringProcessor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("start");

        Properties buildProps = new Properties();
        try (InputStream is = Main.class.getClassLoader().getResourceAsStream("build-passport.properties")) {
            if (is != null) {
                buildProps.load(is);
            } else {
                logger.warn("build-passport.properties not found!");
            }
        } catch (IOException e) {
            logger.error("Failed to load build-passport.properties", e);
        }

        if (!buildProps.isEmpty()) {
            System.out.println("==== build passport ====");
            System.out.println("username: " + buildProps.getProperty("username"));
            System.out.println("OS: " + buildProps.getProperty("os.name"));
            System.out.println("Java: " + buildProps.getProperty("java.version"));
            System.out.println("Build date: " + buildProps.getProperty("build.date"));
            System.out.println(buildProps.getProperty("greeting"));
            System.out.println("=======================");
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("input string: ");
        String input = scanner.nextLine();

        String reversed = StringUtils.reverse(input);
        String capitalized = StringUtils.capitalize(input);

        logger.info("reversed string: {}", reversed);
        logger.info("capitalized: {}", capitalized);

        logger.info("end");



        logger.info("start string utils module");

        Scanner scanner2 = new Scanner(System.in);
        System.out.print("input string: ");
        String input2 = scanner2.nextLine();

        String reversed2 = StringProcessor.reverse(input);
        String capitalized2 = StringProcessor.capitalize(input);

        logger.info("reversed string: {}", reversed2);
        logger.info("capitalized: {}", capitalized2);

        logger.info("end");
    }
}