package utils;

import pages.RegisterPage;

public class Methods {

    RegisterPage registerPage = new RegisterPage();
    public void clearAllFields() {
        registerPage.email.clear();
        registerPage.password.clear();
        registerPage.confirmpassword.clear();
    }
}
