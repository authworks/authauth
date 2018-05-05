package io.securera.authauth.repository;

import io.securera.authauth.model.AuthorizationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizationCodeRepository extends JpaRepository<AuthorizationCode, String> {
}
