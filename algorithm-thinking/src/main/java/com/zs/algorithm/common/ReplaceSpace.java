package com.zs.algorithm.common;

public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                stringBuilder.append(c);
            } else {
                stringBuilder.append("%20");
            }
        }
        return stringBuilder.toString();
    }
}
