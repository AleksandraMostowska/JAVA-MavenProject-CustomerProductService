package mostowska.aleksandra.app.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import mostowska.aleksandra.app.repository.CustomersProductsRepository;
import mostowska.aleksandra.app.service.CustomersProductService;
import mostowska.aleksandra.categoriesAndProducts.products.Product;
import mostowska.aleksandra.categoriesAndProducts.products.ProductMapper;
import mostowska.aleksandra.categoriesAndProducts.products.ProductUtils;
import mostowska.aleksandra.categoriesAndProducts.customers.Customer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@ToString
public class CustomersProductsServiceImpl implements CustomersProductService {
    private final CustomersProductsRepository customersProductsRepository;

    @Override
    public List<Customer> getCustomersWhoBoughtTheMostItems() {
        return customersProductsRepository.customersWithProducts()
                .entrySet()
                .stream()
                .collect(Collectors.groupingBy(
                        entry -> entry.getValue().size(),
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .orElseThrow();
    }

    @Override
    public List<Customer> getCustomersWhoPaidTheMost() {
        return customersProductsRepository.customersWithProducts()
                .entrySet()
                .stream()
                .collect(Collectors.groupingBy(
                        entry -> ProductUtils.getTotalSpending(entry.getValue()),
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .orElseThrow();
    }

    @Override
    public Map<Product, Integer> getProductAndHowManyTimesWasBought() {
        return customersProductsRepository.customersWithProducts()
                .values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(
                        product -> product,
                        Collectors.summingInt(product -> 1)
                ));
    }

    @Override
    public List<String> getCategoriesSortedFromMostToLeastPopular() {
        return customersProductsRepository.customersWithProducts()
                .values()
                .stream()
                .flatMap(List::stream)
                .map(ProductMapper.toCategory)
                .collect(Collectors.groupingBy(
                        category -> category,
                        Collectors.summingInt(category -> 1)
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .toList();
    }
}
