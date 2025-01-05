package com.moviesdashboard.mapper;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public interface BaseMapper<R, D, E> {
   D toDTOFromRequest(R request);

   D toDTO(E entity);

   E toEntity(D dto);

   List<E> toListEntity(List<D> dto);

   Set<E> toSetEntity(Set<D> dto);

   List<D> toListDTO(List<E> entities);

   Set<D> toSetDTO(Set<E> entities);

   LinkedHashSet<D> toSortedSetDTO(Set<E> entities);
}
