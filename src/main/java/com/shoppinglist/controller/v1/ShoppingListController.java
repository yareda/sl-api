package com.shoppinglist.controller.v1;

import com.shoppinglist.domain.ShoppingList;
import com.shoppinglist.dto.InvitationDto;
import com.shoppinglist.service.InvitationService;
import com.shoppinglist.service.ShoppingListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

@Api(value = "shoppinglist", description = "Manage shopping list records")
@Controller
@RequestMapping("api/v1/shoppinglist")
public class ShoppingListController {

    @Autowired
    private ShoppingListService service;

    @Autowired
    private InvitationService invitationService;

    @ApiOperation(value = "Returns a list of all available shopping list records")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ShoppingList>> showShoppingLists(){
        return new ResponseEntity<>(service.getShoppingLists(), HttpStatus.OK);
    }

    @ApiOperation(value = "Returns a single shopping list identified by 'id' parameter.")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ShoppingList> getShoppingList(@PathVariable("id") Long id){
        return new ResponseEntity<ShoppingList>(service.getShoppingList(id),HttpStatus.OK);
    }

    @ApiOperation(value = "Create a new shopping list record")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@RequestBody ShoppingList shoppingList){
        service.save(new ShoppingList(
                shoppingList.getListName(),
                shoppingList.getOwner(),
                shoppingList.getOwner(),
                new Date()
        ));

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Updates an existing shopping list attributes")
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShoppingList> update(@PathVariable("id") Long id, @RequestBody ShoppingList shoppingList){
        ShoppingList sl = service.getShoppingList(id);

        if(sl == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        sl.setListName(shoppingList.getListName());
        sl.setOwner(shoppingList.getOwner());
        sl.setLastUpdatedBy(shoppingList.getLastUpdatedBy());
        sl.setLastUpdatedAt(shoppingList.getLastUpdatedAt());

        service.save(sl);

        return new ResponseEntity<>(sl, HttpStatus.OK);
    }


    @ApiOperation(value = "Creates a new invite code for shopping list to be sent for users to collaborate")
    @RequestMapping(value = "/{id}/invite/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sendInvite(@PathVariable("id") Long id, @RequestBody InvitationDto dto){

        ShoppingList shoppingList = service.getShoppingList(id);

        if(shoppingList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        String invitationCode = invitationService.createInvite(shoppingList,dto.getUserName());

        return new ResponseEntity<>(invitationCode, HttpStatus.OK);
    }

}
