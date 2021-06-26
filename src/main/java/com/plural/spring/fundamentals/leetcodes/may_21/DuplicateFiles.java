package com.plural.spring.fundamentals.leetcodes.may_21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateFiles {

    private List<List<String>> constructFileSystem(String[] paths) {
        List<List<String>> answer = new ArrayList<>();
        if (paths == null || paths.length <= 0) return answer;

        Map<String, List<String>> fileSystem = new HashMap<>();
        for (String entry : paths) {
            String[] parts = entry.split(" ");
            for (int i=1; i<parts.length; i++) {
                String file = parts[i];
                int contentIndex = file.indexOf("(");
                String content = file.substring(contentIndex, file.length() - 1);
                String filePath = parts[0] + "/" + file.substring(0, contentIndex);
                if (!fileSystem.containsKey(content)) {
                    fileSystem.put(content, new ArrayList<>());
                }
                fileSystem.get(content).add(filePath);
            }
        }

        for (Map.Entry<String, List<String>> entry : fileSystem.entrySet()) {
            List<String> value = entry.getValue();
            if (value.size() > 1) {
                List<String> subAnswer = new ArrayList<>(value);
                answer.add(subAnswer);
            }
        }

        return answer;
    }
}
