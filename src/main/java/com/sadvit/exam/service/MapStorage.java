package com.sadvit.exam.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.internal.util.collections.IdentityMap;

/**
 * @see IdentityMap
 * Специальное хранилище, которое при:
 * 1. Получении контента из БД заполняет внутренний Map.
 * 2. Изменении контента в БД изменяет и сохраненное по ключу значение внутренней Map.
 * @author Vitalik
 *
 */
public class MapStorage<T extends Storeable> {
	
	private Map<Integer, T> storage = new LinkedHashMap<>();
	
	public void setValues(List<T> values) {
		values.forEach(value -> storage.put(value.getId(), value));
	}
	
	public void setValue(T value) {
		storage.put(value.getId(), value);
	}
	
	public T getValue(int id) {
		return storage.get(id);
	}
	
	public List<T> getValues() {
		return storage.values().stream().collect(Collectors.toList());
	}
	
	public boolean isEmpty() {
		return storage.size() == 0;
	}
	
	public void delete(Storeable storeable) {
		storage.remove(storeable.getId());
	}

}
