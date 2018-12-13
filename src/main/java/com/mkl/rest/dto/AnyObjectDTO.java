package com.mkl.rest.dto;

import com.mkl.data.entities.AnyObject;

public class AnyObjectDTO implements BaseDTOMapper<AnyObject, AnyObjectDTO>
{
	private String name;
	private int id;
	private AnyObjectDTO(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public AnyObjectDTO() {}

	@Override public AnyObjectDTO apply(AnyObject anyObject)
	{
		return basic(anyObject);
	}

	public static AnyObjectDTO basic(AnyObject anyObject) {
		return new AnyObjectDTO(anyObject.getNameString(), anyObject.getId());
	}
}
