package ru.wiseman.onlinecurrencyconverter.domain;

import lombok.Data;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Data
public class ExchangeRate {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "rate")
    private float rate;

    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    protected ExchangeRate() {
    }

    public ExchangeRate(float rate, Date timestamp) {
        Assert.isTrue(rate > 0, "Rate must be greater than 0");
        Assert.notNull(timestamp, "Timestamp must not be empty");

        this.rate = rate;
        this.timestamp = timestamp;
    }
}
