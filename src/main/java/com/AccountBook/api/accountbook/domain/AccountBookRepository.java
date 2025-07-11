package com.AccountBook.api.accountbook.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountBookRepository extends JpaRepository <AccountBook, Long> {

    List<AccountBook> findByUserId(Long userId);
}
