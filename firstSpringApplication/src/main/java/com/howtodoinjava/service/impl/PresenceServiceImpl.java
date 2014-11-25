package com.howtodoinjava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtodoinjava.dao.PresenceDao;
import com.howtodoinjava.dto.UserPresenceEntryRequestDTO;
import com.howtodoinjava.dto.UserPresenceEntryResponseDTO;
import com.howtodoinjava.dto.UserPresenceExitRequestDTO;
import com.howtodoinjava.dto.VerifyUserPresenceEntryRequestDTO;
import com.howtodoinjava.dto.VerifyUserPresenceEntryResponseDTO;
import com.howtodoinjava.service.PresenceService;

@Service
public class PresenceServiceImpl implements PresenceService {
	
	@Autowired
	PresenceDao presenceDao ;

	public UserPresenceEntryResponseDTO addPresenceUser(UserPresenceEntryRequestDTO dto) {
		return presenceDao.addPresenceUser(dto);
		}

	public VerifyUserPresenceEntryResponseDTO verifPresenceUser(VerifyUserPresenceEntryRequestDTO dto) {
		return presenceDao.verifPresenceUser(dto);
		}

	public void exitPresenceUser(UserPresenceExitRequestDTO dto) {
			    presenceDao.exitPresenceUser(dto);
	}

}
