package courses.model;

import java.util.Date;

/**
 * Created by Vitalii on 21.01.2017.
 */
public abstract class Product {

    private int id;
    private String name;
    private int count;
    private Date dateOfAdd;
    private long price;

    public Product(int id, String name, int count, Date dateOfAdd, long price) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.dateOfAdd = dateOfAdd;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", dateOfAdd=" + dateOfAdd +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getDateOfAdd() {
        return dateOfAdd;
    }

    public void setDateOfAdd(Date dateOfAdd) {
        this.dateOfAdd = dateOfAdd;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
