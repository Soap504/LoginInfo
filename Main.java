public class Main {
    public static void main(String[] args){
        IDandPasswords idandPasswords = new IDandPasswords();
        idandPasswords.loadFromFile();
        LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
        //NewUser userInfo = new NewUser(idandPasswords.getLoginInfo());
    }
}