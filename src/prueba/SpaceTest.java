package prueba;



import aplicacion.*;
import presentacion.*;
import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;

/**
 * The test class senkuTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SpaceTest
{
    /**
     * Default constructor for test class senkuTest
     */
    public SpaceTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }
	@Test
	public void pruebaJUnit() {

		assertTrue(true);
    }
    @Test
	public void moverElemento() {
        try{
            Space sp = new Space();
            sp.addElemento("aplicacion.Calamar",300,400);
            Invasor calamar = sp.getInvasores().get(0);
            sp.mover(calamar, 1, 1);
            assertEquals(calamar.getPosicionInt()[0],51);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    @Test
	public void noDeberiaElementoCalamarQuedarseEnLaPosicionInicial() {
        try{
            Space sp = new Space();
            sp.addElemento("aplicacion.Calamar",300,400);
            Invasor calamar = sp.getInvasores().get(0);
            assertFalse(calamar.getPosicionInt()[0]==51);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    @Test
	public void DeberiaDispara() {
        try{
            Space sp = new Space();
            sp.addElemento("aplicacion.Calamar",300,400);
            Invasor calamar = sp.getInvasores().get(0);
            sp.disparo(calamar,false);
            
            assertEquals(sp.getDisparos().size(),1);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }


  /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}