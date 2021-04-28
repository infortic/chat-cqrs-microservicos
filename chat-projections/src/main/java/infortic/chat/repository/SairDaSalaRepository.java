package infortic.chat.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import infortic.chat.entity.MensagensChat;
import infortic.chat.entity.SaiuDaSala;

@Repository
public interface SairDaSalaRepository extends PagingAndSortingRepository<SaiuDaSala, Long> {
List<SaiuDaSala> findAllBySalaIdOrderByTimestamp(String salaId);
	
}
