package com.auth_service.service.registration;

import com.auth_service.json.requests.CreateUser;

/**
 * @author Tshepo Mokoena
 * @version 1.0
 */
public interface IRegistrationService {
	
	/**
	 * @param user
	 * @return createUser
	 */
	CreateUser register(CreateUser user);

}
