package com.vendas.SleepSell.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.vendas.SleepSell.entities.Role;
import com.vendas.SleepSell.entities.User;
import com.vendas.SleepSell.repositories.RoleRepository;
import com.vendas.SleepSell.repositories.UserRepository;
import com.vendas.SleepSell.services.exceptions.DatabaseException;
import com.vendas.SleepSell.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Integer id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
        // Por padrão, todo novo usuário recebe a role BASIC
        Role basicRole = roleRepository.findByAuthority("ROLE_BASIC");
        if (basicRole != null) {
            obj.getRoles().add(basicRole);
        }
        return repository.save(obj);
    }

	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Integer id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getUsername());
		entity.setEmail(obj.getEmail());
		entity.setPassword(obj.getPassword());
	}
}
