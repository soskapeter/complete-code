package sk.complete.code.completecode;

public class Account {


    public static Account createFreelancerAccount() {
        return new Account(AccountType.Freelancer);
    }

    public static Account createHirerAccount() {
        return new Account(AccountType.Hirer);
    }

    private AccountType accountType;

    private Account(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public boolean isFreelancer() {
        return accountType == AccountType.Freelancer;
    }

    public boolean isHirer() {
        return accountType == AccountType.Hirer;
    }
}
