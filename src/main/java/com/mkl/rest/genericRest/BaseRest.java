package com.mkl.rest.genericRest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mkl.data.JPAConnection;
import com.mkl.data.repositories.genericRepositories.BaseRepository;
import com.mkl.rest.dto.BaseDTOMapper;

import javax.ws.rs.core.Response;
import java.lang.reflect.Field;


//GenericResource<E, PK, EDTO> --> how do i find the field type of PK and make
//Instead of Integer i should have used generic type PK
//works now
public class BaseRest<E, EDTO>
{
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private BaseRepository<E, Integer> crudOperations;
	private BaseDTOMapper<E, EDTO>     baseDTOMapper;
	private Class<E>                   entityClass;

	//https://stackoverflow.com/questions/18255117/how-do-i-get-the-class-attribute-from-a-generic-type-parameter
	public BaseRest(Class<E> entityClass, BaseDTOMapper<E, EDTO> dtoMapper)
	{
		this.entityClass = entityClass;
		crudOperations = new BaseRepository<E, Integer>(entityClass, JPAConnection.getEntityManagerFactory());
		baseDTOMapper = dtoMapper;
	}

	public Response get()
	{
		return Response
				.ok(gson.toJson(baseDTOMapper.convertToSet(crudOperations.get())))
				.build();
	}

	public Response post(String content)
	{
		E entity = gson.fromJson(content, entityClass);
		return Response
				.ok(gson.toJson(baseDTOMapper.apply(crudOperations.post(entity))))
				.build();
	}


	public Response getByPK(int id)
	{
		return Response
				.ok(gson.toJson(baseDTOMapper.apply(crudOperations.getEntity(id))))
				.build();
	}

	//right now you will need to overwrite PUT, DELETE and GET(ID) if your entity does not support an integer as PK
	//if you find a way to ask for a generic Primary Key instead of this shit, write to me at discord: fluffy snail#4373
	public Response delete(int id)
	{
		E entity = crudOperations.delete(id);
		return Response
				.ok(gson.toJson(baseDTOMapper.apply(entity)))
				.build();
	}


	public Response put(int id, String content) throws NoSuchFieldException, IllegalAccessException
	{
		E     entity = gson.fromJson(content, entityClass);
		Field f      = entity.getClass().getDeclaredField("id");
		f.setAccessible(true);
		f.setInt(entity, id);
		E result = crudOperations.put(entity);
		return Response
				.ok(gson.toJson(baseDTOMapper.apply(result)))
				.build();
	}
}

