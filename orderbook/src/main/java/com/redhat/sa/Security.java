package com.redhat.sa;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.Multi;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import java.math.BigDecimal;

@Entity
public class Security extends PanacheEntity {

    public Security() { }
    public Security(String ticker) { this.ticker = ticker; }

    @JsonView(Views.ShortView.class)
    @Column(length = 8, unique=true)
    public String ticker;
    @Column(nullable=false)
    public String name;
    public BigDecimal bid;
    //    public int volume;
    //    public int low;
    //    public int high;

    @JsonView(Views.LongView.class)
    public BigDecimal ask;
    //  public OrderBook orderBook

    @JsonView(Views.PrivateView.class)
    @Column(name="lastprice")
    public BigDecimal last;

    public static Uni<Security> findByTicker(String ticker) {
        return find("ticker",ticker).firstResult();
    }
    //TODO: remove this method, this is really just for debugging and has no paging support
    public static Multi<String> getAllTickers() {
        return Security.findAll().project(TickerDTO.class).stream().map(tickerDTOObj -> tickerDTOObj.ticker);
    }


}
