package org.ga4gh.passports.refimpl.admin.model;

import java.util.HashMap;
import java.util.Map;

public class UserPool {

    private Map<String, User> users;

    public UserPool() {
        users = new HashMap<>();
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public Map<String, User> getUsers() {
        return users;
    }
}
