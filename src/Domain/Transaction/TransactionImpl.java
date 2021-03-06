package Domain.Transaction;

import Domain.Order.Order;

import java.time.LocalDateTime;
import java.util.Date;

public class TransactionImpl implements Transaction {
    private Date transactionDate;
    private double transactionAmount;
    private Order order;

    public TransactionImpl(Order order){
        this.order = order;
        transactionDate = new Date();
    }
    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    private int transactionID;


    public TransactionImpl(){
        transactionDate = new Date();

    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "TransactionImpl{" +
                "transactionDate=" + transactionDate +
                ", transactionAmount=" + transactionAmount +
                ", order=" + order +
                '}';
    }
}
