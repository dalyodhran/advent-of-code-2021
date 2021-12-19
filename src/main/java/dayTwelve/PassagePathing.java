package dayTwelve;

import java.util.*;

public class PassagePathing {
    public int getPaths(String data) {
        String [] paths = data.split("\\r?\\n");
        Map<String, List<String>> pathMap = getPathMap(paths);
        int numberOfPaths = findAllPaths("start", "end", pathMap);
        return numberOfPaths;
    }

    private int findAllPaths(String src, String dest, Map<String, List<String>> pathMap) {
        int count = 0;
        Queue<List<String>> queue = new LinkedList<>();


        List<String> path = new ArrayList<>();
        path.add(src);
        queue.add(path);

        while (!queue.isEmpty()) {

            path = queue.poll();
            String last = path.get(path.size() - 1);

            if (last.equals(dest)) {
                count++;
            }

            List<String> lastEdge = pathMap.get(last);
            for (String edge: lastEdge) {
                if (canVisitEdge(edge, path)) {
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(edge);
                    queue.offer(newPath);
                }
            }
        }

        return count;
    }

    private boolean canVisitEdge(String edge, List<String> visitedEdges) {
        boolean hasNotVisited = true;
        for (String previousEdges : visitedEdges) {
            if (previousEdges.equals(edge)) {
                hasNotVisited = false;
                break;
            }
        }
        return Character.isUpperCase(edge.charAt(0)) ||
                Character.isLowerCase(edge.charAt(0)) && hasNotVisited;
    }

    private Map<String, List<String>> getPathMap(String[] pathsList) {
        Map<String, List<String>> tmpPathMap = new HashMap<>();
        for (String paths: pathsList) {
            String[] path = paths.split("-");
            List<String> tmpPaths = new ArrayList<>();

            if (tmpPathMap.containsKey(path[0])) {
                tmpPaths = tmpPathMap.get(path[0]);
            }
            tmpPaths.add(path[1]);
            tmpPathMap.put(path[0], tmpPaths);
            tmpPaths = new ArrayList<>();

            if (tmpPathMap.containsKey(path[1])) {
                tmpPaths = tmpPathMap.get(path[1]);
            }
            tmpPaths.add(path[0]);
            tmpPathMap.put(path[1], tmpPaths);

        }
        return tmpPathMap;
    }
}
