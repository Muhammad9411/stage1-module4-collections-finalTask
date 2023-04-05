package com.epam.mjc.collections.combined;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapFromKeysCreator {
    public Map<Integer, Set<String>> createMap(Map<String, Integer> sourceMap) {

        Map<Integer, Set<String>> result = new HashMap<>();

        for (Map.Entry<String, Integer> e : sourceMap.entrySet()) {
            Set<String> set = new HashSet();
            set.add(e.getKey());

            if(result.containsKey(e.getKey().length())) {
                Set<String> set1 = result.get(e.getKey().length());
                set1.add(e.getKey());
                result.remove(e.getKey().length());
                result.put(e.getKey().length(), set1);
                continue;
            }
            result.put(e.getKey().length(), set);
        }

        return result;
    }
}
