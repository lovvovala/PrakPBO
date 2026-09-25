import java.time.LocalDateTime;
import java.util.ArrayList;

// class Customer
class Customer {
    private int customerId;
    private String customerName;
    private String address;
    private String phone;

    // Constructor
    public Customer(int customerId, String customerName, String address, String phone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.phone = phone;
    }

    // Getter and Setter methods
    public int getCustomerId() {return customerId;}
    public void setCustomerId(int customerId) {this.customerId = customerId;}
    public String getCustomerName() {return customerName;}
    public void setCustomerName(String customerName) {this.customerName = customerName;}
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}

    // Atribrut Sesuai Class
    public void addCustomer() {System.out.println("Customer added." );}
    public void editCustomer() {System.out.println("Customer edited." );}
    public void deleteCustomer() {System.out.println("Customer deleted." );}

    // Tampilkan informasi customer
    public void getDisplayCustomer() {
    System.out.println("---------------------------------------");
    System.out.println("           CUSTOMER INFORMATION");
    System.out.println("---------------------------------------");
    System.out.println("Customer ID : " + customerId);
    System.out.println("Name        : " + customerName);
    System.out.println("Address     : " + address);
    System.out.println("Phone       : " + phone);
    }
}

// class Product
class Product {
    private int productId;
    private float productPrice;
    private String productType;

    // Constructor
    public Product(int productId, String productName, float productPrice, String productType) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.productType = productType;
    }

    // Getter and Setter methods
    public int getProductId() {return productId;}
    public void setProductId(int productId) {this.productId = productId;}
    public float getProductPrice() {return productPrice;}
    public void setProductPrice(float productPrice) {this.productPrice = productPrice;}
    public String getProductType() {return productType;}
    public void setProductType(String productType) {this.productType = productType;}

    // Atribrut Sesuai Class
    public void addProduct() {System.out.println("Id: " + productId + " Product added.");}
    public void modifyProduct() {System.out.println("Id: " + productId + " Product modified.");}
    public void selectProduct(int productId) {System.out.println("Id: " + productId + " Product selected." );}

    // Tampilkan informasi produk
    public void getDisplayProduct() {
    System.out.println("---------------------------------------");
    System.out.println("           PRODUCT INFORMATION");
    System.out.println("---------------------------------------");
    System.out.println("Product ID : " + productId);
    System.out.println("Price      : Rp" + String.format("%.0f", productPrice));
    System.out.println("Type       : " + productType);
    }
}

// class Order
class Order {
    private int orderId;
    private Customer customer;
    private ArrayList<Product> productList;
    private float amount;
    private LocalDateTime orderDate;

    // Constructor
    public Order(int orderId, Customer customer, float amount) {
        this.orderId = orderId;
        this.customer = customer;
        this.amount = amount;
        this.productList = new ArrayList<Product>();
        this.orderDate = LocalDateTime.now(); 
    }

    // Getter and Setter methods
    public int getOrderId() {return orderId;}
    public void setOrderId(int orderId) {this.orderId = orderId;}
    public LocalDateTime getOrderDate() {return orderDate;}
    public void setOrderDate(LocalDateTime orderDate) {this.orderDate = orderDate;}
    public ArrayList<Product> getProductList() {return productList;}
    public void setProductList(ArrayList<Product> productList) {this.productList = productList;}
    public float getAmount() {return amount;}
    public void setAmount(float amount) {this.amount = amount;}

    // Atribrut Sesuai Class
    public void createOrder() {System.out.println("Order created. \nId: " + orderId + "\nBy: " + customer.getCustomerName()+ "\n======================");}
    public void editOrder(int orderId) {System.out.println("Id: " + orderId + " Order modified." );}
    public void addProductToOrder(Product p ) {productList.add(p); System.out.println("Id: " + p.getProductId() + " Product added to order." + orderId );}

    // Tampilkan informasi order
    public void getDisplayOrder() {
        System.out.println("---------------------------------------");
        System.out.println("           ORDER INFORMATION");
        System.out.println("---------------------------------------");
        System.out.println("Order ID     : " + orderId);
        System.out.println("Order Date   : " + orderDate);
        System.out.println("Customer     : " + customer.getCustomerName());
        System.out.println("Products     : " + productList.size());
        System.out.println("Total Amount : Rp" + String.format("%.0f", amount));
    }
}

// class Stock
class Stock {
    private Product product;
    private int quantity;
    private int shopNo;

    // Constructor
    public Stock(Product product, int quantity, int shopNo) {
        this.product = product;
        this.quantity = quantity;
        this.shopNo = shopNo;
    }

    // Getter and Setter methods
    public Product getProduct() {return product;}
    public void setProduct(Product product) {this.product = product;}
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public int getShopNo() {return shopNo;}
    public void setShopNo(int shopNo) {this.shopNo = shopNo;}

    // Atribrut Sesuai Class
    public void addStock() {System.out.println(" Stock added in " + product.getProductId() );}
    public void modifyStock(int productId) {System.out.println(" Stock modified to product " + productId);}
    public void selectStockItem(int productId) {System.out.println(" Stock selected for product " + productId );}

    // Tampilkan informasi stock
    public void getDisplayStock() {
        System.out.println("---------------------------------------");
        System.out.println("           STOCK INFORMATION");
        System.out.println("---------------------------------------");
        System.out.println("Product ID : " + product.getProductId());
        System.out.println("Quantity   : " + quantity);
        System.out.println("Shop No    : " + shopNo);
    }
}

// Main Class
public class DemoPenjualan {
    public static void main(String[] args) {
        // Display informasi
        System.out.println("\n======================== HASIL OUTPUT ========================");
        
        // Instansiasi objek Customer, Product, Order, dan Stock
        Customer customer1 = new Customer(1, "Rachmah Nur C", "Jaksel", "+620202020202");
        customer1.addCustomer();
        customer1.getDisplayCustomer(); // Menampilkan informasi customer

        Order order1 = new Order(1001, customer1, 0);
        order1.createOrder();// Menambahkan order
        order1.getDisplayOrder(); // Menampilkan informasi order

        Product product1 = new Product(101, "Laptop", 7800000f, "Electronics");
        Product product2 = new Product(102, "Smartphone", 4000000f, "Electronics");
        order1.addProductToOrder(product1); // Menambahkan produk ke order
        order1.addProductToOrder(product2);
        order1.setAmount(product1.getProductPrice() + product2.getProductPrice()); // Menghitung total jumlah
        order1.getDisplayOrder(); // Menampilkan informasi order setelah menambahkan produk

        // Create stock for the products
        Stock stock1 = new Stock(product1, 50, 2);
        Stock stock2 = new Stock(product1, 20, 1);
        stock1.addStock();
        stock2.addStock();
        stock1.getDisplayStock(); // Menampilkan informasi stock untuk produk 1
        stock2.getDisplayStock(); // Menampilkan informasi stock untuk produk 2


    }
} 