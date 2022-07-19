package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item);
        } else {
        	//merge는 아래와 같은 메커니즘으로 돈다고 볼 수 있다.
        	//Item item = itemRepository.findOne(itemId);
            //item.setName(name);
            //item.setPrice(price);
            //item.setStockQuantity(stockQuantity);
        	//return item;
        	//** merget의 문제
        	//병합시 값이 없으면 null로 업데이트할 위험이 있다.(모든 필드를 교체함)
        	//어지간하면 변경감지를 이용하자.
            em.merge(item);
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}
