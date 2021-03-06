package com.newsagregator.url.generator;

import java.util.Set;

public interface NewsSiteURLGenerator {
    String getUrl();
    void minusDay();
    void setCounterToStart();
    int nextPageCounter();
    Set<String> fixShortURL(Set<String> urls);
}
