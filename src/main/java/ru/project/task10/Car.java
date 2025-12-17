package ru.project.task10;

import java.time.LocalDate;

/**
 * Машина с ценой, годом производства и маркой.
 * Существует метод изменения цены, но не года или марки.
 *
 */
public final class Car {

    private final Long price;
    private final Integer yearManufacture;
    private final String carBrand;

    /**
     * Цена не может быть отрицательной или меньше 0, год должен быть в рамках диапазона, а марка не может быть пустой.
     */
    public Car(Long price, Integer yearManufacture, String carBrand) {
        if (price == null || price <= 0) {
            throw new IllegalArgumentException("Цена должна быть неотрицательной и больше ноля.");
        }
        if (yearManufacture == null || yearManufacture < 1886 || yearManufacture > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Год должен быть между текущим и 1886г.");
        }
        if (carBrand == null || carBrand.isBlank()) {
            throw new IllegalArgumentException("Марка не может быть пустой.");
        }
        this.price = price;
        this.yearManufacture = yearManufacture;
        this.carBrand = carBrand;
    }

    public Long getPrice() {
        return price;
    }

    public Integer getYearManufacture() {
        return yearManufacture;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public Car changePrice(Long price) {
        if (price == null || price <= 0) {
            throw new IllegalArgumentException("Цена должна быть неотрицательной и больше ноля.");
        }
        return new Car(price, yearManufacture, carBrand);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;
        return price.equals(car.price) && yearManufacture.equals(car.yearManufacture) && carBrand.equals(car.carBrand);
    }

    @Override
    public int hashCode() {
        int result = price.hashCode();
        result = 31 * result + yearManufacture.hashCode();
        result = 31 * result + carBrand.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", yearManufacture=" + yearManufacture +
                ", carBrand='" + carBrand + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Car car = new Car(10_000_000L, 2025, "BMW");
        System.out.println("Initial car: " + car);

        car = car.changePrice(9_990_000L);
        System.out.println("After change price: " + car);
    }
}
