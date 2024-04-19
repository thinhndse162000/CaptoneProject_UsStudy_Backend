package com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.MergeRequest;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MergeRequest {
    /**
     * Merge ignore null value
     *
     * @param source
     * @param target
     */
    public static void mergeIgnoreNullValue(Object source, Object target) {
        Field[] sourceFields = source.getClass().getDeclaredFields();
        AccessibleObject.setAccessible(sourceFields, true);
        Field[] targetFields = target.getClass().getDeclaredFields();
        AccessibleObject.setAccessible(targetFields, true);
        Map<String, Field> map = new HashMap<>(0);
        for (Field field : targetFields) {
            map.put(field.getName(), field);
        }
        for (Field field : sourceFields) {
            try {
                if (field.get(source) != null) {
                    Field f = map.get(field.getName());
                    f.set(target, field.get(source));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
