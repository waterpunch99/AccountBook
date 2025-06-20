package com.AccountBook.api.accountbook.domain;


import jakarta.persistence.Entity;
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
    private enum type;
    private String memo;

    @Builder
    public AccountBook(Long id, Long amount, type, String memo){
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.memo = memo;
    }


}
