package com.tinnova.desafio.repository;

import com.tinnova.desafio.repository.projection.TotalBrandProjection;
import com.tinnova.desafio.repository.projection.TotalCarsDecadeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tinnova.desafio.model.Veiculo;

import java.util.List;
import java.util.Objects;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    @Query("select v from Veiculo v where (:marca is null or :marca = '' or v.marca like %:marca%) and (:ano is null or :ano = '' or CAST(v.ano AS string) like %:ano%) and (:cor is null or :cor = '' or v.cor like %:cor%)")
    List<Veiculo> findByMarcaAnoCor(@Param("marca") String marca,
                                    @Param("ano") Integer ano,
                                    @Param("cor") String cor
    );

    @Query("select count(v) from Veiculo v where v.vendido = false")
    Long totalUnsoldCars();

    @Query(value = "SELECT (ano/10)*10 as decade, count(*) as quantity FROM veiculos group By decade order by decade", nativeQuery = true)
    List<TotalCarsDecadeProjection> findCarsByDecade();

    @Query(value = "SELECT marca as brand, count(*) AS quantity FROM veiculos group by marca order by marca", nativeQuery = true)
    List<TotalBrandProjection> totalCarsByBrand();

    @Query(value = "SELECT count(*) FROM veiculos WHERE created BETWEEN NOW() - INTERVAL '7 days' AND NOW()", nativeQuery = true)
    Long totalLast7days();

}
