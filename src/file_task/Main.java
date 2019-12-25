package file_task;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException{
        try {
            Stream<String> lines = Files.lines(Paths.get("E://JAVA automn/file_task/temp.txt"));

            Map<String, Long> frequency = lines
                    .map(String::toLowerCase)
                    .map(line -> line.split(" "))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

            frequency
                    .entrySet()
                    .stream()
                    .sorted((ob1, ob2) -> ob1.getValue().compareTo(ob2.getValue()))
                    .limit(10)
                    .forEach(ob->System.out.println(ob.getKey() + " " + ob.getValue()));


        }  catch (IOException e) {
            e.printStackTrace();
            System.out.println("FILE NOT FOUND!");
        }
    }
}
