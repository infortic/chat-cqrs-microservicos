package infortic.chat.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import infortic.chat.entity.EntrouNaSala;
import infortic.chat.entity.MensagensChat;

@Repository
public interface EntrouNaSalaRepository extends PagingAndSortingRepository<EntrouNaSala, Long> {
List<EntrouNaSala> findAllBySalaIdOrderByTimestamp(String salaId);
	
}
