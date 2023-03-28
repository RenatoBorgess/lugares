package br.com.clickbus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clickbus.model.Lugar;

public interface LugarRepository extends JpaRepository<Lugar, Long>{

	Optional<Lugar> findById(Long id);
	boolean existsByNome(String nome);
}
