package com.company;

//This is all we need to import//
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

        //Create a path type variable called "path" which gets the location of the file we want to read//
        //The next command is used byte[] command to get the file from path and read it//
        //Finally we make a string called fileContents and make it equal to what the byte read so we now have the file contents as a string//
        Path path = Paths.get("C:\\Work\\Training\\EmailExtraction\\Sample.txt" );
        byte[] bytes = Files.readAllBytes(path);
        String fileContents =  new String(bytes);

        //This is where we use the searching, for this to work we must import the right files//
        //We create the pattern variable "p" which is made equal to our pattern with the command below//
        // Then create a matcher "m" that is equal to the pattern and then told what it wants to match//
        Pattern p = Pattern.compile("\\S*@(\\w+(\\.|\\-)\\w*((\\.)\\w*)*)\\s");
        Matcher m = p.matcher(fileContents);

        //Here I create a HashMap which is like a dictionary in Python//
        HashMap<String, Integer> hm = new HashMap<>();

        //This uses the command ".find" what this does is finds the pattern in the string//
        //The while loop here exits once it has found all the text that matches//
        while(m.find()) {

            //Here I create a string called "domain" and make it equal to the capture//
            //Where I specify "group(1)" tells me to only take text from the first set of brackets//
            String domain = m.group(1);

            //This is an if loop that checks if the Hash map all-ready contains a certain domain//
            //If it does it goes to that domain and puts the value up by one//
            //If it doesn't it creates a new instant of the domain in the HashMap and sets the value to 1//
            if (hm.containsKey(domain)) {
                hm.put(domain, hm.get(domain) + 1);
            }else{
                hm.put(domain, 1);
            }
        }
        //Prints out the HashMap//
        System.out.println(hm);
    }
}
