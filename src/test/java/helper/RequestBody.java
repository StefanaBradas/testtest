package helper;

import com.google.gson.Gson;

import java.util.HashMap;

public class RequestBody {


    static HashMap<String, String> hasMap = new HashMap<>();

    static public void putValues(String name, String job) {
        hasMap.put("name", name);
        hasMap.put("job", job);
    }


    public String makeJsonFormat () {
        Gson gson = new Gson();
        return gson.toJson(hasMap);
    }




}
