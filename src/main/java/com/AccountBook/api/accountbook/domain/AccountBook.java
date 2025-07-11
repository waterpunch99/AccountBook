package com.AccountBook.api.accountbook.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
@Entity
public class AccountBook {
    @Id
    private Long id;
    private Long amount;
    @Enumerated(EnumType.STRING)
    private Accounttype accounttype;
    private String memo;
    //private String category;

    @Builder
    public AccountBook(Long id, Long amount, Accounttype accounttype, String memo){
        this.id = id;
        this.amount = amount;
        this.accounttype = accounttype;
        this.memo = memo;
    }


}
