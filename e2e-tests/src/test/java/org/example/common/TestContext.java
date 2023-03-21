package org.example.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aliaksei.Kurbatau
 * @since 12/26/2022
 */
public class TestContext {

    private final Map<String, Object> map = new HashMap<>();

    public Map<String, Object> getContext() {
        return map;
    }

    public void setUserName(String userName) {
        map.put("user_name", userName);
    }

    public String getUserName() {
        return (String) map.get("user_name");
    }

    public void setUserId(Long userId) {
        map.put("user_id", userId);
    }

    public Long getUserId() {
        return (Long) map.get("user_id");
    }
}
