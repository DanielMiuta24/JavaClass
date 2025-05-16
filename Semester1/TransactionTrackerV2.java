import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TransactionTrackerV2 {

    List<Transaction> transactions = new ArrayList<>();
    
    public static class Transaction {
        String transactionId;
        String type;
        double amount;
        String date;

        public Transaction(String transactionId, String type, double amount, String date) {
            this.transactionId = transactionId;
            this.type = type;
            this.amount = amount;
            this.date = date;
        }
    }

    public void addTransaction(String transactionId, String type, double amount, String date) {
        Transaction newTransaction = new Transaction(transactionId, type, amount, date);
        transactions.add(newTransaction);
        System.out.println("We added transaction: " + transactionId);
    }

    public int countTransactions() {
        return transactions.size();
    }

    public double totalIncome() {
        double totalIncome = 0;
        for (Transaction transaction : transactions) {
            if ("Deposit".equals(transaction.type)) {
                totalIncome += transaction.amount;
            }
        }
        return totalIncome;
    }

    public List<String> transactionsPerformedYesterday() {
        List<String> transactionsYesterday = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String yesterdayString = yesterday.format(formatter);

        for (Transaction transaction : transactions) {
            if (yesterdayString.equals(transaction.date)) {
                transactionsYesterday.add(transaction.transactionId);
            }
        }

        return transactionsYesterday;
    }

    public static void main(String[] args) {
        TransactionTrackerV2 tracker = new TransactionTrackerV2();
        tracker.addTransaction("T001", "Deposit", 500.00, "2025-01-17");
        tracker.addTransaction("T002", "Withdrawal", 100.00, "2025-01-16");
        tracker.addTransaction("T003", "Deposit", 200.00, "2025-01-16");
        tracker.addTransaction("T004", "Deposit", 150.00, "2025-01-10");

        System.out.println("Total transactions: " + tracker.countTransactions());
        System.out.println("Total income: " + tracker.totalIncome());
        List<String> transactionsYesterday = tracker.transactionsPerformedYesterday();
        System.out.println("Transactions performed yesterday: " + transactionsYesterday);
    }
}
