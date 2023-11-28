package Examples;

interface Delivery<T, S>{
    void deliver (T what, S how);
}

class PackageDelivery<T, S> implements Delivery<T, S>{
    @Override
    public void deliver(T what, S how) {
        System.out.println("Fast delivery of " + what + " by " + how);
    }
}

class Post<T, S> {
    private T pkg;
    private Delivery<T, S> deliveryService;
    public Post(Delivery<T,S> deliveryService){
        this.deliveryService = deliveryService;
    }
    public void sendPackage(T pkg, S how){
        this.pkg = pkg;
        deliveryService.deliver(pkg, how);
    }
    public T receivePackage(){
        return pkg;
    }
}
public class Generics {
    public static void main(String[] args) {
        Delivery<String, String> stringDeliveryService = new PackageDelivery<>();

        Post<String, String> stringPost = new Post<>(stringDeliveryService);
        stringPost.sendPackage("xBox", "Courier");
        System.out.println("Package received: " + stringPost.receivePackage());



        Delivery<Integer, String> integerDeliveryService = new PackageDelivery<>();

        Post<Integer, String> integerPost = new Post<>(integerDeliveryService);
        integerPost.sendPackage(1, "Meest Express");
        System.out.println("Package by number: " + integerPost.receivePackage() + " received.");
    }
}
