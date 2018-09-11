package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Work\\Training\\EmailExtraction\\Sample.txt" );
        byte[] bytes = Files.readAllBytes(path);
        String fileContents =  new String(bytes);

        Pattern p = Pattern.compile("\\w@softwire\\.com\\s");
        Matcher m = p.matcher(fileContents);

        int count= 0;

        while(m.find() == true) {
            count = count + 1;
        }

        System.out.println(count);
    }
}
