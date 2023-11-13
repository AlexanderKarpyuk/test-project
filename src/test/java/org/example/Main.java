package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    /** Java 9 */

    /** JShell */

    /** Private methods in interfaces */

    @Test
    public void factory() {

        /* Old */

        Map<String, Integer> oldMap = new HashMap<>();
        oldMap.put("1", 1);
        oldMap.put("2", 2);

        Map<String, Integer> oldMap2 = new HashMap<>() {{
            put("1", 1);
            put("2", 2);
        }};

        /* New */

        Map<String, Integer> newMap = Map.of("1", 1, "2", 2);
    }

    @Test
    public void streamAPI() {

        /* iterate() и takeWhile() */

        List<String> takeStream = Stream.iterate("", s -> s + "s")
                .takeWhile(s -> s.length() < 10)
                .collect(Collectors.toList());
        System.out.println(takeStream);

        /* dropWhile() */

        Stream<Integer> stream= Stream.of(4, 4, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> list = stream.dropWhile(number -> (number / 4 == 1)) .collect(Collectors.toList());
        System.out.println(list);
    }

    /* Java 10 */

    @Test
    public void variable() {

        /* Old */

        String oldVar = "String";
        System.out.println(oldVar.getClass());

        /* New */

        var newVar = "String";
        System.out.println(newVar.getClass());
    }

    /* Java 11 */

    /** Single Source File Launch */

    @Test
    public void httpClient() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(new URI("https://postman-echo.com/post"))
                .headers("Content-Type", "text/plain;charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString("Sample request body"))
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    @Test
    public void stringsAndFiles() throws IOException {
        boolean s = "Marco".isBlank();
        Stream<String> s2 = "Mar\nco".lines();
        String s3 = "Marco  ".strip();

        Path path = Files.writeString(Files.createTempFile("helloworld", ".txt"), "Hi, my name is!");
        String str = Files.readString(path);
    }

    /* Java 14 */

    @Test
    public void switchCase() {

        String name = "Peter";

        /* Old */

        switch (name) {
            case "Peter":
                System.out.printf("%s is boss", name);
                break;
            case "John":
                System.out.printf("%s is worker", name);
                break;
            default:
                throw new IllegalArgumentException("Nobody");
        }

        /* New */

        switch (name) {
            case "Peter" -> System.out.printf("%s is boss", name);
            case "John" ->  System.out.printf("%s is worker", name);
            default -> throw new IllegalArgumentException("Nobody");
        }
    }

    /* Java 15 */

    @Test
    public void textsBlocks() {

        /* Old */

        String oldStr = "<html>\n" +
                "    <body>\n" +
                "        <p>Hello, world</p>\n" +
                "    </body>\n" +
                "</html>\n";

        /* New */

        String newStr = """
              <html>
                  <body>
                      <p>Hello, world</p>
                  </body>
              </html>
              """;
    }


    /* Java 16 */

    @Test
    public void instance() {

        /* Old */

        Object obj = "hello";
        if (obj instanceof String) {
            System.out.println("String length: " + ((String)obj).length());
        }

        /* New */

        Object obj2 = "hello";
        if (obj instanceof String mystr) {
            System.out.println("String length: " + mystr.length());
        }
    }

    @Test
    public void data() {

        record Pet(String name, int age) {}

        Pet pet = new Pet("Bobik", 3);
    }
}
