package br.com.tomasmuller.neo4jtemplate.models;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/sample-test-context.xml"})
@Transactional
public class SampleTest {

    @Autowired 
    Neo4jOperations template;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void actorCanPlayARoleInAMovie() {
        assertEquals("your truth", "your truth");
    }

}

