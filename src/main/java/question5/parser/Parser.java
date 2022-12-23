package question5.parser;

import question5.OurLPSFormater;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Parser {
    public List<OurLPSFormater> parse(String file) throws IOException {

        List<OurLPSFormater> lpsList = new LinkedList<OurLPSFormater>();

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        String method=null;
        String message=null;
        while ((line = bufferedReader.readLine()) != null) {
            if(line.contains("<method>")) {
                method = theEndOfInfo(line);
            }else {
                if(line.contains("<message>")) {
                    message = theEndOfInfo(line);
                    lpsList.add(new OurLPSFormater(method, message));
                }

            }
        }
        bufferedReader.close();
        inputStreamReader.close();
        return lpsList;

    }

    private String theEndOfInfo(String line) {
        String t1[]=line.split(">");
        String t2[]=t1[1].split("<");
        return t2[0];
    }

}
