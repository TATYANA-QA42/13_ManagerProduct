package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.*;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(11, "Евгений Онегин", 450, "Пушкин");
    Book book2 = new Book(14, "Война и мир", 450, "Толстой");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
    }

    @Test
    public void testsMatchesT() {
        boolean expected = true;
        boolean actual = manager.matches(book2, "Война и мир");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesF() {
        boolean expected = false;
        boolean actual = manager.matches(book2, "rthkgj");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSearchBy() {
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Война и мир");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testFindAll() {
        Product[] expected = {book1, book2};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveById() {
        Product[] expected = {book1};
        Product[] actual = repo.removeById(14);
        Assertions.assertArrayEquals(expected, actual);
    }
}
