# Online Store Catalog System - Complete Implementation

## Project Overview
A comprehensive Java-based e-commerce catalog system demonstrating core Object-Oriented Programming (OOP) principles including inheritance, method overloading, method overriding, and interface implementation with array-based storage.

##  Features Completed

###  Core OOP Requirements
- **Inheritance**: BaseModel → Product → [SportProducts, TravelProducts, ClothingProducts]
- **Method Overloading**: Multiple discount application methods with different signatures
- **Method Overriding**: Product-specific implementations of toString(), displayDetails(), and getPrice()
- **Interface Implementation**: ProductI and UserI interfaces with concrete implementations
- **Array Storage**: Products and users stored in dynamically resizing arrays

###  Product Management
- Create three types of products (Sport, Travel, Clothing)
- Each product type has specialized behavior and pricing
- View detailed product information
- Remove products from catalog
- Automatic array resizing when capacity is exceeded

###  User Management
- User registration and login system
- User-specific purchase tracking
- Array-based user storage with search capabilities

###  Shopping System
- Interactive product browsing
- Purchase workflow with quantity validation
- Stock management (quantities decrease after purchase)

###  Discount System (Method Overloading Demo)
- **Type-based discount**: Uses ProductType's percentage discount
- **Fixed amount discount**: Apply specific dollar amount off
- **Percentage discount**: Apply custom percentage rate
- **Loyalty discount**: User-specific discounts
- **Bulk discount**: Apply discount to multiple products at once

###  Interactive Menu System
- User-friendly console interface
- Complete workflow management
- Error handling and validation
- Statistics and reporting

## Project Structure

```
src/
├── Main.java                    # Complete interactive application
└── products/
    ├── BaseModel.java          # Base class with ID and date
    ├── Product.java            # Core product class
    ├── SportProducts.java      # Sport-specific products
    ├── TravelProducts.java     # Travel-specific products  
    ├── ClothingProducts.java   # Clothing-specific products
    ├── ProductType.java        # Product categorization
    ├── Type.java              # Product type enum
    ├── User.java              # User model
    ├── Discount.java          # Discount tracking
    ├── ProductI.java          # Product interface
    ├── ProductImpl.java       # Product implementation with arrays
    ├── UserI.java             # User interface
    └── UserImpl.java          # User implementation with arrays
```

## How to Run

### Prerequisites
- Java 8 or higher
- Java IDE (IntelliJ IDEA, Eclipse, or VS Code)

### Steps
1. **Clone/Download** all the Java files into your project directory
2. **Ensure** all files in the `products` package are in a `products/` folder
3. **Compile** the project:
   ```bash
   javac -d . *.java products/*.java
   ```
4. **Run** the main application:
   ```bash
   java Main
   ```

## Using the Application

### Main Menu Options

1. **User Management**
   - Create new users
   - Login with existing username
   - View all registered users
   - Display current user information

2. **Product Management**
   - Add Sport Products (with sport rate multipliers)
   - Add Travel Products (with destination, days, luggage weight)
   - Add Clothing Products (with size, material, season)
   - View detailed product information
   - Remove products from catalog

3. **Shopping**
   - Browse available products
   - Purchase products (requires login)
   - Automatic quantity management

4. **Apply Discounts**
   - Type-based discounts (from ProductType)
   - Fixed amount discounts
   - Percentage discounts
   - Loyalty discounts (user-specific)
   - Bulk discounts (all products)

5. **View Catalog**
   - Display all products with prices
   - Quick overview of available inventory

6. **Statistics**
   - Total users and products
   - Inventory value calculations
   - Average pricing information

## Key OOP Concepts Demonstrated

### 1. Inheritance Hierarchy
```
BaseModel (id, dateCreated)
    ↓
Product (name, price, quantity, productType)
    ↓
├── SportProducts (sportRate, sportType, difficulty)
├── TravelProducts (destination, travelDays, luggageWeight)  
└── ClothingProducts (size, material, season)
```

### 2. Method Overloading Examples
```java
// Different parameter types
applyDiscount(Product product)
applyFixedDiscount(Product product, double amount)
applyPercentageDiscount(Product product, double rate)
applyLoyaltyDiscount(Product product, User user, double rate)
applyBulkDiscount(Product[] products, double rate)
```

### 3. Method Overriding Examples
```java
// Each product type overrides these methods:
public double getPrice()        // Custom pricing logic
public String toString()        // Custom display format
public String displayDetails()  // Detailed information
```

### 4. Interface Implementation
- `ProductI` interface defines contract for product operations
- `UserI` interface defines contract for user operations
- Concrete implementations provide array-based storage

##  Sample Usage Flow

1. **Start Application** → Main menu appears
2. **Create User** → User Management → Create New User
3. **Add Products** → Product Management → Add different product types
4. **Login** → User Management → Login
5. **Shop** → Shopping → Select products to purchase
6. **Apply Discounts** → Apply Discounts → Choose discount type
7. **View Results** → View Catalog → See updated prices and quantities

## 🛠 Technical Highlights

### Array-Based Storage
- Dynamic array resizing when capacity exceeded
- Efficient add/remove operations
- Memory-conscious design

### Error Handling
- Comprehensive input validation
- Graceful error recovery
- User-friendly error messages

### Encapsulation
- Private fields with public getters/setters
- Proper access control
- Data integrity validation

### Polymorphism
- Products behave differently based on their type
- Uniform interface for different product categories
- Runtime method resolution

##  Sample Data
The application initializes with sample products:
- Premium Golf Club Set (Sport Product)
- Travel Backpack (Travel Product)  
- Winter Jacket (Clothing Product)


## Development Team
Group 1: Timothy, Dennis, Gideon, Angeline, Roy, Gloria

---

**Note**: This implementation successfully demonstrates all required OOP concepts while providing a fully functional e-commerce catalog system with interactive user interface and comprehensive feature set.
