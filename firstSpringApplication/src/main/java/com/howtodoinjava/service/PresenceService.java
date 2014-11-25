package com.howtodoinjava.service;

import com.howtodoinjava.dto.UserPresenceEntryRequestDTO;
import com.howtodoinjava.dto.UserPresenceEntryResponseDTO;
import com.howtodoinjava.dto.UserPresenceExitRequestDTO;
import com.howtodoinjava.dto.VerifyUserPresenceEntryRequestDTO;
import com.howtodoinjava.dto.VerifyUserPresenceEntryResponseDTO;

public interface PresenceService {
	
	public UserPresenceEntryResponseDTO addPresenceUser( UserPresenceEntryRequestDTO dto);
	public VerifyUserPresenceEntryResponseDTO verifPresenceUser( VerifyUserPresenceEntryRequestDTO dto);
	public void exitPresenceUser( UserPresenceExitRequestDTO dto);
}
