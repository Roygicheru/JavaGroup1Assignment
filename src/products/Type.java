package products;

public enum Type {

    GOLF_ITEMS("Golf Items"),
    TRAVEL_ITEMS("Travel Items"),
    TOURISM_PRODUCTS("Tourism Products"),
    SPARE_PARTS("Spare parts"),
    CLOTHING_PRODUCTS("Clothing products"),
    ;

    final String name;

    Type(String name) {
        this.name = name;
    }
}
