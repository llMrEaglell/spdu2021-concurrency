package com.newsagregator.url.generator;

import com.newsagregator.site.properties.loader.NewsSiteProperties;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class StranaURLGenerator extends BaseURLGenerator implements NewsSiteURLGenerator {
    public StranaURLGenerator(NewsSiteProperties properties, LocalDate date, int startCounterValue) {
        super(properties, date, startCounterValue);
    }

    @Override
    public String getUrl() {
        String urlPage;
        urlPage = String.format("%sday=%d-%d-%d/page-%d.html",
                properties.getBaseURL(),
                date.getYear(),
                date.getMonthValue(),
                date.getDayOfMonth(),
                pageCounter.get());
        return urlPage;
    }

    @Override
    public Set<String> fixShortURL(Set<String> urls) {
        return urls.stream()
                .map(s -> {
                    if (s.startsWith(properties.getFilter())) {
                        return s;
                    } else if (s.startsWith("/")) {
                        String newUrl = properties.getFilter();
                        return newUrl + s;
                    } else {
                        return s;
                    }
                })
                .collect(Collectors.toSet());
    }
}
