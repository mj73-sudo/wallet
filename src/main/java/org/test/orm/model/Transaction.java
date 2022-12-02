package org.test.orm.model;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_date")
    private Long createdDate;

    private Double amount;

    //1 -> MOBILE
    //2 -> INTERNET
    //3 -> ATM
    //4 -> POS
    private Integer type;

    @ManyToOne(cascade = CascadeType.ALL)
    private Wallet wallet;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", amount=" + amount +
                ", type=" + type +
                '}';
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
