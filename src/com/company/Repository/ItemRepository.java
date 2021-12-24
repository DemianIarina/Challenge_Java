package com.company.Repository;

import com.company.Entities.Item;

import java.util.Objects;

/**
 * Represents a repository for all items requested by the children.
 * It is used for only creating new items, with new identifiers, when the requested item was not requested before -
 * it does not exist in the repository
 */
public class ItemRepository extends InMemoryRepository<Item>{
    public ItemRepository() {
        super();
    }

    //the update method is not necessary for this implementation
    @Override
    public Item update(Item obj) {
        return null;
    }
}
