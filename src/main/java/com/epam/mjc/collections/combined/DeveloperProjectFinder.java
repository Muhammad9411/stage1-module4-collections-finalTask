package com.epam.mjc.collections.combined;

import java.util.*;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Set<String>> e : projects.entrySet()) {
            for (String s: e.getValue()) {
                if(developer.equals(s)) {
                    result.add(e.getKey());
                }
            }
        }

        Collections.reverse(result);

        return result;
    }
}
