package com.shoppinglist.service;

import com.shoppinglist.domain.ShoppingList;
import com.shoppinglist.domain.ShoppingListCollaborator;
import com.shoppinglist.repository.InvitationRepository;
import com.shoppinglist.domain.Invitation;
import com.shoppinglist.repository.ShoppingListCollaboratorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class InvitationService {

    @Autowired
    private InvitationRepository repository;

    @Autowired
    private ShoppingListCollaboratorRepository collaboratorRepository;

    @Autowired
    private ShoppingListService shoppingListService;

    private static final Logger log = LoggerFactory.getLogger(InvitationService.class);

    /**
     * Creates a new invitation to a shopping cart and returns invitation code for composing
     * @param shoppingList  shopping list where by we're inviting users to collaborate
     * @param invitedUser   username for the person we're sending invite to
     * @return  invitation code string (in UUID format)
     */
    @Transactional
    public String createInvite(ShoppingList shoppingList, String invitedUser){
        /*
         * This could be improved by computing a self validating unique string of sorts which includes expiration date
         * as part of the invitation code. For this example I'm opting to use UUID to ensure uniqueness of code
         */
        String inviteCode = UUID.randomUUID().toString();
        Invitation newInvite = new Invitation(shoppingList,inviteCode, invitedUser);
        repository.save(newInvite);
        return inviteCode;
    }

    /**
     * Flag invitation as accepted
     * @param invitationCode unique code representing invitation under consideration
     */
    @Transactional
    public Boolean acceptInvite(String invitationCode){
        Boolean result = false;

        Invitation invitation = repository.findByInvitationCode(invitationCode);

        log.info("Accepting invitation with code: " + invitation.getInvitationCode());

        // Check if invitation is already accepted or not
        if (!invitation.getAccepted()){

            // Check if user is already a collaborator on shopping list under consideration
            if (! shoppingListService.isUserAlreadyCollaborator(
                    invitation.getShoppingList(),
                    invitation.getInvitedUser())){
                // Check invitation as accepted
                invitation.setAccepted(true);
                repository.save(invitation);

                // Add user to list of collaborators
                ShoppingListCollaborator collaborator = new ShoppingListCollaborator(invitation.getInvitedUser(),invitation.getShoppingList());
                collaboratorRepository.save(collaborator);
                result = true;
            }else{
                log.info("User is already a collaborator on the shopping list");
            }
        }
        else{
            log.info("Invitation is already accepted.");
        }

        return result;
    }

    public List<Invitation> getInvitations(){
        return repository.findAll();
    }

    public Invitation getInvitation(Long invitationId){
        return repository.findOne(invitationId);
    }

    public Invitation getInvitation(String code){
        return repository.findByInvitationCode(code);
    }


}
