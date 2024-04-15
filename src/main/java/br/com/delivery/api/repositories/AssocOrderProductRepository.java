package br.com.delivery.api.repositories;

import br.com.delivery.api.models.AssocProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssocOrderProductRepository extends JpaRepository<AssocProductOrder, Integer> {
}
