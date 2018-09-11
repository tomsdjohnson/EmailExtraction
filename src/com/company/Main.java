package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Work\\Training\\EmailExtraction\\Sample.txt" );
        byte[] bytes = Files.readAllBytes(path);
        String fileContents =  new String(bytes);

        Pattern p = Pattern.compile("\\S*@(\\w+(\\.|\\-)\\w*((\\.)\\w*)*)\\s");
        Matcher m = p.matcher(fileContents);

        HashMap<String, Integer> hm = new HashMap<>();

        while(m.find()) {
            String domain = m.group(1);

            if (hm.containsKey(domain)) {
                hm.put(domain, hm.get(domain) + 1);
            }else{
                hm.put(domain, 1);
            }
        }
        System.out.println(hm);
    }
}
