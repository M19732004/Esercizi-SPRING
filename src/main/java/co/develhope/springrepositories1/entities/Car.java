package co.develhope.springrepositories1.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Car")
    public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
    @NotNull
        private String modelName;
    @NotNull
        private String serialNumber;
    @NotNull
        private long currentPrice;

        public Car() {
        }

        public Car(long id, String modelName, String serialNumber, long currentPrice) {
            this.id = id;
            this.modelName = modelName;
            this.serialNumber = serialNumber;
            this.currentPrice = currentPrice;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getModelName() {
            return modelName;
        }

        public void setModelName(String modelName) {
            this.modelName = modelName;
        }

        public String getSerialNumber() {
            return serialNumber;
        }

        public void setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
        }

        public long getCurrentPrice() {
            return currentPrice;
        }

        public void setCurrentPrice(long currentPrice) {
            this.currentPrice = currentPrice;
        }
    }