package org.redquark.practice.designpatterns.builder;

public class LunchOrder {

    private final String bread;
    private final String condiments;
    private final String dressing;
    private final String meat;

    public LunchOrder(LunchOrderBuilder lunchOrderBuilder) {
        this.bread = lunchOrderBuilder.bread;
        this.condiments = lunchOrderBuilder.condiments;
        this.dressing = lunchOrderBuilder.dressing;
        this.meat = lunchOrderBuilder.meat;
    }

    public String getBread() {
        return bread;
    }

    public String getCondiments() {
        return condiments;
    }

    public String getDressing() {
        return dressing;
    }

    public String getMeat() {
        return meat;
    }

    public static class LunchOrderBuilder {
        private String bread;
        private String condiments;
        private String dressing;
        private String meat;

        public LunchOrderBuilder() {
        }

        public LunchOrder buildLunchOrder() {
            return new LunchOrder(this);
        }

        public LunchOrderBuilder bread(String bread) {
            this.bread = bread;
            return this;
        }

        public LunchOrderBuilder condiments(String condiments) {
            this.condiments = condiments;
            return this;
        }

        public LunchOrderBuilder dressing(String dressing) {
            this.dressing = dressing;
            return this;
        }

        public LunchOrderBuilder meat(String meat) {
            this.meat = meat;
            return this;
        }
    }
}
