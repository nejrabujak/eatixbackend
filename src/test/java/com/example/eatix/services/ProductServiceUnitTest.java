package com.example.eatix.services;

import com.example.eatix.data.ProductTest;
import com.example.eatix.models.Product;
import com.example.eatix.repositories.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.mockito.Mockito.times;import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class ProductServiceUnitTest {

    @MockBean
    private ProductRepository productRepository;

    @TestConfiguration
    static class ProductServiceTestContextConfiguration {

        @Bean
        @Primary
        public ProductService productService(ProductRepository productRepository) {
            return new ProductService(productRepository);
        }
    }

    @Autowired
    private ProductService productService;

    @Test
    public void givenProduct_whenGetProduct_thenListShouldBeFound() {
        Mockito.when(productRepository.findAll())
                .thenReturn(List.of(ProductTest.product()));

        List<Product> returnedList = productService.getProducts();

        assertThat(returnedList).hasSize(1);
    }

    @Test
    public void givenNoProducts_whenGetProducts_thenListShouldBeEmpty() {
        assertThat(productService.getProducts()).isEmpty();
    }

    @Test
    public void givenValidId_whenGetById_thenProductShouldBeFound() {
        Product product = ProductTest.product();

        Mockito.when(productRepository.findById(product.getId()))
                .thenReturn(Optional.of(product));

        Product resultProduct = productService.getById(product.getId());

        assertThat(resultProduct.getName())
                .isEqualTo(product.getName());
    }

    @Test
    public void givenInvalidId_whenGetById_thenExceptionShouldBeThrown() {
        assertThatThrownBy(() -> productService.getById(2L))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("does not exist");
    }

    @Test
    public void givenProduct_whenCreate_thenIdAssigned() {
        Product inputProduct = ProductTest.product();
        inputProduct.setId(0L); // reset id
        Product outputStore = ProductTest.product();

        Mockito.when(productRepository.save(inputProduct))
                .thenReturn(outputStore);

        Product resultStore = productService.create(inputProduct);

        assertThat(resultStore.getId()).isNotEqualTo(0L);
    }

    @Test
    public void givenProduct_whenCreate_thenStoreReturned() {
        Product inputProduct = ProductTest.product();
        inputProduct.setId(0L); // reset id
        Product outputProduct = ProductTest.product();

        Mockito.when(productRepository.save(inputProduct))
                .thenReturn(outputProduct);

        Product resultProduct = productService.create(inputProduct);

        assertThat(resultProduct).isNotNull();
        assertThat(resultProduct.getName()).isEqualTo(inputProduct.getName());
    }

    @Test
    public void givenProduct_whenCreate_thenRepositoryCalled() {
        Product product = ProductTest.product();

        productService.create(product);

        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void givenStore_whenDelete_thenRepositoryCalled() {
        long id = 2L;

        productService.delete(id);

        verify(productRepository, times(1)).deleteById(id);
    }

}