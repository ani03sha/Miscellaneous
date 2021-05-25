package org.redquark.practice.designpatterns.factory;

public class WebsiteFactory {

    public static Website getWebsite(WebsiteType type) {
        return switch (type) {
            case BLOG -> new Blog();
            case SHOP -> new Shop();
        };
    }
}
