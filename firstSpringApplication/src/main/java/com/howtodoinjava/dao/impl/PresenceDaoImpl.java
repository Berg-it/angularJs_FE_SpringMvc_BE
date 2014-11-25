package com.howtodoinjava.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.howtodoinjava.dao.PresenceDao;
import com.howtodoinjava.dto.UserPresenceEntryRequestDTO;
import com.howtodoinjava.dto.UserPresenceEntryResponseDTO;
import com.howtodoinjava.dto.UserPresenceExitRequestDTO;
import com.howtodoinjava.dto.VerifyUserPresenceEntryRequestDTO;
import com.howtodoinjava.dto.VerifyUserPresenceEntryResponseDTO;
import com.howtodoinjava.model.Presence;
import com.howtodoinjava.model.User;

@Repository
public class PresenceDaoImpl implements PresenceDao {

	@PersistenceUnit(unitName="testspring-jpa-seconde")
    EntityManagerFactory emf;
	
	
	public UserPresenceEntryResponseDTO addPresenceUser(UserPresenceEntryRequestDTO dto) {
		
		UserPresenceEntryResponseDTO responseDto = new UserPresenceEntryResponseDTO();
		Presence 					 presence 	 =  new Presence();
		EntityManager 				 em 		 = emf.createEntityManager();
		
		java.util.Date dt = new java.util.Date();
	    SimpleDateFormat sdf =  new java.text.SimpleDateFormat("yyyy-MM-dd");
		String currentDate1 = sdf.format(dt);
		Date currentDate =  null;
		String currentTime = null;
		try {
			currentDate = new SimpleDateFormat("yyyy-MM-dd").parse(currentDate1);
			SimpleDateFormat sdfTime =  new SimpleDateFormat("HH:mm:ss");
			currentTime = sdfTime.format (  new Date()  );
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		presence.setEntrydate(dto.getEntrydate());
		presence.setMail(dto.getMail());
		presence.setUserLocale(dto.getUser());
		presence.setEntrydate(currentDate);
		presence.setEntrytime(currentTime);
		
		em.getTransaction().begin();
		em.persist(presence);
		em.getTransaction().commit();
		
		responseDto.setDateEntry(currentDate1);
		responseDto.setTimeEntry(currentTime);
		
		return responseDto;
	}


	public VerifyUserPresenceEntryResponseDTO verifPresenceUser(VerifyUserPresenceEntryRequestDTO dto) {
		EntityManager em = emf.createEntityManager();
		Query Presence$verifIfConnected =    em.createNamedQuery("Presence.verifIfConnected.andGetList");
		User user = new User();
		user.setEmail(dto.getMail());
		java.util.Date dateStringTmp = new java.util.Date();
	    SimpleDateFormat sdf =  new java.text.SimpleDateFormat("yyyy-MM-dd");
		String currentDate1 = sdf.format(dateStringTmp);

		Presence$verifIfConnected.setParameter("user", user);
		List<Presence> response=null;
		VerifyUserPresenceEntryResponseDTO responseDto = new VerifyUserPresenceEntryResponseDTO();
		try {
			response = (List<Presence>) Presence$verifIfConnected.getResultList();
			} catch (NoResultException e) {
		    System.out.println("No result forund for... ");
			}
		
		if (response == null) {
			responseDto.setMessageResponse("notok");
		    return responseDto; // handle no-results case
			} else {
				responseDto.setMessageResponse("notok");
				for(Presence object : response )
				{
					dateStringTmp = object.getEntrydate();
					if(sdf.format(dateStringTmp).equals(currentDate1) ){
						responseDto.setMessageResponse("ok");
					}
					
				}
				responseDto.setResult(response);
			
		}
				
		return responseDto;
	}

	@Transactional
	public void exitPresenceUser(UserPresenceExitRequestDTO dto) {
		
		EntityManager 				 em 		 =  emf.createEntityManager();
		User 						 user		 =  new User();
		Query Presence$exit$user				 =  em.createNamedQuery("Presence.exit.user");
		user.setEmail(dto.getUserMail());
		
		Date 	  		  dt =  new Date();
	    SimpleDateFormat sdf =  new java.text.SimpleDateFormat("yyyy-MM-dd");
		String currentDate1  =  sdf.format(dt);
		SimpleDateFormat sdfTime = null;
		Date currentDate 	 =  null;
		Date olderDate 		 =  null;
		String currentTime   =  null;
		long dateConvert = Long.parseLong(dto.getEntrydate()) ;
		Date dateOlderOlder=new Date(dateConvert);
		try {
			currentDate 			 = new SimpleDateFormat("yyyy-MM-dd").parse(currentDate1);
			olderDate				 = new SimpleDateFormat("yyyy-MM-dd").parse(sdf.format(dateOlderOlder)); 
			sdfTime 				 = new SimpleDateFormat("HH:mm:ss");
			currentTime 			 = sdfTime.format (new Date());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		System.out.println("dto.getEntryTime(): "+dto.getEntryTime());
		Date olderTime = null;
		Date newerDate = null;
	    try {
	    	olderTime = sdfTime.parse(dto.getEntryTime());
	    	newerDate = sdfTime.parse(currentTime);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    
	    long diff = newerDate.getTime() - olderTime.getTime();
	    long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		String totalTmp = diffHours +"H :"+diffMinutes+" m";
		Presence$exit$user.setParameter("exitdate", currentDate);
		Presence$exit$user.setParameter("exittime", currentTime);
		Presence$exit$user.setParameter("total", totalTmp);
		Presence$exit$user.setParameter("user", user);
		Presence$exit$user.setParameter("entrydate", olderDate);
		EntityTransaction entr=em.getTransaction();
		entr.begin();
		int updateCount = Presence$exit$user.executeUpdate();	
		entr.commit();
		System.out.println("AAAAAAAAAA "+updateCount);
		
	}

}
