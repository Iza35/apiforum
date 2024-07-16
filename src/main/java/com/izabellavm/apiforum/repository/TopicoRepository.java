package com.izabellavm.apiforum.repository;

import com.izabellavm.apiforum.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository  extends JpaRepository<Topico, Long> {
}
