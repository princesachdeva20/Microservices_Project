package com.example.springmicro.reactive;

import java.util.Objects;

import org.springframework.data.annotation.Id;

public class Item {

  String id,name,description;
  Double price;

  public Item(){
  }
  Item(String name, String description, Double price){
      super();
      this.name = name;
      this.description = description;
      this.price = price;
  }
  Item(String id, String name, String description, Double price){
        super();
        this.name = name;
        this.description = description;
        this.price = price;
        this.id = id;
  }

  public String getId(){
      return id;
  }
  public void setId(){
      this.id = id;
  }

    public String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(){
        this.description = description;
    }

    public Double getPrice(){
        return price;
    }
    public void setPrice(){
        this.price = price;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 &&
            Objects.equals(id, item.id) &&
            Objects.equals(name, item.name) &&
            Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }

    @Override
    public String toString() {
        return "Item{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", price=" + price +
            '}';
    }

}
