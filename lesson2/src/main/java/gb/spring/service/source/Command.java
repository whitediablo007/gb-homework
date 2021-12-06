package gb.spring.service.source;

public enum Command {
    ADD("Add new product in cart"),
    REMOVE("Remove product from cart, the product must be in the cart."),
    CLEAR("Clear cart."),
    SHOW("Show all items in cart."),
    EXIT("Exit from app."),
    HELP("Show help.");

    private final String clarification;

    Command(String clarification) {
        this.clarification = clarification;
    }

    public String getClarification() {
        return this.clarification;
    }

}
