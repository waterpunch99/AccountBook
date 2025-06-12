package com.AccountBook.api.user.domain;

import com.AccountBook.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
@Table(name = "member")
@Entity
public class User extends BaseEntity {
    @Id
    private Long id;
    private String loginId;
    private String password;
    private String username;

    @Builder
    public User(Long id, String loginId, String password, String username){
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.username = username;
    }

}
