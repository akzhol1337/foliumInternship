
class DataOne {

}

class DataTwo {

}

class AccountImpl{
    String parse() {
        return "parsed!";
    }
}

interface Account {
    String parseData();
}

class AccountImplAdapter implements Account {
    AccountImpl account;
    AccountImplAdapter(AccountImpl account){
        this.account = account;
    }
    public String parseData() {
        // converting unsuitable method to suitable to interface
        return account.parse();
    }
}

class Adapter {
    public static void main(String[] args) {
        
    }
}