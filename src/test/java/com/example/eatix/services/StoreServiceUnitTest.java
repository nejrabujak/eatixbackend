package com.example.eatix.services;

import com.example.eatix.data.StoreTest;
import com.example.eatix.models.Store;
import com.example.eatix.repositories.StoreRepository;
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
public class StoreServiceUnitTest {

    @MockBean
    private StoreRepository storeRepository;

    @TestConfiguration
    static class StoreServiceTestContextConfiguration {

        @Bean
        @Primary
        public StoreService storeService(StoreRepository storeRepository) {
            return new StoreService(storeRepository);
        }
    }

    @Autowired
    private StoreService storeService;

    @Test
    public void givenStore_whenGetStore_thenListShouldBeFound() {
        Mockito.when(storeRepository.findAll())
                .thenReturn(List.of(StoreTest.store()));

        List<Store> returnedList = storeService.getStores();

        assertThat(returnedList).hasSize(1);
    }

    @Test
    public void givenNoStores_whenGetStores_thenListShouldBeEmpty() {
        assertThat(storeService.getStores()).isEmpty();
    }

    @Test
    public void givenValidId_whenGetById_thenStoreShouldBeFound() {
        Store store = StoreTest.store();

        Mockito.when(storeRepository.findById(store.getId()))
                .thenReturn(Optional.of(store));

        Store resultStore = storeService.getById(store.getId());

        assertThat(resultStore.getName())
                .isEqualTo(store.getName());
    }

    @Test
    public void givenInvalidId_whenGetById_thenExceptionShouldBeThrown() {
        assertThatThrownBy(() -> storeService.getById(2L))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("does not exist");
    }

    @Test
    public void givenStore_whenCreate_thenIdAssigned() {
        Store inputStore = StoreTest.store();
        inputStore.setId(0L); // reset id
        Store outputStore = StoreTest.store();

        Mockito.when(storeRepository.save(inputStore))
                .thenReturn(outputStore);

        Store resultStore = storeService.create(inputStore);

        assertThat(resultStore.getId()).isNotEqualTo(0L);
    }

    @Test
    public void givenStore_whenCreate_thenStoreReturned() {
        Store inputStore = StoreTest.store();
        inputStore.setId(0L); // reset id
        Store outputStore = StoreTest.store();

        Mockito.when(storeRepository.save(inputStore))
                .thenReturn(outputStore);

        Store resultStore = storeService.create(inputStore);

        assertThat(resultStore).isNotNull();
        assertThat(resultStore.getName()).isEqualTo(inputStore.getName());
    }

    @Test
    public void givenStore_whenCreate_thenRepositoryCalled() {
        Store store = StoreTest.store();

        storeService.create(store);

        verify(storeRepository, times(1)).save(store);
    }

    @Test
    public void givenStoreAndValidId_whenUpdate_thenStoreReturned() {
        Store inputStore = StoreTest.store();
        inputStore.setId(0L); // reset id
        long id = 2L;
        Store outputStore = StoreTest.store();
        outputStore.setId(id);

        Mockito.when(storeRepository.findById(id))
                .thenReturn(Optional.of(outputStore));
        Mockito.when(storeRepository.save(inputStore))
                .thenReturn(outputStore);


    }


    @Test
    public void givenStore_whenDelete_thenRepositoryCalled() {
        long id = 2L;

        storeService.delete(id);

        verify(storeRepository, times(1)).deleteById(id);
    }

}