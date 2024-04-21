package tests;

import org.junit.Test;
public class RefactoredCartTest extends TestBase{
    @Test
    public void refactoredCartTest() {
        for (int i = 1; i <=3; i++) {
            app.selectProduct();
            app.addSelectedProductToCart();
            assert (app.getNumberOfItemsInCart() == i);
        }
        for (int i = 2; i >= 0; i--) {
            app.removeProductFromCart();
            assert (app.getNumberOfItemsInCart() == i);
        }
    }
}
