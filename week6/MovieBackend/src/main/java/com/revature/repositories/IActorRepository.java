package com.revature.repositories;

import java.util.List;

import com.revature.models.IActor;

public interface IActorRepository {

	List<IActor> findAll();

	IActor findOne(int id);

	IActor save(IActor actor);

}