package praktikum.stellarburgers.order;

public class CreateOrderSuccessInfo {
    private String name;
    private CreateOrderOrderData order;
    private String success;

    public CreateOrderSuccessInfo(String name, CreateOrderOrderData order, String success) {
        this.name = name;
        this.order = order;
        this.success = success;
    }

    public CreateOrderSuccessInfo() { }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public CreateOrderOrderData getOrder() { return order; }
    public void setOrder(CreateOrderOrderData createOrderOrderData) { this.order = createOrderOrderData; }

    public String getSuccess() { return success; }
    public void setSuccess(String success) { this.success = success; }

    @Override
    public String toString() {
        return "( name: '" + name +
                "', order: '" + order +
                "', success: '" + success + "' )";
    }
}
