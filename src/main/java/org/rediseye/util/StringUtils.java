package org.rediseye.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Date: 2016/12/14 下午6:18
 * Usage:
 */
public class StringUtils {
    public static Map<String, Object> getInfoMap(String info) {
        Map<String, Object> infoMap = new HashMap<>();
        Pattern pattern = Pattern.compile("([a-zA-Z_0-9]{1,}):(\\S*)");
        Matcher mat = pattern.matcher(info);
        String key;
        String valueStr;
        while (mat.find()) {
            if (mat.groupCount() == 2) {
                key = underline2Camel(mat.group(1));
                valueStr = mat.group(2);
                if (valueStr.contains(",")) {
                    valueStr = valueStr.replace(",", " ").replace("=", ":");
                    infoMap.put(key, getMap(valueStr));
                } else
                    infoMap.put(key, valueStr);
            }
        }
        return infoMap;
    }

    public static Map<String, String> getMap(String str) {
        Map<String, String> map = new HashMap<>();
        Pattern pattern = Pattern.compile("([a-zA-Z_0-9]{1,}):(\\S*)");
        Matcher mat = pattern.matcher(str);
        while (mat.find()) {
            if (mat.groupCount() == 2) {
                map.put(underline2Camel(mat.group(1)), mat.group(2));
            }
        }
        return map;
    }

    public static String underline2Camel(String underline) {
        Pattern pattern = Pattern.compile("[_]\\w");
        String camel = underline.toLowerCase();
        Matcher matcher = pattern.matcher(camel);
        String w;
        while (matcher.find()) {
            w = matcher.group().trim();
            camel = camel.replace(w, w.toUpperCase().replace("_", ""));
        }
        return camel;
    }
}
