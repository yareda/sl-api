package com.shoppinglist.controller.v1;

import com.shoppinglist.domain.Invitation;
import com.shoppinglist.service.InvitationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Api(value = "invitation", description = "Manage collaboration invites to shopping lists")
@Controller
@RequestMapping(value = "api/v1/invitation")
public class InvitationController {

    @Autowired
    InvitationService service;

    @ApiOperation(value = "Returns all available collaboration invitations")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Invitation>> getInvitations(){
        return new ResponseEntity<>(service.getInvitations(),HttpStatus.OK);
    }

    @ApiOperation(value = "Returns detail information about collaboration invite for shopping list")
    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public ResponseEntity<Invitation> getInvitation(@PathVariable("code")String code){
        return new ResponseEntity<>(service.getInvitation(code), HttpStatus.OK);
    }

    @ApiOperation(
            value = "Endpoint to accept a collaboration invite for a shopping list." +
                    "This assumes that an invite has already been sent to the user and he/she" +
                    "is accepting the invite.")
    @RequestMapping(value = "/accept/{code}",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> acceptInvitation(@PathVariable("code") String code){

        if(service.acceptInvite(code)){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
