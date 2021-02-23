package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ProfilesTest {

    @Test
    public void collectTesting() {
        List<Profile> list = new ArrayList<Profile>(Arrays.asList(
                new Profile(new Address("Moscow")),
                new Profile(new Address("Moscow")),
                new Profile(new Address("Saint-Petersburg"))
        )
        );
        List<Address> testList = Profiles.collect(list);
        List<Address> expeced = new ArrayList(Arrays.asList(
                new Address("Moscow"),
                new Address("Saint-Petersburg")
        ));
        assertThat(testList, is(expeced));
    }

}