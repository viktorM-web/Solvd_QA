package com.solvd.QA.homework_13_02.mobile.gui.utill;

import com.solvd.QA.homework_13_02.mobile.gui.models.Account;
import com.zebrunner.carina.utils.R;

public final class AccountService {

    private AccountService() {
    }

    public static Account getValidAccount(){
        return new Account(null,
                R.TESTDATA.get("valid.login.android.app"),
                null,
                R.TESTDATA.get("valid.pass.android.app"));
    }

    public static Account getInvalidAccount(){
        return new Account(null,
                R.TESTDATA.get("valid.login.android.app"),
                null,
                "pqfe16691!?");
    }
}
