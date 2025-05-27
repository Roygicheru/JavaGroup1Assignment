package products;

import java.util.Date;

public class BaseModel {


    protected Long id;
    protected Date dateCreated;

    public BaseModel() {
        this.dateCreated = new Date();
//        this.id = id;
        this.id = System.currentTimeMillis();
    }

    public Long getId() {
        return id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
}
