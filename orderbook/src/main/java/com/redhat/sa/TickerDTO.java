package com.redhat.sa;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
class TickerDTO {
    public final String ticker;

    public TickerDTO(String ticker) {
        this.ticker = ticker;
    }
}