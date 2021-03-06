package pl.simplestock.exchanges;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pl.simplestock.exchanges.Exchange;
import pl.simplestock.exchanges.ExchangeService;
import static org.junit.Assert.*;

/**
 *
 * @author Karolina
 */
public class ExchangeServiceTest {
    private ExchangeService service;
    
    @Before
    public void setUp() {
        service = new ExchangeService();
    }
    
    @After
    public void tearDown() {
        service = null;
    }

    @Test
    public void testCreate() {
        String exchangeSymbol = "xD";
        Exchange exchange = service.create(exchangeSymbol);
        
        assertEquals(exchangeSymbol, exchange.getSymbol());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testCreate_duplicate() {
        String exchangeSymbol = "xD";
        service.create(exchangeSymbol);
        service.create(exchangeSymbol);
    }
    
    @Test
    public void testHas_true() {
        String exchangeSymbol = "xD";
        Exchange exchange = service.create(exchangeSymbol);
        
        assertTrue(service.has(exchangeSymbol));
    }
    
    @Test
    public void testHas_false() {
        assertFalse(service.has("xD"));
    }
    
    @Test
    public void testGetOne() {
        String exchangeSymbol = "xD";
        service.create(exchangeSymbol);
        
        Exchange exchange = service.getOne(exchangeSymbol);
        
        assertNotNull(exchange);
        assertEquals(exchangeSymbol, exchange.getSymbol());
    }
    
    @Test(expected=NoSuchElementException.class)
    public void testGetOne_missing() {
        Exchange exchange = service.getOne("nonexistent");
    }
}
