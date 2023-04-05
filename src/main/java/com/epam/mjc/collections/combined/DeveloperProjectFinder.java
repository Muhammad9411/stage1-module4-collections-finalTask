package com.epam.mjc.collections.combined;

import java.util.*;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {

        List<String> result = new ArrayList<>();
        Map<Integer, List<String>> m = new HashMap<>();
        for (Map.Entry<String, Set<String>> e : projects.entrySet()) {
            List<String> set = new ArrayList<>();
            if (e.getValue().contains(developer)) {
                set.add(e.getKey());
                if (m.containsKey(e.getKey().length())) {
                    List<String> set1 = m.get(e.getKey().length());
                    set1.add(e.getKey());
                    m.remove(e.getKey().length());
                    m.put(e.getKey().length(), set1);
                    continue;
                }

                m.put(e.getKey().length(), set);
            }
        }

        for (Map.Entry<Integer, List<String>> e : m.entrySet()) {
            if (e.getValue().size() > 1) {
                List<String> nl = e.getValue();
                Collections.sort(nl);
                Collections.reverse(nl);
                result.addAll(nl);
            } else {
                result.addAll(e.getValue());
            }
        }

        Collections.sort(result, new SortComparator());

        return result;
    }

    static class SortComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return Integer.compare(b.length(), a.length());
        }
    }
}
