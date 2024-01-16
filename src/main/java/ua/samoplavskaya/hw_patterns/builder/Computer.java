package ua.samoplavskaya.hw_patterns.builder;

import lombok.Data;

@Data
public class Computer {
    private String processor;
    private int capacity;
    private double ram;
    private String gpu;
    private String motherboard;

    public Computer(String processor, int capacity, double ram, String gpu, String motherboard) {
        this.processor = processor;
        this.capacity = capacity;
        this.ram = ram;
        this.gpu = gpu;
        this.motherboard = motherboard;
    }

    static class Builder {
        private String processor;
        private int capacity;
        private double ram;
        private String gpu;
        private String motherboard;

        public Builder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public Builder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder setRam(double ram) {
            this.ram = ram;
            return this;
        }

        public Builder setGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder setMotherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }
        public Computer build(){
            return new Computer(processor, capacity, ram, gpu, motherboard);
        }
    }
}
