package courses.model;

import java.util.Date;

/**
 * Created by Vitalii on 21.01.2017.
 */
public class Notebook extends Product {
    public Notebook(int id, String name, int count, Date dateOfAdd, long price) {
        super(id, name, count, dateOfAdd, price);
    }
}
