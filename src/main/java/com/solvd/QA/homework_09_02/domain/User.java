package com.solvd.QA.homework_09_02.domain;

import com.zebrunner.carina.utils.R;

public enum User {
    VALID(R.TESTDATA.get("valid.login"), R.TESTDATA.get("valid.password")),
    INVALID_PASS(R.TESTDATA.get("valid.login"), R.TESTDATA.get("invalid.password")),
    INVALID_EMAIL(R.TESTDATA.get("invalid.login"), R.TESTDATA.get("valid.password"));

    private final String username;
    private final String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
