package com.fatmanur.test;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddFavouriteTest extends BaseTest {

    @Test
    public void testStepsFavourite() {

        new AddFavourite(driver).TestStepsFavourite("fatmanurbulacak@gmail.com","bulacak96","lg");

    }
}