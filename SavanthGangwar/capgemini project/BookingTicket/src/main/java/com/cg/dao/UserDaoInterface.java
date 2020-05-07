package com.cg.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Flight;
import com.cg.entity.User;

@Repository
public interface UserDaoInterface extends JpaRepository<User,Long>
{

}
