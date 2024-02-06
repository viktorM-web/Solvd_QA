package com.solvd.QA.lecture01_02.carinaexample;

import com.solvd.QA.lecture01_02.carinaexample.api.GetUserByUsername;
import com.solvd.QA.lecture01_02.carinaexample.domain.User;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

public class UserTest {

    @Test
    public void verifyGetUserByUsernameTest() {
        User user = new User();
        user.setUsername("viktorM-web");
        user.setFirstname("Viktor");
        user.setLastname("M");

        GetUserByUsername getUserByUsername = new GetUserByUsername(user.getUsername());
        getUserByUsername.addProperty("user", user);
        getUserByUsername.expectResponseStatus(HttpResponseStatusType.OK_200);

        Response response = getUserByUsername.callAPI();
        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("datePredicate", data ->
                        isValidDate(data) &&
                        ZonedDateTime.parse(data).isAfter(LocalDate.of(2000, 1, 1).atStartOfDay(ZoneId.systemDefault())));

        getUserByUsername.validateResponse(comparatorContext);
    }

    private static boolean isValidDate(String data) {
        try {
            ZonedDateTime.parse(data);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
