package Bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        BankAccount myBank = null;
        while (true){
            printMenu();
            int number = getInt(scan);
            scan.nextLine();
            switch (number){

                case 1:
                    if(myBank == null) {
                        try {
                            System.out.println("Создание банковского счёта");
                            System.out.print("Введите имя владельца: ");
                            String owner_name = getString(scan);
                            System.out.print("Введите номер счета(20 цифр): ");
                            String account_number = scan.nextLine();
                            if (!(account_number.length() == 20)) {
                                throw new IllegalArgumentException("Номер счёта должен содержать 20 цифр");
                            } else {
                                myBank = new BankAccount(owner_name, account_number);
                            }
                        } catch (Exception e) {
                            System.out.println("Ошибка при создании банковского счета\n" + e.getMessage());
                        }
                    } else{
                        System.out.println("Банковский счёт уже создан!");
                        break;
                    }
                    break;

                case 2:
                    if(myBank == null){
                        System.out.println("Ошибка: сначала создайте банковский счет");
                    }
                    else {
                        System.out.println("Внесение денег");
                        System.out.print("Введите сумму денег: ");
                        float amount = getFloat(scan);
                        System.out.print("Введите дату в формате дд.мм.гггг: ");
                        scan.nextLine();
                        String date = validDate(scan);
                        myBank.DepositMoney(amount, date);
                    }
                    break;

                case 3:
                    if(myBank == null){
                        System.out.println("Ошибка: сначала создайте банковский счет");
                    }
                    else {
                        System.out.print("Снятие денег");
                        myBank.getBalance();
                        System.out.print("Введите сумму денег: ");
                        float amount1 = getFloat(scan);
                        System.out.print("Введите дату в формате дд.мм.гггг: ");
                        scan.nextLine();
                        String date1 = validDate(scan);
                        myBank.WithdrawMoney(amount1, date1);
                    }
                    break;

                case 4:
                    if(myBank == null){
                        System.out.println("Ошибка: сначала создайте банковский счет");
                    }
                    else {
                        myBank.getBalance();
                    }
                    break;

                case 5:
                    if(myBank == null){
                        System.out.println("Ошибка: сначала создайте банковский счет");
                    }
                    else {
                        System.out.println("Список транзакций:");
                        myBank.getListTransaction();
                    }
                    break;

                case 6:
                    if(myBank == null){
                        System.out.println("Ошибка: сначала создайте банковский счет");
                    }
                    else {
                        System.out.print("Перевод денег");
                        myBank.getBalance();
                        System.out.print("Введите сумму денег: ");
                        float amount2 = getFloat(scan);
                        System.out.print("Введите дату в формате дд.мм.гггг: ");
                        scan.nextLine();
                        String date2 = validDate(scan);
                        System.out.print("Введите имя получателя: ");
                        String recipient2 = getString(scan);
                        System.out.print("Введите сообщение получателю: ");
                        String message2 = getString(scan);
                        myBank.TransferMoney(amount2, date2, recipient2, message2);
                    }
                    break;

                case 7:
                    if(myBank == null){
                        System.out.println("Ошибка: сначала создайте банковский счет");
                    }
                    else {
                        System.out.println("Поиск транзакций по атрибутам");
                        System.out.println("Введите цифру 1, чтобы искать по дате");
                        System.out.println("Введите цифру 2, чтобы искать по сумме(интервал)");
                        System.out.println("Введите цифру 3, чтобы искать по получателю");
                        System.out.println("Введите цифру 4, чтобы искать по сообщению");
                        int num = getInt(scan);
                        scan.nextLine();
                        switch (num) {

                            case 1:
                                System.out.print("Введите дату: ");
                                String findDate = validDate(scan);
                                System.out.print("Список найденных транзакций по дате " + findDate);
                                myBank.findDateTransaction(findDate);
                                break;

                            case 2:
                                System.out.print("Введите минимальную сумму: ");
                                float findMinAmount = getFloat(scan);
                                System.out.print("Введите максимальную сумму: ");
                                float findMaxAmount = getFloat(scan);
                                System.out.print("Список найденных транзакций по сумме от " + findMinAmount + " до " + findMaxAmount);
                                myBank.findAmountTransaction(findMinAmount, findMaxAmount);
                                break;

                            case 3:
                                System.out.print("Введите получателя: ");
                                String findRecipient = getString(scan);
                                System.out.print("Список найденных транзакций по получателю " + findRecipient);
                                myBank.findRecipientTransaction(findRecipient);
                                break;

                            case 4:
                                System.out.print("Введите сообщение: ");
                                String findMessage = getString(scan);
                                System.out.print("Список найденных транзакций по сообщению " + findMessage);
                                myBank.findMessageTransaction(findMessage);
                                break;

                            default:
                                System.out.println("Введена неправильная цифра!");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Выход из меню");
                    return;
                default:
                    System.out.println("Введена неправильная цифра!");
            }
        }
    }

    public static void printMenu(){

        System.out.println("\nВведите цифру 1, чтобы создать счет");
        System.out.println("Введите цифру 2, чтобы внести деньги");
        System.out.println("Введите цифру 3, чтобы снять деньги");
        System.out.println("Введите цифру 4, чтобы посмотреть баланс");
        System.out.println("Введите цифру 5, чтобы вывести список транзакций");
        System.out.println("Введите цифру 6, чтобы перевести деньги");
        System.out.println("Введите цифру 7, чтобы искать транзакцию по атрибутам");
        System.out.println("Введите цифру 0, чтобы выйти из меню");

    }

    private static int getInt(Scanner scan){
        while(true) {
            try {
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите целое цисло");
                scan.nextLine();
            }
        }
    }

    private static float getFloat(Scanner scan){
        while(true) {
            try {
                float value = scan.nextFloat();
                if(value < 0){
                    System.out.println("Сумма не может быть отрицательной");
                    continue;
                }
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите число");
                scan.nextLine();
            }
        }
    }

    private static String getString(Scanner scan){
        while(true){
            try{
                String str = scan.nextLine();
                if (str.isEmpty()){
                    System.out.println("Строка не может быть пустой");
                    continue;
                }
                return str;
            } catch(Exception e){
                System.out.println("Ошибка при вводе строки");
                scan.nextLine();
            }
        }
    }

    private static String validDate(Scanner scan){
        while(true){
            try{
                String date = scan.nextLine().trim();
                if(date.length() != 10){
                    System.out.println("Неверный формат даты. Введите в формате дд.мм.гггг");
                    continue;
                }
                if (date.charAt(2) != '.' || date.charAt(5) != '.'){
                    System.out.println("Неверный формат даты. Введите в формате дд.мм.гггг");
                    continue;
                }
                if(date.charAt(0) != 0 && date.charAt(3) != 0) {
                    if (31 < Integer.parseInt(date.substring(0, 2)) || Integer.parseInt(date.substring(0, 2)) < 1) {
                        System.out.println("День должен быть от 1 до 31");
                        continue;
                    }
                    if (Integer.parseInt(date.substring(3, 5)) > 12 || Integer.parseInt(date.substring(3, 5)) < 1) {
                        System.out.println("Месяц должен быть от 1 до 12");
                        continue;
                    }
                }
                else{
                    if (31 < Integer.parseInt(date.substring(1, 2)) || Integer.parseInt(date.substring(1, 2)) < 1) {
                        System.out.println("День должен быть от 1 до 31");
                        continue;
                    }
                    if (Integer.parseInt(date.substring(4, 5)) > 12 || Integer.parseInt(date.substring(4, 5)) < 1) {
                        System.out.println("Месяц должен быть от 1 до 12");
                        continue;
                    }
                }
                return date;
            } catch (Exception e) {
                System.out.println("Ошибка при вводе даты");
                scan.nextLine();
            }
        }
    }
}