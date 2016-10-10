package com.shoppinglist.repository;

import com.shoppinglist.domain.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList,Long> {
    List<ShoppingList> findAllByOwner(String owner);

    List<ShoppingList> findAllByCollaborators(String username);

}
