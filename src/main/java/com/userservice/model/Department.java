/**
 * 
 */
package com.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mrvel
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	
	private long departmentId;
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	
}
