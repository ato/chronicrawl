package org.netpreserve.chronicrawl;

import org.jdbi.v3.core.mapper.reflect.JdbiConstructor;

import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;

public class Origin {
    public final long id;
    public final String name;
    public final Instant discovered;
    public final Instant lastVisit;
    public final Instant nextVisit;
    public final Long robotsCrawlDelay;
    public final byte[] robotsTxt;
    public final CrawlPolicy crawlPolicy;

    @JdbiConstructor
    public Origin(long id, String origin, Instant discovered, Instant lastVisit, Instant nextVisit, Long robotsCrawlDelay,
                  byte[] robotsTxt, CrawlPolicy crawlPolicy) {
        this.id = id;
        this.name = origin;
        this.discovered = discovered;
        this.lastVisit = lastVisit;
        this.nextVisit = nextVisit;
        this.robotsCrawlDelay = robotsCrawlDelay;
        this.robotsTxt = robotsTxt;
        this.crawlPolicy = crawlPolicy;
    }

    public String href() {
        return "origin?id=" + id + "#queue";
    }

    public String robotsTxtString() {
        return robotsTxt == null ? null : new String(robotsTxt, StandardCharsets.UTF_8);
    }
}
