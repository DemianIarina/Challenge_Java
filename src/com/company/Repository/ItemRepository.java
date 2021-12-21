package com.company.Repository;

import com.company.Entities.Item;

import java.util.Objects;

public class ItemRepository extends InMemoryRepository<Item>{
    public ItemRepository() {
        super();
    }

    /**
     * It adds a object to the repository, only if it does not exist there already
     * @param obj a new Object of type Item
     * @return the added or already existing item
     */
    @Override
    public Item create(Item obj) {
        if(this.repoList.stream()
                .noneMatch(item -> Objects.equals(item.getName(), obj.getName())))
            super.create(obj);
        return this.repoList.stream()
                .filter(item -> Objects.equals(item.getName(), obj.getName()))
                .findFirst()
                .orElseThrow();
    }

    //TODO look daca ii nevoie
    @Override
    public Item update(Item obj) {
        return null;
    }
}
