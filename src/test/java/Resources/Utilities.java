package Resources;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;
import gherkin.deps.com.google.gson.JsonElement;
import gherkin.deps.com.google.gson.JsonParser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

public class Utilities {

    /*method to get key value from a json response*/
    public String getJsonPath(Response response, String key)
    {
        String resp=response.asString();
        JsonPath   js = new JsonPath(resp);
        return js.get(key).toString();
    }

    /*method to get key value list from a json response*/
    public List<String> getJsonPathList(Response response, String key)
    {
        String resp=response.asString();
        JsonPath   js = new JsonPath(resp);
        return js.get(key);
    }

    /*method to beautify json response*/
    public String jsonBeautifier(String json){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(json);
        String prettyJsonString = gson.toJson(je);
        return prettyJsonString;
    }
}
