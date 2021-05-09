package br.ufes.pss.weather_data_display_final.log;

import org.json.JSONArray;

public class LogConfig {

    private static JSONArray jsonArray = new JSONArray();
    private static StringBuilder xmlArray = new StringBuilder();

    public static JSONArray getJsonArray() {
        return jsonArray;
    }

    public static void setJsonArray(JSONArray jsonArray) {
        LogConfig.jsonArray = jsonArray;
    }

    public static StringBuilder getXmlArray() {
        return xmlArray;
    }

    public static void setXmlArray(StringBuilder xmlArray) {
        LogConfig.xmlArray = xmlArray;
    }
}
