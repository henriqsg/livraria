package library.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CheckOut {

    private Long orderNumber;

    private String cardNumber;
    private Integer value;
    private LocalDate date;

    private String status;

    public CheckOut(Long orderNumber, String cardNumber, Integer value, LocalDate date, String status) {
        this.orderNumber = orderNumber;
        this.cardNumber = cardNumber;
        this.value = value;
        this.date = date;
        this.status = status;
    }
    public CheckOut() {
        this.orderNumber = 98765L;
        this.cardNumber = "1234-6432-0986-2567";
        this.value = 100;
        this.date = LocalDate.now();
        this.status = "Waiting credit card response.";
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public static List<CheckOut> buildCheckOuts() {
        List<CheckOut> list = new ArrayList<>();

        list.add(new CheckOut());
        list.add(new CheckOut(12345L, "12345-1235-12345-1235", 100, LocalDate.now(), "Your request was canceled."));
        list.add(new CheckOut(67890L, "9887-6423-1234-7543", 20, LocalDate.now(), "Waiting credit card approve"));
        return list;
    }
}
