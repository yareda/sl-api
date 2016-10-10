package com.shoppinglist.repository;

import com.shoppinglist.domain.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {

    Invitation findByInvitationCode(String invitationCode);

}
