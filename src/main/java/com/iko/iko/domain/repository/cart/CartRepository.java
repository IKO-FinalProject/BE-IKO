package com.iko.iko.domain.repository.cart;

import com.iko.iko.domain.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer>, CartRepositoryCustom {

}
