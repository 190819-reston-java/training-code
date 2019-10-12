package com.revature.repositories;

import java.util.List;

import com.revature.models.IDirector;

public interface IDirectorRepository {

	List<IDirector> findAll();

	IDirector findOne(int id);

	IDirector save(IDirector director);

}