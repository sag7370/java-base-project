package online.bigzhouzhou.design_patterns.creative.builder;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

/**
 * URLBuilder类
 * date: 2024/8/12 14:45<br/>
 *
 * @author SAg <br/>
 */
public class URLBuilder {
    private String domain;

    private String scheme;

    private String path;

    private Map<String, String> query;

    public static URLBuilder builder() {
        return new URLBuilder();
    }

    public String build() {
        StringBuilder url = new StringBuilder();
        if (Objects.isNull(this.domain)
                || Objects.isNull(this.query)
                || Objects.isNull(this.path)
                || Objects.isNull(this.scheme)
        ) {
            throw new IllegalArgumentException("argument cannot be null");
        }
        url.append(this.scheme)
                .append("://")
                .append(this.domain)
                .append(this.path);
        if (!this.query.isEmpty()) {
            url.append("?");
            this.query.forEach((key, value) -> {
                url.append(key)
                        .append("=")
                        .append(URLEncoder.encode(value, StandardCharsets.UTF_8))
                        .append("&");
            });
        }
        return url.toString();
    }

    public String getDomain() {
        return domain;
    }

    public URLBuilder setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public String getScheme() {
        return scheme;
    }

    public URLBuilder setScheme(String scheme) {
        this.scheme = scheme;
        return this;
    }

    public String getPath() {
        return path;
    }

    public URLBuilder setPath(String path) {
        this.path = path;
        return this;
    }

    public Map<String, String> getQuery() {
        return query;
    }

    public URLBuilder setQuery(Map<String, String> query) {
        this.query = query;
        return this;
    }
}
