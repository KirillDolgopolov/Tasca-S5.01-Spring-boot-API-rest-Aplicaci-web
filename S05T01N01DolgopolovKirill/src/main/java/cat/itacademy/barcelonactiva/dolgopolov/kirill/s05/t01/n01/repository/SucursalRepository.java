package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.repository;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t01.n01.models.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
}
