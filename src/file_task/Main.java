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
//            File file = new File("/E:/JAVA automn/file_task/temp.txt");
//            FileReader fr = new FileReader(file);
//            BufferedReader reader = new BufferedReader(fr);
//
//            Map<String, Integer> frequency = new TreeMap<String, Integer>();
//            String line = reader.readLine();
//            String str = new String();
//            str += line;
//            while (line != null) {
//                line = reader.readLine();
//                str+= " " + line;
//            }
//
//            String[] subStr;
//            subStr = str.split(" ");
//
//            String tempStr;
//            for(int i = 0; i < subStr.length; i++){
//                tempStr = subStr[i].toLowerCase();
//                frequency.merge();   //??
//            }
// stream api
            Stream<String> lines = Files.lines(Paths.get("E://JAVA automn/file_task/temp.txt"));

            Map<String, Long> frequency = lines
                    .map(String::toLowerCase)
                    .map(line -> line.split(" "))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

            frequency
                    .entrySet()
                    .stream()
                    .sorted((ob1, ob2) -> ob2.getValue().compareTo(ob1.getValue()))
                    .limit(10)
                    .forEach(ob->System.out.println(ob.getKey() + " " + ob.getValue()));


        }  catch (IOException e) {
            e.printStackTrace();
            System.out.println("FILE NOT FOUND!");
        }
    }
}
