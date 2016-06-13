package hu.webtown.liferay.portlet.model.constant;

import java.util.HashMap;
import java.util.Map;

public enum DateRangeType {

    ANYTIME(1), BETWEEN(0), DATE_FROM(2), DATE_TO(3);

    private static final Map<Integer, DateRangeType> enumMap = 
    		new HashMap<Integer, DateRangeType>();

    static {
        enumMap.put(0, BETWEEN);
        enumMap.put(1, ANYTIME);
        enumMap.put(2, DATE_FROM);
        enumMap.put(3, DATE_TO);
    }

    private int key;

    DateRangeType(int key) {
        this.key = key;
    }

    public static DateRangeType getByKey(int key) {
        return enumMap.get(key);
    }

    public int getKey() {
        return key;
    }

    @Override
    public String toString() {
        return DateRangeType.class.getSimpleName() + "." + name();
    }
}
