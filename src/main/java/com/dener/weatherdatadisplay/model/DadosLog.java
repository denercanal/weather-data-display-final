package com.dener.weatherdatadisplay.model;

import org.json.simple.JSONArray;

public class DadosLog {

    private static JSONArray jsonArray = new JSONArray();
    private static StringBuilder xmlArray = new StringBuilder();

    public static StringBuilder getXmlArray() {
        return xmlArray;
    }

    public static void setXmlArray(StringBuilder xmlArray) {
        DadosLog.xmlArray = xmlArray;
    }

    public static JSONArray getJsonArray() {
        return jsonArray;
    }

    public static void setJsonArray(JSONArray jsonArray) {
        DadosLog.jsonArray = jsonArray;
    }
}
