package com.solvd.QA.homework_09_02.util;

import com.solvd.QA.homework_09_02.domain.UserDto;
import com.solvd.QA.homework_09_02.domain.UserType;
import com.zebrunner.carina.utils.R;

public final class UserService {

    private UserService() {
    }

    public static UserDto getUser(UserType type) {
        return switch (type) {
            case VALID -> new UserDto(R.TESTDATA.get("valid.login"), R.TESTDATA.get("valid.password"));
            case INVALID_PASS -> new UserDto(R.TESTDATA.get("valid.login"), R.TESTDATA.get("invalid.password"));
            case INVALID_EMAIL -> new UserDto(R.TESTDATA.get("invalid.login"), R.TESTDATA.get("valid.password"));
        };
    }
}
