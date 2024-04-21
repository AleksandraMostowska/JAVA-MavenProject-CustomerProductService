package mostowska.aleksandra.categoriesAndProducts.customers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@ToString
public class Customer {
    final int id;
    final String firstName;
    final String lastName;
    final int age;
    final BigDecimal cash;
    @Getter
    final List<Integer> preferences;
}
