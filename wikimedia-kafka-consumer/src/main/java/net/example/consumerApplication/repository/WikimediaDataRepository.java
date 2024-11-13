package net.example.consumerApplication.repository;

import net.example.consumerApplication.entity.Wikimedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<Wikimedia, Long> {
}
