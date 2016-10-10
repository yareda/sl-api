package com.shoppinglist.service;

import com.shoppinglist.domain.ShoppingList;
import com.shoppinglist.repository.ShoppingListCollaboratorRepository;
import com.shoppinglist.domain.ShoppingListCollaborator;
import com.shoppinglist.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShoppingListService {

    @Autowired
    private ShoppingListRepository repository;

    @Autowired
    private ShoppingListCollaboratorRepository collaboratorRepository;

    public List<ShoppingList> getShoppingLists(){
        return repository.findAll();
    }

    /**
     * Returns a list of shopping lists owned by 'owner'
     * @param owner username identifier of the user who owns the shopping list
     * @return List of ShoppingList items owned by 'owner'
     */
    public List<ShoppingList> getShoppingLists(String owner){
        return repository.findAllByOwner(owner);
    }

    public ShoppingList getShoppingList(Long id){
        return repository.findOne(id);
    }
    @Transactional
    public void save(ShoppingList shoppingList){
        repository.save(shoppingList);
    }

    @Transactional
    public void delete(Long shoppingListId){
        repository.delete(shoppingListId);
    }

    public Boolean isUserAlreadyCollaborator(ShoppingList shoppingList, String user){
        ShoppingListCollaborator collaborator =  collaboratorRepository.findByUsernameAndShoppingListId(user,shoppingList.getId());
        if (collaborator != null) return true;
        else return false;
    }
    


}
