package common;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Readjson {

    public static String readjsonconfig(String website, String keyword) throws IOException, ParseException {

        String k;

        Reader reader = new FileReader(ResourceHelper.getResourcePath("/src/test/java/com/config.json"));

        JSONParser parser = new JSONParser();
        JSONObject allObj = (JSONObject) parser.parse(reader);
        JSONObject envObj = (JSONObject) allObj.get(website);

        k = envObj.get(keyword).toString();
        System.out.println(k);
        return k;
    }

    public static String readjsonassert(String keyword) throws IOException, ParseException {

        String k;

        Reader reader = new FileReader(ResourceHelper.getResourcePath("/src/test/java/com/textasserts.json"));

        JSONParser parser = new JSONParser();
        JSONObject allObj = (JSONObject) parser.parse(reader);
        k = allObj.get(keyword).toString();
        System.out.println(k);
        return k;
    }

//        public static void main(String[] args) throws IOException, ParseException {
//
//        readjsonassert("username");
//    }
}
