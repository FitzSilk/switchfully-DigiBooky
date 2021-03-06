package com.switchfully.javadocjuveniles.domain.item;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public abstract class Item implements Borrowable {
    private final String Id;
    private String title;
    private String summary;
    private int numberOfCopies;
    private LocalDate dateAdded;
    private double initialPrice;


    public Item(String title, String summary, int numberOfCopies, double initialPrice) {
        this.Id = UUID.randomUUID().toString();
        this.title = title;
        this.summary = summary;
        this.numberOfCopies = numberOfCopies;
        this.dateAdded = LocalDate.now();
        this.initialPrice = initialPrice;
    }

    public String getId() {
        return Id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Item setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String getSummary() {
        return summary;
    }

    @Override
    public Item setSummary(String summary) {
        this.summary = summary;
        return this;
    }


    @Override
    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public Item setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
        return this;
    }

    @Override
    public LocalDate getDateAdded() {
        return dateAdded;
    }

    @Override
    public double getInitialPrice() {
        return initialPrice;
    }

    @Override
    public Item setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(Id, item.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
