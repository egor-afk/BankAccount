package Bank;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private float balance;
    private final List<Transaction> listTransaction;
    private final String owner_name;
    private final String account_number;

    public BankAccount(String owner_name, String account_number){

        this.owner_name = owner_name;
        this.account_number = account_number;
        this.balance = 0;
        this.listTransaction = new ArrayList<>();
        System.out.println("\nБанковский счёт создан\nВаш баланс: 0");

    }
    //функция для внесения денег
    public void DepositMoney(float amount, String date){

        this.listTransaction.add(new Transaction(amount, date, owner_name, "Банкомат"));
        this.balance += amount;
        System.out.println("Деньги внесены +" + amount);
        System.out.println("Ваш баланс: " + balance);

    }
    //функция для снятия денег
    public void WithdrawMoney(float amount, String date){

        if(balance - amount >= 0) {
            this.listTransaction.add(new Transaction(amount, date, "Банкомат", owner_name));
            this.balance -= amount;
            System.out.println("Деньги сняты -" + amount);
            System.out.println("Ваш баланс: " + balance);
        } else {
            System.out.println("На вашем счёте не достаточно средств!");
        }

    }
    //функция для перевода денег
    public void TransferMoney(float amount, String date, String recipient, String message){
        if(balance - amount >=0){
            this.listTransaction.add(new Transaction(amount, date, message, owner_name, recipient));
            this.balance -= amount;
            System.out.println("Деньги переведены -" + amount);
            System.out.println("Ваш баланс: " + balance);
        } else {
            System.out.println("На вашем счёте не достаточно средств!");
        }

    }
    //функция вывода баланса счёта
    public void getBalance(){

        System.out.println("\nВаш баланс: " + balance);

    }
    //функция вывода списка всех транзакций
    public void getListTransaction(){
        int count = 0;
        for(Transaction element : listTransaction){
            count++;
            System.out.println("\nТранзакция #" + count + element.getValues());
        }
        if(count == 0){
            System.out.println(" не найден");
        }
    }
    //функция поиска транзакций по дате
    public void findDateTransaction(String date){
        int count = 0;
        for(Transaction element : listTransaction){
            if(element.getDate().equals(date)){
                count++;
                System.out.println("\nТранзакция #" + count + element.getValues());
            }
        }
        if(count == 0){
            System.out.println(" не найден!");
        }
    }
    //функция поиска транзакций по сумме
    public void findAmountTransaction(float amount1, float amount2){
        int count = 0;
        for(Transaction element : listTransaction){
            if((amount1 <=element.getAmount()) && (element.getAmount() <= amount2)){
                count++;
                System.out.println("\nТранзакция #" + count + element.getValues());
            }
        }
        if(count == 0){
            System.out.println(" не найден!");
        }
    }
    //функция поиска транзакций по получателю
    public void findRecipientTransaction(String recipient){
        int count = 0;
        for(Transaction element : listTransaction){
            if(element.getRecipient().equals(recipient)){
                count++;
                System.out.println("\nТранзакция #" + count + element.getValues());
            }
        }
        if(count == 0){
            System.out.println(" не найден!");
        }
    }
    //функция поиска транзакций по сообщению
    public void findMessageTransaction(String message){
        int count = 0;
        for(Transaction element : listTransaction){
            if(element.getMessage().equals(message)){
                count++;
                System.out.println("\nТранзакция #" + count + element.getValues());
            }
        }
        if(count == 0){
            System.out.println(" не найден!");
        }
    }
}
