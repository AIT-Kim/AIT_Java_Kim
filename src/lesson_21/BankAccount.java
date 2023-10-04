package lesson_21;

/**
 * 04.10.2023
 *
 * @email evgeniikim@gmail.com
 * @author Yevhen Kim
 */
public class BankAccount {
    private final int clientId;
    private final long accNum;
    private double balance;
    private String currType;
    private String accOwner;
    private int branchId;
    private String bankName;
    static final int BASE_ACCOUNT_NUMBER = 2600;
    private static int accCounter;

    public BankAccount(long accNum, String currType, String accOwner, String bankName) {
        this.accNum = accNum;
        this.currType = currType;
        this.accOwner = accOwner;
        this.bankName = bankName;
        this.branchId = 1;
        this.clientId = accCounter++;
        generateAccNumber();
    }

    private String generateAccNumber() {
        StringBuilder accBuilder = new StringBuilder();
        accBuilder.append(BASE_ACCOUNT_NUMBER);
        int[] digits = new int[5];
        int tmp = clientId;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = tmp % 10;
            tmp /= 10;
        }
        for (int val: digits) {
            accBuilder.append(val);
        }

        System.out.println(accBuilder.toString());
        return accBuilder.toString();
    }

    public String toString() {
        return "{Account ID: " + clientId + "; Balance: " + balance + " " + currType +
                "; Owner: " + accOwner + "; Bank: " + bankName + "}";
    }

    public String displayInfo() {
        StringBuilder details = new StringBuilder();

        details.append("{Account ID: ").append(clientId).append("; Balance: ").append(balance)
                .append(" ").append(currType).append("; Owner: ").append(accOwner)
                .append("; Bank: ").append(bankName).append("}");

        return details.toString();
    }
}
