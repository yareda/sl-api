package com.shoppinglist.repository;

import com.shoppinglist.domain.ShoppingListCollaborator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListCollaboratorRepository extends JpaRepository<ShoppingListCollaborator, Long> {
    ShoppingListCollaborator findByUsernameAndShoppingListId(String userName, Long shoppingListId);
}
