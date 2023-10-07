/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import crud.Evenement;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ZAHRA
 */
public class serviceEvenementTest {
    
    public serviceEvenementTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ajouter method, of class serviceEvenement.
     */
    @Test
    public void testAjouter() {
        System.out.println("ajouter");
        Evenement E = null;
        serviceEvenement instance = new serviceEvenement();
        instance.ajouter(E);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficher method, of class serviceEvenement.
     */
    @Test
    public void testAfficher_0args() {
        System.out.println("afficher");
        serviceEvenement instance = new serviceEvenement();
        List<Evenement> expResult = null;
        List<Evenement> result = instance.afficher();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficher method, of class serviceEvenement.
     */
    @Test
    public void testAfficher_Evenement() {
        System.out.println("afficher");
        Evenement E1 = null;
        serviceEvenement instance = new serviceEvenement();
        instance.afficher(E1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
