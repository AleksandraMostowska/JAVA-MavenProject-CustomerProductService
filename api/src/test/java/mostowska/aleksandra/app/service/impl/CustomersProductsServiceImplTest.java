package mostowska.aleksandra.app.service.impl;

import lombok.RequiredArgsConstructor;
import mostowska.aleksandra.app.repository.impl.CustomersProductsRepositoryImpl;
import mostowska.aleksandra.app.service.ProductData;
import mostowska.aleksandra.app.service.extensions.CustomersProductsServiceImplResolver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@ExtendWith(CustomersProductsServiceImplResolver.class)
@RequiredArgsConstructor
public class CustomersProductsServiceImplTest {
    private final CustomersProductsServiceImpl service;

    @TestFactory
    Stream<DynamicTest> getProductAndHowManyTimesWasBoughtTest() {
        var expectedProductsCount = Map.of(
                ProductData.PRODUCT_1, 3,
                ProductData.PRODUCT_2, 2,
                ProductData.PRODUCT_3, 2
        );
        var emptyService = new CustomersProductsServiceImpl(
                new CustomersProductsRepositoryImpl(new HashMap<>()));

        return Stream.of(
                DynamicTest.dynamicTest(
                        "Test when products' list is not empty",
                        () -> Assertions.assertEquals(service.getProductAndHowManyTimesWasBought(), expectedProductsCount)
                ),
                DynamicTest.dynamicTest(
                        "Test when products' list is empty",
                        () -> Assertions.assertEquals(emptyService.getProductAndHowManyTimesWasBought(), new HashMap<>())
                )
        );
    }

    @Test
    @DisplayName("Timeout test for method getCustomersWhoPaidTheMost")
    void getCustomersWhoPaidTheMostTimeoutTest() {
        Assertions.assertTimeout(Duration.ofMillis(5), service::getCustomersWhoBoughtTheMostItems);
    }
}
