package sr.unasat.designPatterns.cor;

public class AuthenticationChain {

    public AuthenticationHandler firstAuthenticationHandler;

    public AuthenticationChain() {
        Login login = new Login();
        FirstRetry firstRetry = new FirstRetry();
        SecondRetry secondRetry = new SecondRetry();
        ResetPassword resetPassword = new ResetPassword();
        login.setNextHandler(firstRetry);
        firstRetry.setNextHandler(secondRetry);
        secondRetry.setNextHandler(resetPassword);
        this.firstAuthenticationHandler = login;
    }
}
