package com.epam.mjc.collections.combined;

import java.util.*;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Set<String>> e : projects.entrySet()) {
            if (e.getValue().contains(developer)) {
                result.add(e.getKey());
            }
        }

        Collections.sort(result, new SortComparator());

        return result;
    }

    static class SortComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {

            int c = Integer.compare(b.length(), a.length());

            if (c == 0) {
                c = b.compareTo(a);
            }

            return c;
        }
    }
}
