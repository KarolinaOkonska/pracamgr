package pl.simplestock.injector;

import com.google.inject.AbstractModule;

import pl.simplestock.calculators.ExchangeCalculator;
import pl.simplestock.calculators.IExchangeCalculator;
import pl.simplestock.calculators.IStockCalculator;
import pl.simplestock.calculators.StockCalculator;
import pl.simplestock.exchanges.ExchangeService;
import pl.simplestock.exchanges.IExchangeService;
import pl.simplestock.stocks.IStockService;
import pl.simplestock.stocks.StockService;
import pl.simplestock.trades.ITradeService;
import pl.simplestock.trades.TradeService;

/**
 *
 * @author Martin
 */
public class AppInjector extends AbstractModule {

    @Override
    protected void configure() {
        bind(ITradeService.class).to(TradeService.class);
        bind(IStockService.class).to(StockService.class);
        bind(IExchangeService.class).to(ExchangeService.class);
        bind(IStockCalculator.class).to(StockCalculator.class);
        bind(IExchangeCalculator.class).to(ExchangeCalculator.class);
    }
}
