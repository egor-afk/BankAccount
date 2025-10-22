package Bank;

public class Transaction {

    private final float amount;
    private final String date;
    private final String message;
    private final String sender;
    private final String recipient;

    public Transaction(float amount, String date, String message, String sender, String recipient){

        System.out.println("\nТранзакция проведена");
        this.amount = amount;
        this.date = date;
        this.message = message;
        this.sender = sender;
        this.recipient = recipient;

    }

    public Transaction(float amount, String date, String sender, String recipient){

        System.out.println("\nТранзакция проведена");
        this.amount = amount;
        this.date = date;
        this.sender = sender;
        this.recipient = recipient;
        this.message = "Без сообщения";

    }

    public String getValues(){

        return "\nСумма: " + amount + "\nДата: " + date + "\nОтправитель: " + sender +
                "\nПолучатель: " + recipient + "\nСообщение: " + message;

    }

    public String getDate(){
        return date;
    }

    public String getMessage(){
        return message;
    }

    public float getAmount(){
        return amount;
    }

    public String getRecipient(){
        return recipient;
    }
}