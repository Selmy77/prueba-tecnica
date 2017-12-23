package com.asdtest.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.asd.model.Active;
import com.asd.repository.ActiveRepository;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ActiveRepositoryTest {

    @Autowired
    private ActiveRepository repository;

    @Test
    public void repositorySavesParty() {
    	Active active = new Active();
        active.setName("Garden");
        
        Active result = repository.save(active);
        
        assertEquals(result.getName(), "Garden");
    }

}
