package com.demo;

public class Car {
   private final String model;
   private final String type;

   public Car(String model, String type) {
      this.model = model;
      this.type = type;
   }

   public String getModel() {
      return model;
   }

   public String getType() {
      return type;
   }
}
