package com.mkl.logic.facades;

import java.util.Set;

public interface Facade<E>
{
	Set<E> get();
	E get(int id);
	E put(E object);
	E post(E object);
	E delete(int id);
}
